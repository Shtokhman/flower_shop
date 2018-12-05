package flowershop.service;

import flowershop.entity.Bouquet;
import flowershop.entity.Flower;
import flowershop.entity.FlowerForOrder;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private static FlowerShop instance;

    private List<Flower> flowers;
    private List<Bouquet> bouquets;

    private FlowerShop() {
        DefaultData defaultData = DefaultData.getInstance();
        flowers = new ArrayList<>(defaultData.getFlowers());
        bouquets = new ArrayList<>(defaultData.getBouquets());
    }

    public static FlowerShop getInstance() {
        if (instance == null) {
            instance = new FlowerShop();
        }
        return instance;
    }

    public Bouquet createBouquet(Flower flower, int count, Bouquet bouquet) {
        if (bouquet == null) {
            bouquet = new Bouquet();
        }
        bouquet.getFlowers().add(new FlowerForOrder(flower, count));

        return bouquet;
    }

    public Flower getFlowerByIndex(int index) {
        return flowers.get(index);
    }

    public Bouquet getBouquetByIndex(int index) {
        return bouquets.get(index);
    }

    public long getBouquetPrice(Bouquet bouquet) {
        return getFlowersPrice(bouquet.getFlowers());
    }

    public long getFlowersPrice(List<FlowerForOrder> flowers) {
        long price = 0;
        for (FlowerForOrder flower : flowers) {
            price += flower.getFlower().getPrice() * flower.getCount();
        }
        return price;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Bouquet> getBouquets() {
        return bouquets;
    }
}
