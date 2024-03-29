package pl.amelialis.sales.cart;

import pl.amelialis.sales.cart.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CartStorage {
    private final Map<String, Cart> carts;

    public CartStorage() {
        carts = new ConcurrentHashMap<>();
    }
    public Optional<Cart> load(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void addForCustomer(String customerId, Cart cart) {
        carts.put(customerId, cart);
    }
}