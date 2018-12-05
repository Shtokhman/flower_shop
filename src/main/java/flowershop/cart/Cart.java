package flowershop.cart;

import flowershop.entity.Bouquet;
import flowershop.entity.FlowerForOrder;

import java.util.List;

public interface Cart {
    void addBouquet(Bouquet bouquet);

    long calculatePrice();

    List<Bouquet> getBouquets();
}
