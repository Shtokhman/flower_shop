package flowershop.payment;

import java.math.BigDecimal;

public class CashPayment implements Payment {
    @Override
    public void proceed(String payer, long price) {
        System.out.println(payer + " made payment with cash");
        System.out.println("total: " + price);
    }
}
