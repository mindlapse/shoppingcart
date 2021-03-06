package shopcart.zuul.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
    "shopcart.zuul.svc",
    "shopcart.zuul.filter"
})
@Import(MongoConfig.class)
public class ServiceConfig {

}
