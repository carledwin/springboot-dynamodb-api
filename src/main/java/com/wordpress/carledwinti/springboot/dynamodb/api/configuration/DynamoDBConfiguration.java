package com.wordpress.carledwinti.springboot.dynamodb.api.configuration;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.wordpress.carledwinti.springboot.dynamodb.api.repository.ContatoRepository;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = ContatoRepository.class)
public class DynamoDBConfiguration {

	@Value("${amazon.aws.endpoint}")
	private String amazonEndpoint;
	
	@Value("${amazon.aws.accesskey}")
	private String amazonAWSAccessKey;
	
	@Value("${amazon.aws.secretkey}")
	private String amazonAWSAWSSecretKey;
	
	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSAWSSecretKey);
	}
	
	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}
	
	@Bean
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig) {
		return new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig);
	}
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider()).withRegion(Regions.US_EAST_2).build();
	}

	public String getAmazonEndpoint() {
		return amazonEndpoint;
	}

	public void setAmazonEndpoint(String amazonEndpoint) {
		this.amazonEndpoint = amazonEndpoint;
	}
}
