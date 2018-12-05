package flowershop.entity;

public class Rosie extends Flower {
    private boolean spikes;

    public Rosie(String color, int stemLength, String odor, String county, long price, boolean spikes) {
        super(color, stemLength, odor, county, price);
        this.spikes = spikes;
    }
}
