package com.martons.aws.service;

public interface AWSEC2Service {

	void describeInstances();

	void runInstances(String amiId, Integer instanceCount, String instanceType, String keyName, String securityGroup);

	void stopInstances();

	void terminateInstances();
}
