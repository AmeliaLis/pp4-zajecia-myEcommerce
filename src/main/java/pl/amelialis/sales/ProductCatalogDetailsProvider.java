package pl.amelialis.sales;

import pl.amelialis.productcatalog.Product;
import pl.amelialis.productcatalog.ProductCatalog;

import java.util.Optional;

public class ProductCatalogDetailsProvider implements ProductDetailsProvider {
    ProductCatalog productCatalog;

    public ProductCatalogDetailsProvider(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public Optional<ProductDetails> loadForProduct(String productId) {
        Product product = productCatalog.loadById(productId);
        if (product == null) {
            return Optional.empty();
        }

        return Optional.of(new ProductDetails(
                product.getId(),
                product.getName(),
                product.getPrice()
        ));
    }

}
