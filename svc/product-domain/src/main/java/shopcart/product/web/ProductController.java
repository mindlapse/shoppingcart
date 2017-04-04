package shopcart.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shopcart.product.model.Product;
import shopcart.product.svc.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public Iterable<Product> getProducts() {

        return productService.getProducts();
    }

}
