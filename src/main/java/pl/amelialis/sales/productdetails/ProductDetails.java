package pl.amelialis.sales.productdetails;

import java.math.BigDecimal;

public class ProductDetails {
    private final String productId;
    private final String name;
    private final BigDecimal price;

    public ProductDetails(String productId, String name, BigDecimal price) {
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
