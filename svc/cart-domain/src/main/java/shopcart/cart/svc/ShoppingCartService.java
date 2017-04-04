package shopcart.cart.svc;

import shopcart.cart.model.ShoppingCart;

public interface ShoppingCartService {

    void saveCart(ShoppingCart cart);

    ShoppingCart fetchCart(String userId);

}
