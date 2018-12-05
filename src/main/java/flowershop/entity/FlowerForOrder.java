package flowershop.entity;

import lombok.Data;

@Data
public class FlowerForOrder {
    private Flower flower;
    private int count;

    public FlowerForOrder(Flower flower, int count) {
        this.flower = flower;
        this.count = count;
    }
}
