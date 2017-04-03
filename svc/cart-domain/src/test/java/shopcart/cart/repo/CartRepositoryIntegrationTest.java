package shopcart.cart.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import shopcart.cart.Application;
import shopcart.cart.model.CartItem;
import shopcart.cart.model.ShoppingCart;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class CartRepositoryIntegrationTest {

    @Inject
    private CartRepository cartRepository;

    @Test
    public void testCreate() {
        String userId = "dave";

        ShoppingCart cart = new ShoppingCart();
        cart.setUserId(userId);
        cart.setCart(Arrays.asList(
            new CartItem(5, "abc"),
            new CartItem(3, "xyz")
        ));

        cartRepository.save(cart);

        ShoppingCart loaded = cartRepository.findOne(userId);
        assertEquals(userId, loaded.getUserId());
        cartRepository.delete(cart.getUserId());
        loaded = cartRepository.findOne(userId);
        assertNull(loaded);
    }


}
