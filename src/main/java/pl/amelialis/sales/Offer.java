package pl.amelialis.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.amelialis.productcatalog.Product;

public class Offer {
    BigDecimal total;
    List<Product> items;
    Integer itemsCount;

    public Offer() {
        this.total = BigDecimal.ZERO;
        this.itemsCount = 0;
        this.items = new ArrayList<>();
    }

    public Offer(BigDecimal total, int size) {
        this.total = total;
        this.itemsCount = size;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
