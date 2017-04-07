package shopcart.cart.svc;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import shopcart.cart.events.CartRequestedEvent;
import shopcart.cart.events.CartUpdatedEvent;

/**
 * TODO Publish application events to a kafka queue.
 */
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
