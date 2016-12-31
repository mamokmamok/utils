package hello;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Mamok-Laptop on 12/29/2016.
 */
@EnableMongoRepositories(basePackages = "hello.data.repositories")
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration  {
    @Override
    protected String getDatabaseName() {
        return "myway-test";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("35.165.67.87:27017");
    }

    public @Bean
    MongoOperations mongoTemplate(Mongo mongo) {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo, getDatabaseName());
        return mongoTemplate;
    }
}
