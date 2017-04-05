package shopcart.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;
import shopcart.zuul.config.MongoConfig;
import shopcart.zuul.config.RedisHttpSessionConfig;
import shopcart.zuul.config.SecurityConfig;


@SpringBootApplication
@EnableZuulProxy
@Import({MongoConfig.class, RedisHttpSessionConfig.class, SecurityConfig.class})
public class Zuul {


    public static void main(String[] args) {
        SpringApplication.run(Zuul.class, args);
    }


}
