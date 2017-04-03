package shopcart.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.svc.ShoppingCartService;

@RestController
public class CartEndpoints {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @PostMapping(path = "/cart")
    public void updateCart(ShoppingCart cart) {
        // TODO obtain the userId from a secure source (e.g. encrypted cookie)
        shoppingCartService.saveCart(cart);
    }

    @GetMapping(path = "/cart")
    public void getCart() {

        // TODO, we need to identify the user.
//        shoppingCartService.getCart()
    }



}
