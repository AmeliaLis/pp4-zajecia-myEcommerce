package pl.amelialis;


import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.amelialis.payu.PayU;
import pl.amelialis.payu.PayUApiCredentials;
import pl.amelialis.productcatalog.HashMapProductStorage;
import pl.amelialis.productcatalog.ProductCatalog;
import pl.amelialis.sales.cart.CartStorage;
import pl.amelialis.sales.offering.OfferCalculator;
import pl.amelialis.sales.payment.PaymentGateway;
import pl.amelialis.sales.payment.PayuPaymentGateway;
import pl.amelialis.sales.productdetails.ProductCatalogDetailsProvider;
import pl.amelialis.sales.Sales;
import pl.amelialis.sales.productdetails.ProductDetailsProvider;
import pl.amelialis.sales.reservation.InMemoryReservationStorage;
import pl.amelialis.web.SessionCurrentCustomerContext;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String product1=productCatalog.addProduct("piesek","piesek","brown","fluffy","big");
        productCatalog.changeImageById(product1,"resources/blik.jpg");
        productCatalog.changePriceById(product1, BigDecimal.valueOf(20.20));
        productCatalog.publishProduct(product1);

        String product2=productCatalog.addProduct("inny piesek","piesek","yellow","fluffy","big");
        productCatalog.changeImageById(product2,"resources/blik1.jpg");
        productCatalog.changePriceById(product2, BigDecimal.valueOf(21.20));
        productCatalog.publishProduct(product2);


        return productCatalog;
    }

    @Bean
    PaymentGateway createPaymentGateway() {
        return new PayuPaymentGateway(new PayU(PayUApiCredentials.sandbox(), new RestTemplate()));
    }

    @Bean
    Sales createSales(ProductDetailsProvider productDetailsProvider, PaymentGateway paymentGateway) {
        return new Sales(
                new CartStorage(),
                productDetailsProvider,
                new OfferCalculator(productDetailsProvider),
                paymentGateway,
                new InMemoryReservationStorage()
        );
    }

    @Bean
    SessionCurrentCustomerContext currentCustomerContext(HttpSession httpSession) {
        return new SessionCurrentCustomerContext(httpSession);
    }

    @Bean
    ProductDetailsProvider createProductDetailsProvider(ProductCatalog catalog) {
        return new ProductCatalogDetailsProvider(catalog);
    }
}
