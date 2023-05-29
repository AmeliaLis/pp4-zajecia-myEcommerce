package pl.amelialis.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.amelialis.productcatalog.Product;
import pl.amelialis.productcatalog.ProductCatalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfferAcceptanceHTTPTest {

    @Autowired
    ProductCatalog productCatalog;
    @Autowired
    TestRestTemplate http;

    @Test
    void itAllowsToAcceptOffer(){
        //Arrange
        //there are products
        String productId = thereIsExampleProduct();

        //customer added product to cart
        http.postForEntity(String.format("/api/add-to-cart/%s", productId), null,String.class);

        //Act
        ResponseEntity<PaymentData> response = http.postForEntity(String.format("/api/accept-offer"), null, PaymentData.class);

        //Assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody().getPaymentUrl());

    }

    private String thereIsExampleProduct() {
        return productCatalog.allPublishedProducts().stream()
                .findFirst()
                .map(Product::getId)
                .get();
    }
}
