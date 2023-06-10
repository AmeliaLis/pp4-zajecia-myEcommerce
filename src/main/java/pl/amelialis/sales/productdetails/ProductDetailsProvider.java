package pl.amelialis.sales.productdetails;

import pl.amelialis.sales.ProductDetails;

import java.util.Optional;

public interface ProductDetailsProvider {
    Optional<ProductDetails> loadForProduct(String productId);
}
