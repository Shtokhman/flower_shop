package flowershop;


import flowershop.cart.Cart;
import flowershop.cart.PriorityCart;
import flowershop.cart.SimpleCart;
import flowershop.entity.Bouquet;
import flowershop.entity.Flower;
import flowershop.payment.CardPayment;
import flowershop.payment.CashPayment;
import flowershop.payment.Payment;
import flowershop.service.FlowerShop;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ListIterator;

public class FlowerShopApplication {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final FlowerShop SHOP = FlowerShop.getInstance();
    private static Cart cart;

    @SneakyThrows
    public static void main(String[] args) {
        while (true) {
            printMenu();

            switch (BR.readLine()) {
                case "1":
                    buyBouquet();
                    break;
                case "2":
                    createCustomBouquet();
                    break;
                case "3":
                    printAllBouquets();
                    break;
                case "4":
                    printAllFlowers();
                    break;
                case "5":
                    payOff();
                    break;
                case "6":
                    printCartContent();
                    break;
                case "0":
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("Wrong input, try one more time");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - buy bouquet");
        System.out.println("2 - create custom bouquet");
        System.out.println("3 - print all bouquets");
        System.out.println("4 - print all flowers");
        System.out.println("5 - pay off");
        System.out.println("6 - print cart content");
    }

    @SneakyThrows
    public static void buyBouquet() {
        printAllBouquets();
        Integer index = Integer.valueOf(BR.readLine());
        Bouquet bouquet = SHOP.getBouquetByIndex(index);
        addBouquetToShopCart(bouquet);
    }

    @SneakyThrows
    public static void createCustomBouquet() {
        Bouquet bouquet = new Bouquet();
        while (true) {
            printAllFlowers();
            System.out.println("Select one: ");
            Integer index = Integer.valueOf(BR.readLine());
            System.out.println("You selected: " + SHOP.getFlowerByIndex(index));
            System.out.println("Enter count: ");
            Integer count = Integer.valueOf(BR.readLine());
            SHOP.createBouquet(SHOP.getFlowerByIndex(index), count, bouquet);
            System.out.println("If you want to add some more flowers to your bouquet enter - 1");
            if (!BR.readLine().equals("1")) break;
        }

        addBouquetToShopCart(bouquet);
    }

    @SneakyThrows
    public static void payOff() {
        if (cart == null) {
            System.out.println("You do not buy anything yet");
            return;
        }
        System.out.println("Total price: " + cart.calculatePrice());
        System.out.println("Select payment method: ");
        System.out.println("1 - cash");
        System.out.println("2 - card");
        Payment payment = null;
        switch (BR.readLine()) {
            case "1":
                payment = new CashPayment();
            case "2":
                payment = new CardPayment();
            default:
                System.out.println("Wrong input, try one more time");
                payOff();
        }
        System.out.println("Enter payment data");
        payment.proceed(BR.readLine(), cart.calculatePrice());
        System.out.println("Thank you for your purchase");
        cart = null;
    }

    public static void printAllBouquets() {
        for (ListIterator<Bouquet> i = SHOP.getBouquets().listIterator(); i.hasNext();) {
            System.out.println(i.nextIndex() + ". " + i.next());
        }
    }

    public static void printAllFlowers() {
        for (ListIterator<Flower> i = SHOP.getFlowers().listIterator(); i.hasNext();) {
            System.out.println(i.nextIndex() + ". " + i.next());
        }
    }

    public static void printCartContent() {
        for (ListIterator<Bouquet> i = cart.getBouquets().listIterator(); i.hasNext();) {
            System.out.println(i.nextIndex() + ". " + i.next());
        }
    }

    @SneakyThrows
    private static void addBouquetToShopCart(Bouquet bouquet) {
        System.out.println("Your bouquet " + bouquet);
        System.out.println("Price " + SHOP.getBouquetPrice(bouquet));
        if (cart == null) {
            System.out.println("You must select shopping cart: ");
            System.out.println("1 - Simple");
            System.out.println("2 - Priority(over price is " + PriorityCart.OVERPRICE + ")");
            switch (BR.readLine()) {
                case "1":
                    cart = new SimpleCart();
                    break;
                case "2":
                    cart = new PriorityCart(new SimpleCart());
                    break;
                default:
                    System.out.println("Wrong input, try one more time");
                    addBouquetToShopCart(bouquet);
            }
        }
    }
}
