package hello;

import com.mongodb.DBObject;
import hello.data.Stop;
import hello.data.repositories.StopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private MongoOperations mongoOperations;
    @Autowired
    private StopRepo stopRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		mongoOperations = (MongoOperations)ctx.getBean("mongoTemplate");

        Stop stop = stopRepo.getById(1);
        List<Stop> stops = stopRepo.getByCity("ראשון לציון");
        System.out.println("found stop : " + stop.getStop_name());
        System.out.println("Mongo running perfect");
        System.out.println("Stops count : " + stopRepo.count());
    }
}
