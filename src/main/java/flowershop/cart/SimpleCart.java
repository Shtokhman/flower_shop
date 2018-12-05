package flowershop.cart;

import flowershop.entity.Bouquet;
import flowershop.entity.FlowerForOrder;
import flowershop.service.FlowerShop;

import java.util.ArrayList;
import java.util.List;


public class SimpleCart implements Cart {

    private List<Bouquet> bouquets = new ArrayList<>();

    public SimpleCart() {
    }

    @Override
    public void addBouquet(Bouquet bouquet) {
        this.bouquets.add(bouquet);
    }

    @Override
    public long calculatePrice() {
        long result = 0;
        for (Bouquet bouquet : bouquets) {
            result += FlowerShop.getInstance().getBouquetPrice(bouquet);
        }
        return result;
    }

    @Override
    public List<Bouquet> getBouquets() {
        return bouquets;
    }
}
