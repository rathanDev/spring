package org.jana.reactive;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${port}")
    private String port;

    @Value("${dbname}")
    private String dbName;

    public MongoConfig() {
        super();
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Bean
    @Override
    public ReactiveMongoOperations reactiveMongoTemplate() throws Exception {
        return super.reactiveMongoTemplate();
    }

    @Override
    public ReactiveMongoDatabaseFactory reactiveMongoDbFactory() {
        return super.reactiveMongoDbFactory();
    }

    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        return super.mappingMongoConverter();
    }

}
