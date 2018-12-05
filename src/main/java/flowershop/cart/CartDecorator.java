package flowershop.cart;


import flowershop.entity.Bouquet;
import flowershop.entity.FlowerForOrder;

import java.util.List;

public abstract class CartDecorator implements Cart {
    protected Cart decoratedCart;

    public CartDecorator(Cart decoratedCart) {
        this.decoratedCart = decoratedCart;
    }

    @Override
    public void addBouquet(Bouquet bouquet) {
        decoratedCart.addBouquet(bouquet);
    }

    @Override
    public long calculatePrice() {
        return decoratedCart.calculatePrice();
    }

    @Override
    public List<Bouquet> getBouquets() {
        return decoratedCart.getBouquets();
    }
}
