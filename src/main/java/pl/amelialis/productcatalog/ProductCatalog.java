package pl.amelialis.productcatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog(){
        this.products = loadDatabase();
    }

    public ArrayList<Product> allProducts(){
        return products;
    }

    public ArrayList<Product> loadDatabase(){
        ArrayList<Product> database = new ArrayList<Product>();
        /*database.add(new Product(UUID.randomUUID(),"Name 1", "desc", "image",false,  BigDecimal.valueOf(1), "red", "Bear", "big"));
        database.add(new Product(UUID.randomUUID(),"Name 2", "desc", "image",false, BigDecimal.valueOf(1), "red", "Sheep", "medium"));
        database.add(new Product(UUID.randomUUID(),"Name 3", "desc", "image", false, BigDecimal.valueOf(1), "red", "Octopus", "small"));*/
        return database;
    }

    //Seller -> Add product
    public String addProduct(String name,String description, String image, Boolean isPublished, BigDecimal price, String color, String type,String size){
        Product newProduct = new Product(
                UUID.randomUUID(),
                name,
                description,
                image,
                isPublished,
                price,
                color,
                type,
                size
        );
        products.add(newProduct);

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
        ArrayList<Product> allProducts = allProducts();
        for (Product product : allProducts){
            if(product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }
}
