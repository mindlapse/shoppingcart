package shopcart.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import shopcart.cart.config.MongoConfig;
import shopcart.cart.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}
