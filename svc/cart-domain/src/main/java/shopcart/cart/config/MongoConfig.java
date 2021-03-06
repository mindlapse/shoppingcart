package shopcart.cart.config;


import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "shopcart.cart.repo")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${shopcart.host.mongo}")
    private String hostMongo;

    @Value("${shopcart.database.name}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return "shopcart";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient(hostMongo);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList("shopcart.cart.repo");
    }

}
