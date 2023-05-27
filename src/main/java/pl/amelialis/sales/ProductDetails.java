package pl.amelialis.sales;

import java.math.BigDecimal;

public class ProductDetails {
    private String productId;
    private String name;
    private BigDecimal price;
    private String desc;



    public ProductDetails(String productId, String name, BigDecimal price, String desc) {
        this.productId=productId;
        this.name=name;
        this.price=price;
        this.desc = desc;
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
    public String getDescription() {
        return desc;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
