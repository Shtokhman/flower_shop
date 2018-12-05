package flowershop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Flower {
    private String color;
    private int stemLength;
    private String odor;
    private String county;
    private long price;

    public Flower(String color, int stemLength, String odor, String county, long price) {
        this.color = color;
        this.stemLength = stemLength;
        this.odor = odor;
        this.county = county;
        this.price = price;
    }
}
