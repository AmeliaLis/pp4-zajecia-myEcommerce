package pl.amelialis.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.amelialis.sales.cart.Cart;
import pl.amelialis.sales.cart.CartStorage;
import pl.amelialis.sales.cart.Sales;
import pl.amelialis.sales.productdetails.ProductDetailsProvider;

import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    @BeforeEach
    void setUp(){
        cartStorage = new CartStorage();
        productDetailsProvider = new AlwaysMissingProductDetailsProvider();
    }

    @Test
    void itAllowsToCollectProductsToCart(){
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customerId = thereIsCustomer("AMI");
        //Act
        sales.addToCart(customerId,productId);

        //Assert
        assertThereIsXProductsInCustomersCart(customerId,1);
    }

    @Test
    void itAllowsToAddMultipleOfTheSameTypeProductsToCart(){
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customerId = thereIsCustomer("AMI");

        sales.addToCart(customerId,productId);
        sales.addToCart(customerId,productId);

        assertThereIsXProductsInCustomersCart(customerId,2);
    }

    private void assertThereIsXProductsInCustomersCart(String customerId, int productsCount) {
        Cart customersCart = cartStorage.load(customerId).get();
        assert customersCart.itemsCount() == productsCount;
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private Sales thereIsSalesModule() {
        return new Sales(cartStorage,productDetailsProvider);
    }
}
