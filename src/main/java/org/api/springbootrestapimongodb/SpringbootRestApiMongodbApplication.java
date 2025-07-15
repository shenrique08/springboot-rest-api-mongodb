package org.api.springbootrestapimongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringbootRestApiMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestApiMongodbApplication.class, args);
    }

}
