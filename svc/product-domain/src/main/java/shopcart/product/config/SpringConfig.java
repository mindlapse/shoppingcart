package shopcart.product.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MongoConfig.class)
@ComponentScan(basePackages = "shopcart.product.svc")
public class SpringConfig {

}