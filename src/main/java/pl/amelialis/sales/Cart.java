package pl.amelialis.sales;

import pl.amelialis.productcatalog.Product;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
     List<String> products;

    public Cart() {
        this.products = new ArrayList<String>();
    }
    public static Cart empty(){
        return new Cart();
    }

    public void add(ProductDetails product) {
        products.add(product.getProductId());
    }

    public int itemsCount(){
        return products.size();
    }
    /*
    public int itemsCount() {
        int totalNumberOfProducts = 0;
        for (int amountOfOneProduct : products.values()){
            totalNumberOfProducts += amountOfOneProduct;
        }

        return totalNumberOfProducts;
    }

    public BigDecimal calculateOffer() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (ProductDetailsProvider product : products.keySet()){
            BigDecimal totalAmountOfOneProduct = BigDecimal.valueOf(products.get(product));
            BigDecimal priceOfTotalAmountOfOneProduct = product
                    .loadPrice()
                    .multiply(totalAmountOfOneProduct)
                    .subtract(totalAmountOfOneProduct.divideToIntegralValue(BigDecimal.valueOf(5))).multiply(product.loadPrice());
            totalPrice.add(priceOfTotalAmountOfOneProduct);
        }
        return totalPrice;
    }

     */
}
