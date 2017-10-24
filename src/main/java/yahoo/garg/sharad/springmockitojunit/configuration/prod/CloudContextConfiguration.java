/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.garg.sharad.springmockitojunit.configuration.prod;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import yahoo.garg.sharad.springmockitojunit.util.Profiles;

/**
 *
 * @author Sharad Garg Created on Oct 3, 2017 1:03:45 PM
 */
@Configuration
@Profile(Profiles.PROD)
public class CloudContextConfiguration {
    
    private static final Logger _logger = LoggerFactory.getLogger(CloudContextConfiguration.class);

    @Bean
    @Profile(Profiles.PROD)
    AWSCredentialsProvider awsCredProvider() {
	_logger.info("Creating AWSCredentialsProvider using DefaultAWSCredentialsProviderChain");
	_logger.info("Order in which it will look for credentials  -> ENV, SYSTEM, PROFILE, INSTANCE");
	AWSCredentialsProvider awsCredProvider = new AWSCredentialsProviderChain(new InstanceProfileCredentialsProvider());
	_logger.info("Returning AWSCredentialsProvider instance");
	return awsCredProvider;
    }

    @Bean
    @Profile(Profiles.PROD)
    AmazonSQSClient sqsClient() {
	_logger.info("Creating AmazonSQSClient instance");
	AmazonSQSClient sqsClient = (AmazonSQSClient) AmazonSQSClientBuilder.standard().withCredentials(awsCredProvider()).build();
	_logger.info("Returning AmazonSQSClient instance");
	return sqsClient;
    }

    @Bean
    @Profile(Profiles.PROD)
    AWSKMSClient awsKmsClient() {
	_logger.info("Creating AWSKMSClient instance");
	AWSKMSClient awsKmsClient = (AWSKMSClient) AWSKMSClientBuilder.standard().withCredentials(awsCredProvider()).build();
	_logger.info("Returning AWSKMSClient instance");
	return awsKmsClient;
    }

}
