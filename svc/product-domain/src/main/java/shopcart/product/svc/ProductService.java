package shopcart.product.svc;

import shopcart.product.model.Product;

public interface ProductService {

    Iterable<Product> getProducts();
}
