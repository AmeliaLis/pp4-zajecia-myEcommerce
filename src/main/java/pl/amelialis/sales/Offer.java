package pl.amelialis.sales;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    Integer itemsCount;

    public Offer() {
        this.total = BigDecimal.ZERO;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
