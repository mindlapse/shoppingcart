package shopcart.cart.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import shopcart.cart.model.CartItem;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.repo.CartRepository;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {


    @MockBean
    private CartRepository repository;

    @Autowired
    private CartController cartController;


    @Test
    public void testUpdateCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.setUserId("abc123");
        cart.setCart(Collections.singletonList(
            new CartItem(1, "productId")
        ));

        HttpHeaders headers = mock(HttpHeaders.class);
        when(headers.getFirst("USER")).thenReturn("buzz");

        cartController.updateCart(cart, headers);
        verify(repository).save(cart);

    }
}
