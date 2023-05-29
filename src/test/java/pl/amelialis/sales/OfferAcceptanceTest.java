package pl.amelialis.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OfferAcceptanceTest {

    @Test
    void itAllowsToAcceptOffer() {
        Sales sales = thereIsSalesModule();
        String productId = thereIsExampleProduct();
        String customerId = thereIsCustomer();

        sales.addToCart(customerId, productId);
        sales.addToCart(customerId, productId);

        PaymentData paymentData = sales.acceptOffer(customerId);

        assertCustomerHasNReservation(customerId, 1);
        assertNotNull(paymentData.getPaymentUrl());
    }
}
