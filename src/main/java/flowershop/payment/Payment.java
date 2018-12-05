package flowershop.payment;

import java.math.BigDecimal;

public interface Payment {
    void proceed(String payer, long price);
}
