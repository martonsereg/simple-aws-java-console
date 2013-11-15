package com.martons.aws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.martons.aws.credentials.HomeConfigAWSCredentialsProvider;

@Configuration
@ComponentScan
public class SimpleAWSConfiguration {

	@Bean
	AWSCredentialsProvider homeConfigAWSCredentialsProvider() {
		return new HomeConfigAWSCredentialsProvider();
	}

	@Bean
	Region region() {
		return Region.getRegion(Regions.US_WEST_2);
	}

	@Bean
	AmazonEC2Client amazonEC2Client() {
		AmazonEC2Client amazonEC2Client = new AmazonEC2Client(homeConfigAWSCredentialsProvider());
		amazonEC2Client.setRegion(region());
		return amazonEC2Client;
	}

}
