package shopcart.cart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MongoConfig.class)
@ComponentScan(basePackages = "shopcart.cart.svc")
public class SpringConfig {

}