package com.martons.aws.credentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;

public class HomeConfigAWSCredentials implements AWSCredentials {

	private static final String AWS_SECRET_ACCESS_KEY = "aws_secret_access_key";
	private static final String AWS_ACCESS_KEY_ID = "aws_access_key_id";

	private final String accessKey;
	private final String secretAccessKey;

	public HomeConfigAWSCredentials() {
		String home = System.getProperty("user.home");
		String pathToConfig = home + "//.aws//config";
		Properties accountProperties = new Properties();
		try {
			accountProperties.load(new FileInputStream(pathToConfig));
			if (accountProperties.getProperty(AWS_ACCESS_KEY_ID) == null || accountProperties.getProperty(AWS_SECRET_ACCESS_KEY) == null) {
				throw new AmazonClientException("The config file (~/.aws/config) doesn't contain the expected properties '" + AWS_ACCESS_KEY_ID + "' and '"
				        + AWS_SECRET_ACCESS_KEY + "'.");
			}
			accessKey = accountProperties.getProperty(AWS_ACCESS_KEY_ID);
			secretAccessKey = accountProperties.getProperty(AWS_SECRET_ACCESS_KEY);
		} catch (IOException e) {
			throw new AmazonClientException("The config file (~/.aws/config) cannot be found.");
		}

	}
	public String getAWSAccessKeyId() {
		return accessKey;
	}

	public String getAWSSecretKey() {
		return secretAccessKey;
	}

}
