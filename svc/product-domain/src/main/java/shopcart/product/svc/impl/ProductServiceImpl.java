package shopcart.product.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopcart.product.model.Price;
import shopcart.product.model.Product;
import shopcart.product.repo.ProductRepository;
import shopcart.product.svc.ProductService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }


    @PostConstruct
    public void testdata() {

        productRepository.save(Arrays.asList(
            new Product("1", "Seal", "seal.jpg", new Price(250)),
            new Product("2", "Deer", "deer.jpg", new Price(225)),
            new Product("3", "Dolphin", "dolphin.jpg", new Price(560)),
            new Product("4", "Eagle", "eagle.jpg", new Price(350)),
            new Product("5", "Elephant", "elephant.jpg", new Price(625)),
            new Product("6", "Gander", "gander.jpg", new Price(180)),
            new Product("7", "Guinea Pig", "guineapig.jpg", new Price(120)),
            new Product("8", "Hedge Hog", "hedgehog.jpg", new Price(210)),
            new Product("9", "Koala", "koala.jpg", new Price(440)),
            new Product("10", "Meerkat", "meerkat.jpg", new Price(440)),
            new Product("11", "Ostriches", "ostriches.jpg", new Price(2)),
            new Product("12", "Swan", "swan.jpg", new Price(2, true))
        ));


    }

}
