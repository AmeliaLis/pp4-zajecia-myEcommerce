package pl.amelialis.sales;

import pl.amelialis.productcatalog.HashMapProductStorage;
import pl.amelialis.productcatalog.Product;
import pl.amelialis.productcatalog.ProductCatalog;
import pl.amelialis.productcatalog.ProductStorage;

import java.util.List;
import java.util.Optional;
public class ProductDetailsProvider {
    public Optional<ProductDetails> loadCartForProduct(String productId) {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        ProductDetails productDetails = new ProductDetails(productCatalog.loadById(productId).getId(), productCatalog.loadById(productId).getName(), productCatalog.loadById(productId).getPrice());
        return Optional.of(productDetails);

    }
}
