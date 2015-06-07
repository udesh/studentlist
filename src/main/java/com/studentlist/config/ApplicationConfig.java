package com.studentlist.config;

import com.mongodb.Mongo;
import com.studentlist.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
public class ApplicationConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String openshiftMongoDbHost = "127.0.0.1";
        int openshiftMongoDbPort = 27017;
        String username = "";
        String password = "";
        Mongo mongo = new Mongo(openshiftMongoDbHost, openshiftMongoDbPort);
        UserCredentials userCredentials = new UserCredentials(username, password);
        String databaseName = "studentlist";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName, userCredentials);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

}
