package pl.amelialis.productcatalog;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String description;
    private String image;
    private boolean isPublished;
    private BigDecimal price;
    private final String color;
    private final String type;
    private final String size;


    public Product(UUID uuid, String name, String desc, String image, boolean isPublished, BigDecimal price, String color, String type, String size) {
        this.uuid = uuid.toString();
        this.name = name;
        this.description = desc;
        this.image = image;
        this.isPublished = isPublished;
        this.price = price;
        this.color = color;
        this.type = type;
        this.size = size;
    }

    public String getId() {
        return uuid;
    }

    public UUID getUUID(){
        return UUID.fromString(uuid);
    }

    public void setPrice(BigDecimal price){
        this.price=price;
    }

    public void setImage(String image){
        this.image=image;
    }

    public void setIsPublished(Boolean isPublished){
        if (this.image == null || this.price == null){
            throw new ProductImageOrPriceIsNotDefined();
        }
        this.isPublished = isPublished;
    }

    public Map<String,Object> getProductInfo() {
        Map<String, Object> productInfo = new HashMap<>();
        productInfo.put("uuid", this.uuid);
        productInfo.put("name", this.name);
        productInfo.put("desc", this.description);
        productInfo.put("image", this.image);
        productInfo.put("isPublished", this.isPublished);
        productInfo.put("price", this.price);
        productInfo.put("color", this.color);
        productInfo.put("x", this.type);
        productInfo.put("y", this.size);

        return productInfo;
    }
}
