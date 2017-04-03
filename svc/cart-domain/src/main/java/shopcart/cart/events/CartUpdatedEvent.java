package shopcart.cart.events;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import shopcart.cart.model.ShoppingCart;

import java.time.Instant;

public class CartUpdatedEvent {

    private Instant time;
    private ShoppingCart shoppingCart;

    public CartUpdatedEvent(Instant time, ShoppingCart shoppingCart) {
        this.time = time;
        this.shoppingCart = shoppingCart;
    }

    public Instant getTime() {
        return time;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
