package hello.data.repositories;

import hello.data.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Mamok-Laptop on 12/29/2016.
 */
public interface StopRepo extends MongoRepository<Stop, String> {

    @Query("{ 'stop_id' : ?0 }")
    Stop getById(Integer stop_id);

    @Query("{ 'stop_city' : ?0 }")
    List<Stop> getByCity(String city);


}
