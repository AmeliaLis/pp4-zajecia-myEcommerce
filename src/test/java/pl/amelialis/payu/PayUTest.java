package pl.amelialis.payu;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PayUTest {
    @Test
    void itRegisterPayment() {
        PayU payu = thereIsPayU();
        OrderCreateRequest request = thereIsExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        OrderCreateRequest exampleRequest = new OrderCreateRequest();

        exampleRequest
                .setNotifyUrl("https://your.eshop.com/notify")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("RTV market")
                .setCurrencyCode("PLN")
                .setTotalAmount(15000)
                .setBuyer(new Buyer()
                        .setEmail("john.doe@example.com")
                        .setPhone("654111654")
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Nice service")
                                .setUnitPrice(15000)
                                .setQuantity(1)
                ));
        /*{
            "notifyUrl": "https://your.eshop.com/notify",
                    "customerIp": "127.0.0.1",
                    "merchantPosId": "300746",
                    "description": "RTV market",
                    "currencyCode": "PLN",
                    "totalAmount": "21000",
                    "buyer": {
                "email": "john.doe@example.com",
                        "phone": "654111654",
                        "firstName": "John",
                        "lastName": "Doe",
                        "language": "pl"
            },
            "products": [
            {
                "name": "Wireless Mouse for Laptop",
                    "unitPrice": "15000",
                    "quantity": "1"
            },
            {
                "name": "HDMI cable",
                    "unitPrice": "6000",
                    "quantity": "1"
            }
        ]} */

        return exampleRequest;

    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate());
    }
}
