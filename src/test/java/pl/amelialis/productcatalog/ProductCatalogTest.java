package pl.amelialis.productcatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;

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
                "fluffy bear", "brown","bear","big");

        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct("Miś uszatek",
                "fluffy bear", "brown","bear","big");

        Product loadedProduct = catalog.loadById(productId);
        assert loadedProduct.getId().equals(productId);
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "brown","bear", "big");

        catalog.changePriceById(id, BigDecimal.valueOf(49.99));

        assert catalog.loadById(id).getPrice().equals(BigDecimal.valueOf(49.99));
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "brown","bear", "big");

        catalog.changeImageById(id,"obrazek.jpg");

        assertEquals("obrazek.jpg",catalog.loadById(id).getImage());
    }

    @Test
    void itDenyPublicationWithoutImageAndPrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("pies","misiek","pink","bear","enormous");

        assertThrows(ProductCantBePublishedException.class,
                () -> catalog.publishProduct(productId));
    }
    @Test
    void itAllowsToPublishProduct() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct("Miś uszatek",
                "fluffy bear", "brown,beige","bear","big");

        catalog.changePriceById(productId,BigDecimal.valueOf(17.99));
        catalog.changeImageById(productId, "obrazek.jpg");

        catalog.publishProduct(productId);

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertDoesNotThrow(() -> catalog.publishProduct(productId));
        assertEquals(1,publishedProducts.size());
    }

    @Test
    void publicationIsPossibleWhenPriceAndImageAreDefined() {
        ProductCatalog catalog = thereIsProductCatalog();

        String id = catalog.addProduct("Miś uszatek",
                "fluffy bear", "brown","bear","big");

        assertThrows(ProductCantBePublishedException.class,() -> catalog.changeVisibilityById(id,true));
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(
                new HashMapProductStorage());

    }

    private void assertListIsEmpty(List<Product> products) {
        assert 0 == products.size();
    }
}
