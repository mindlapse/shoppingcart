package shopcart.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import shopcart.cart.config.MongoConfig;

@SpringBootApplication
@Import(MongoConfig.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}
