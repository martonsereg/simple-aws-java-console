package com.martons.aws.credentials;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@Component
public class HomeConfigAWSCredentialsProvider implements AWSCredentialsProvider {

	public AWSCredentials getCredentials() {
		return new HomeConfigAWSCredentials();
	}
	public void refresh() {
	}

}
