package pl.amelialis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.amelialis.productcatalog.HashMapProductStorage;
import pl.amelialis.productcatalog.ProductCatalog;
import pl.amelialis.sales.CartStorage;
import pl.amelialis.sales.ProductDetailsProvider;
import pl.amelialis.sales.Sales;

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
    Sales createSales() {
        return new Sales(new CartStorage(), new ProductDetailsProvider());
    }
}
