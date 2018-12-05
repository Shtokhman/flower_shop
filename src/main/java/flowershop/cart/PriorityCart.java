package flowershop.cart;

public class PriorityCart extends CartDecorator {
    public static final long OVERPRICE = 50;

    public PriorityCart(Cart decoratedCart) {
        super(decoratedCart);
    }

    @Override
    public long calculatePrice() {
        System.out.println("You selected Priority cart, you pay " + OVERPRICE + " over standart price");
        return super.calculatePrice() + OVERPRICE;
    }
}
