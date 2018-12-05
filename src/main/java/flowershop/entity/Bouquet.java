package flowershop.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Bouquet {
    private List<FlowerForOrder> flowers = new ArrayList<>();

    public Bouquet(List<FlowerForOrder> flowers) {
        this.flowers = flowers;
    }

    public Bouquet(FlowerForOrder... flowers) {
        this.flowers = new ArrayList<>(Arrays.asList(flowers));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FlowerForOrder flower : flowers) {
            sb.append(flower.getCount());
            sb.append('x');
            sb.append(flower.getFlower());
            sb.append('\n');
        }
        sb.setCharAt(sb.length() - 1, ' ');
        return sb.toString();
    }
}
