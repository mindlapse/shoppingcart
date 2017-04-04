package shopcart.cart.svc;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import shopcart.cart.events.CartRequestedEvent;
import shopcart.cart.events.CartUpdatedEvent;

@Component
public class MessageQueueService {

    @EventListener
    void handleItemAddedToCartEvent(CartUpdatedEvent event) {
        // TODO
    }

    @EventListener
    void handleCartRequestedEvent(CartRequestedEvent event) {
        // TODO
    }

}
