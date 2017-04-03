package shopcart.zuul.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "shopcart.zuul.repo")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "user";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient("mongo");
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList("shopcart.zuul.repo");
    }


}
