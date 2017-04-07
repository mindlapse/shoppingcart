package shopcart.product.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopcart.product.model.Product;

/**
 * A JPA repository for Products
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
