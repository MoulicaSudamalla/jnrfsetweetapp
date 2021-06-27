package com.tweet.app.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.tweet.app.dao")
public class DynamoDBConfig {


@Primary
    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }


@Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("AKIAWSLRJR22FAO36UAC", "60dyl4KV5PKa89dCDKnW5aDhxxXhHaCEeSgLty0f")))
//                        new BasicAWSCredentials("AKIAS6F7M7GXVTAADPFW", "8XY9l6kDVuJK2NEFn9oLWTUaAVtTjYzXpN5+5GIv")))
                .build();
    }



}
