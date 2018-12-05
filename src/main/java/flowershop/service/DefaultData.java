package flowershop.service;

import flowershop.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultData {
    private static DefaultData instance;

    private List<Bouquet> bouquets = new ArrayList<>();
    private List<Flower> flowers = new ArrayList<>();

    private DefaultData() {

    }

    public static DefaultData getInstance() {
        if (instance == null) {
            instance = new DefaultData();
            instance.initFlowersAndBouquets();
        }
        return instance;
    }

    private void initFlowersAndBouquets() {
        Flower flower1 = new Rosie("Red", 70, "good", "Ukraine", 20, true);
        Flower flower2 = new Rosie("White", 70, "good", "Ukraine", 16, true);
        Flower flower3 = new Rosie("Red", 100, "good", "Ukraine", 25, false);
        Flower flower4 = new Tulip("Orange", 40, "good", "Ukraine", 15);
        Flower flower5 = new Tulip("Yellow", 40, "good", "Ukraine", 14);
        Flower flower6 = new Chamomile("White", 30, "good", "Ukraine", 10);
        flowers.addAll(Arrays.asList(flower1, flower2, flower3, flower4, flower5, flower6));

        FlowerShop flowerShop = FlowerShop.getInstance();
        Bouquet bouquet1 = flowerShop.createBouquet(flower4, 10, null);
        flowerShop.createBouquet(flower5, 15, bouquet1);
        Bouquet bouquet2 = flowerShop.createBouquet(flower3, 101, null);
        Bouquet bouquet3 = flowerShop.createBouquet(flower6, 33, null);
        bouquets.addAll(Arrays.asList(bouquet1, bouquet2, bouquet3));
    }


    public List<Bouquet> getBouquets() {
        return bouquets;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}
