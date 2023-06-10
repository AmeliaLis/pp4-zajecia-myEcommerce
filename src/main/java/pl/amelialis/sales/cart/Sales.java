package pl.amelialis.sales.cart;

import pl.amelialis.payu.Buyer;
import pl.amelialis.payu.OrderCreateRequest;
import pl.amelialis.sales.*;
import pl.amelialis.sales.offering.Offer;
import pl.amelialis.sales.productdetails.NoSuchProductException;
import pl.amelialis.sales.productdetails.ProductDetailsProvider;

import java.math.BigDecimal;
import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
        this.cartStorage=cartStorage;
        this.productDetailsProvider=productDetailsProvider;
    }
    public void addToCart(String customerId, String productId) {
        Cart customersCart = loadCartForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadProductDetails(productId)
                .orElseThrow(() -> new NoSuchProductException());

        customersCart.add(product);

        cartStorage.save(customerId,customersCart);
    }

    private Optional<ProductDetails> loadProductDetails(String productId) {
        return productDetailsProvider.loadForProduct(productId);
    }

    private Optional<Cart> loadCartForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    /*public PaymentData acceptOffer(String customerId) {
        Offer offer = getCurrentOffer(customerId);

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        BigDecimal totalAmountAsGrosze = offer.getTotal().multiply(BigDecimal.valueOf(100));
        orderCreateRequest.setBuyer(new Buyer()
                .setFirstName(request.email)
        );

        return new PaymentData(response.getRedirectUri());
    }

     */
}