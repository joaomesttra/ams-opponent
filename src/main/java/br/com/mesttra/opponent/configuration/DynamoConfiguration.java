package br.com.mesttra.opponent.configuration;

import br.com.mesttra.opponent.repository.OpponentRepository;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = OpponentRepository.class)
public class DynamoConfiguration {

    @Value("${aws.acceskey}")
    private String awsAccesKey;

    @Value("${aws.secretkey}")
    private String awsSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return new AmazonDynamoDBClient(credentials()).withRegion(Regions.SA_EAST_1);
    }

    @Bean
    public AWSCredentials credentials() {
        return new BasicAWSCredentials(awsAccesKey, awsSecretKey);
    }
}
