package pl.amelialis.sales.productdetails;

import java.util.Optional;

public interface ProductDetailsProvider {
    Optional<ProductDetails> loadForProduct(String productId);
}
