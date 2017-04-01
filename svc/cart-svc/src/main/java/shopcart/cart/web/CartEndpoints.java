package shopcart.cart.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartEndpoints {


    @GetMapping(path = "/")
    public String hello() {
        return "Hello world";
    }

}
