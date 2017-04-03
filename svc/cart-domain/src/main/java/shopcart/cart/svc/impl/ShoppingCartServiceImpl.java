package shopcart.cart.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import shopcart.cart.events.CartUpdatedEvent;
import shopcart.cart.model.ShoppingCart;
import shopcart.cart.repo.CartRepository;
import shopcart.cart.svc.ShoppingCartService;

import java.time.Instant;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ApplicationEventPublisher eventStream;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void saveCart(ShoppingCart cart) {
        eventStream.publishEvent(new CartUpdatedEvent(Instant.now(), cart));
        cartRepository.save(cart);
    }

}
