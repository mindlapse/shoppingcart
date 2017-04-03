package shopcart.cart.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import shopcart.cart.model.CartItem;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.repo.CartRepository;

import java.util.Collections;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEndpointsTest {


    @MockBean
    private CartRepository repository;

    @Autowired
    private CartEndpoints cartEndpoints;


    @Test
    public void testUpdateCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.setUserId("abc123");
        cart.setCart(Collections.singletonList(
            new CartItem(1, "productId")
        ));

        cartEndpoints.updateCart(cart);
        verify(repository).save(cart);

    }
}
