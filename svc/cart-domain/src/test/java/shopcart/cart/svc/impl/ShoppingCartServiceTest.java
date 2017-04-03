package shopcart.cart.svc.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;
import shopcart.cart.model.CartItem;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.repo.CartRepository;
import shopcart.cart.svc.ShoppingCartService;

import java.util.Collections;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {

    @MockBean
    private CartRepository repository;

    @MockBean
    private ApplicationEventPublisher eventStream;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    public void testHandleItemAddedToCartEvent() {
        ShoppingCart cart = new ShoppingCart();
        cart.setUserId("abc123");
        cart.setCart(Collections.singletonList(
                new CartItem(1, "productId")
        ));
        shoppingCartService.saveCart(cart);

        verify(repository).save(cart);
    }

}
