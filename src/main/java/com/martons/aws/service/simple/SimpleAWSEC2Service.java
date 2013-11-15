package com.martons.aws.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.martons.aws.service.AWSEC2Service;

@Component
public class SimpleAWSEC2Service implements AWSEC2Service {

	@Autowired
	private AmazonEC2Client amazonEC2Client;

	@Override
	public void describeInstances() {
		DescribeInstancesResult describeInstancesResult = amazonEC2Client.describeInstances();
		for (Reservation reservation : describeInstancesResult.getReservations()) {
			System.out.println(reservation);
		}
	}

	@Override
	public void runInstances(String amiId, Integer instanceCount, String instanceType, String keyName, String securityGroup) {
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest(amiId, instanceCount, instanceCount).withInstanceType(instanceType)
		        .withKeyName(keyName).withSecurityGroups(securityGroup);
		RunInstancesResult runInstancesResult = amazonEC2Client.runInstances(runInstancesRequest);
		System.out.println(runInstancesResult);
	}
	@Override
	public void stopInstances() {
		// TODO Auto-generated method stub

	}

	@Override
	public void terminateInstances() {
		// TODO Auto-generated method stub

	}

}
