package pl.amelialis.productcatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductCatalogTest {
    @Test
    void itExposeEmptyCollectionOfProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        List<Product> products = catalog.allProducts();
        //Assert
        assertListIsEmpty(products);
    }

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("Miś uszatek",
                "fluffy bear", "image",false,
                BigDecimal.valueOf(1000),"brown,beige","bear","big");

        //Assert
        ArrayList<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct("Miś uszatek",
                "fluffy bear", "image",false,
                BigDecimal.valueOf(1000),"brown,beige","bear","big");

        Product loadedProduct = catalog.loadById(productId);
        assert loadedProduct.getId().equals(productId);
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = new ProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "image",false,
                BigDecimal.valueOf(1000),"brown,beige","bear","big");

        catalog.changePriceById(id, BigDecimal.valueOf(49.99));

        assert catalog.loadById(id).getProductInfo().get("price").equals(BigDecimal.valueOf(49.99));
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = new ProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "image",false,
                BigDecimal.valueOf(1000),"brown,beige","bear","big");

        catalog.changeImageById(id,"zdjęcia pluszaka 'Miś Uszatek'");

        assert catalog.loadById(id).getProductInfo().get("image").equals("zdjęcia pluszaka 'Miś Uszatek'");
    }

    @Test
    void itAllowsToPublishProduct() {
        ProductCatalog catalog = new ProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "image",false,
                BigDecimal.valueOf(1000),"brown,beige","bear","big");

        catalog.changeVisibilityById(id,true);

        assert catalog.loadById(id).getProductInfo().get("isPublished").equals(true);
    }

    @Test
    void publicationIsPossibleWhenPriceAndImageAreDefined() {
        ProductCatalog catalog = new ProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", null,false,
                null,"brown,beige","bear","big");

        assertThrows(ProductImageOrPriceIsNotDefined.class,() -> catalog.changeVisibilityById(id,true));
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    private void assertListIsEmpty(List<Product> products) {
        assert 0 == products.size();
    }
}
