package com.orion.web.services.cloud.amazon_web_services.ec2.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.orion.core.abstraction.Orion;
import com.orion.web.services.cloud.amazon_web_services.ec2.AWSEC2DetailsModel;

public class GetAWSEC2DetailsTask extends Orion
{
    public static AWSEC2DetailsModel run(ClientConfiguration clientConfiguration)
    {
        Regions clientRegion = Regions.DEFAULT_REGION;
        AmazonEC2 client = AmazonEC2ClientBuilder.standard()
                        .withRegion(clientRegion)
                        .withCredentials(new ProfileCredentialsProvider())
                        .withClientConfiguration(clientConfiguration)
                        .build();
        AWSEC2DetailsModel allDetailsModel = new AWSEC2DetailsModel();
        int numberOfInstances = 0;
        DescribeInstancesResult response = client.describeInstances();

        for(Reservation reservation : response.getReservations())
        {
            numberOfInstances += reservation.getInstances().size();
        }

        //String platform = client.describeInstances().
        /*
         * String platform =
         * client.describeImages().getImages().get(0).getPlatformDetails();
         * allDetailsModel.setOperatingSystemName(platform); //DescribeInstancesRequest
         * request = new DescribeInstancesRequest(); boolean done = false; int
         * numberOfInstances = 0; while(!done) { //DescribeInstancesResult response =
         * client.describeInstances(request); DescribeInstancesResult response =
         * client.describeInstances(); for(Reservation reservation :
         * response.getReservations()) { numberOfInstances +=
         * reservation.getInstances().size(); }
         * //request.setNextToken(response.getNextToken()); if(response.getNextToken()
         * == null) { done = true; } }
         */
        allDetailsModel.setNumberOfInstances(numberOfInstances);
        client.shutdown();
        return allDetailsModel;
    }
}