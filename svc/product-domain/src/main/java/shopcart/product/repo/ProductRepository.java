package shopcart.product.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopcart.product.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
