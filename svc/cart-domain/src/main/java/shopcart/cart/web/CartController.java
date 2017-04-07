package shopcart.cart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.svc.ShoppingCartService;

import java.util.Enumeration;

@RestController
public class CartController {

    private static final String USER = "USER";
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private ShoppingCartService shoppingCartService;


    // Update the shopping cart
    @PostMapping(path = "/cart")
    public void updateCart(@RequestBody ShoppingCart cart, @RequestHeader HttpHeaders headers) {

        String userId = headers.getFirst(USER);
        logger.info("POST /cart requested by {}", userId);

        logger.info(cart.toString());

        cart.setUserId(userId);
        shoppingCartService.saveCart(cart);

    }


    // Get the latest cart for a user
    @GetMapping(path = "/cart")
    public @ResponseBody ShoppingCart getCart(@RequestHeader HttpHeaders headers) {

        String userId = headers.getFirst(USER);
        logger.info("GET /cart requested by {}", userId);

        ShoppingCart cart = shoppingCartService.fetchCart(userId);
        logger.info("Loaded cart {}", cart);

        return cart;
    }



}
