package flowershop.payment;

import java.math.BigDecimal;

public class CardPayment implements Payment {
    @Override
    public void proceed(String payer, long price) {

        System.out.println(payer + " made payment with card");
        System.out.println("total: " + price);
    }
}
