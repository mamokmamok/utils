package hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "stops")
public class Stop {

    @Id
    @Field("stop_id")
    public String id;
    public String stop_code;
    public String stop_name;
    public String stop_street;
    public String stop_city;
    public String stop_lat;
    public String stop_lon;


    public Stop() {}

    public Stop(String stop_id, String stop_code, String stop_name, String stop_street, String stop_city, String stop_lat, String stop_lon) {
        this.id = stop_id;
        this.stop_code = stop_code;
        this.stop_name = stop_name;
        this.stop_street = stop_street;
        this.stop_city = stop_city;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
    }

    public String getStop_id() {
        return id;
    }

    public void setStop_id(String stop_id) {
        this.id = stop_id;
    }

    public String getStop_code() {
        return stop_code;
    }

    public void setStop_code(String stop_code) {
        this.stop_code = stop_code;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public String getStop_street() {
        return stop_street;
    }

    public void setStop_street(String stop_street) {
        this.stop_street = stop_street;
    }

    public String getStop_city() {
        return stop_city;
    }

    public void setStop_city(String stop_city) {
        this.stop_city = stop_city;
    }

    public String getStop_lat() {
        return stop_lat;
    }

    public void setStop_lat(String stop_lat) {
        this.stop_lat = stop_lat;
    }

    public String getStop_lon() {
        return stop_lon;
    }

    public void setStop_lon(String stop_lon) {
        this.stop_lon = stop_lon;
    }

    @Override
    public String toString() {
        return String.format(
                "Stop[stop_id=%s, stop_code='%s', lat='%s', lon='%s', city='%s', street='%s']",
                id, stop_code, stop_lat, stop_lon, stop_city, stop_street);
    }

}

