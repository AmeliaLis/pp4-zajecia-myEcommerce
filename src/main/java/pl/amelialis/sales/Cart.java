package pl.amelialis.sales;

import pl.amelialis.productcatalog.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<ProductDetailsProvider,Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }
    public static Cart empty(){
        return new Cart();
    }

    public void add(ProductDetailsProvider product) {
        products.put(product, 1);
    }

    public int itemsCount() {
        return products.size();
    }
}
