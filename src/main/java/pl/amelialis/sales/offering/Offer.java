package pl.amelialis.sales.offering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.amelialis.productcatalog.Product;

public class Offer {

    private final List<OfferLine> lines;
    private final BigDecimal total;

    public Offer(List<OfferLine> lines, BigDecimal total) {
        this.lines = lines;
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getProductsCount() {
        return lines.size();
    }

    public List<OfferLine> getOrderLines() {
        return lines;
    }
}