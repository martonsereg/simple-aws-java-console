package com.martons.aws.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.martons.aws.service.AWSEC2Service;

@Component
public class SimpleAWSEngine {

	@Autowired
	private AWSEC2Service awsEc2Service;

	private final Logger logger = LoggerFactory.getLogger(SimpleAWSEngine.class);

	public void run(String[] args) {
		try {
			if (args.length < 1) {
				throw new AmazonClientException("Provide action as an argument: describe-instances, run-instances, stop-instances, terminate-instances");
			} else {
				if ("describe-instances".equals(args[0])) {
					describeInstances();
				} else if ("run-instances".equals(args[0])) {
					runInstances(args);
				} else if ("stop-instances".equals(args[0])) {
					awsEc2Service.stopInstances();
				} else if ("terminate-instances".equals(args[0])) {
					awsEc2Service.terminateInstances();
				}
			}
		} catch (AmazonServiceException e) {
			logger.error("An Amazon service returned an error response.", e);
		} catch (AmazonClientException e) {
			logger.error("An execption occured in the client.", e);
		}
	}

	private void runInstances(String[] args) {
		if (args.length < 6) {
			throw new AmazonClientException("Provide the following as arguments: ami-id, instance-count, instance-type, key-name, security-group");
		} else {
			awsEc2Service.runInstances(args[1], Integer.parseInt(args[2]), args[3], args[4], args[5]);
		}
	}

	private void describeInstances() {
		awsEc2Service.describeInstances();
	}
}
