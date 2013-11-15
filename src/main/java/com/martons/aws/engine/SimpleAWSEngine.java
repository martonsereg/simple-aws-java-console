package com.martons.aws.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;

@Component
public class SimpleAWSEngine {

	private final Logger logger = LoggerFactory.getLogger(SimpleAWSEngine.class);

	@Autowired
	private AmazonEC2Client amazonEC2Client;

	// @Autowired
	// private AWSCredentialsProvider awsCredentialsProvider;

	public void run(String[] args) {
		try {
			DescribeInstancesResult describeInstancesResult = amazonEC2Client.describeInstances();
			System.out.println(describeInstancesResult.getReservations().size());

			// System.out.println(awsCredentialsProvider.getCredentials().getAWSAccessKeyId());
			// System.out.println(awsCredentialsProvider.getCredentials().getAWSSecretKey());
		} catch (AmazonClientException e) {
			logger.error("An execption occured in the client.", e);
		}
	}
}
