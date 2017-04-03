package shopcart.cart.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopcart.cart.model.ShoppingCart;

public interface CartRepository extends PagingAndSortingRepository<ShoppingCart, String> {

}
