package pl.amelialis.sales.productdetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductDetailsProvider implements ProductDetailsProvider {

    List<ProductDetails> productDetails;
    public InMemoryProductDetailsProvider() {
        this.productDetails = new ArrayList<>();
    }

    public Optional<ProductDetails> loadForProduct(String productId) {
        return productDetails.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
    }

    public void add(ProductDetails details) {
        this.productDetails.add(details);
    }
}