package com.martons.aws.credentials;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class HomeConfigAWSCredentialsProvider implements AWSCredentialsProvider {

	public AWSCredentials getCredentials() {
		return new HomeConfigAWSCredentials();
	}
	public void refresh() {
	}

}
