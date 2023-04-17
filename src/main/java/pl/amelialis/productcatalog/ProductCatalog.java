package pl.amelialis.productcatalog;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {

    private ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts(){
        return productStorage.allProducts();
    }

    public ArrayList<Product> loadDatabase(){
        ArrayList<Product> database = new ArrayList<Product>();
        return database;
    }

    //Seller -> Add product
    public String addProduct(String name,String description, String color, String type,String size){
        Product newProduct = new Product(
                UUID.randomUUID(),
                name,
                description,
                color,
                type,
                size
        );

        productStorage.add(newProduct);

        return newProduct.getId();
    }

    public void changePriceById(String id,BigDecimal price){
        loadById(id).setPrice(price);
    }

    public void changeImageById(String id,String image){
        loadById(id).setImage(image);
    }

    //ERP -> Publish product
    public void changeVisibilityById(String id,Boolean isPublished){
        loadById(id).setIsPublished(isPublished);
    }

    public Product loadById(String productId) {
        return productStorage.loadById(productId);
    }

    public List<Product> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }

    public void publishProduct(String productId) {
        Product loaded = loadById(productId);
        if (loaded.getPrice() == null){
            throw new ProductCantBePublishedException();
        }

        if (loaded.getImage() == null){
            throw new ProductCantBePublishedException();
        }

        loaded.setIsOnline(true);
    }
}
