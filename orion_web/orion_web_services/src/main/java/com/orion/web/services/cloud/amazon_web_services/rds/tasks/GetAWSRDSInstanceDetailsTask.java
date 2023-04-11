package com.orion.web.services.cloud.amazon_web_services.rds.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DescribeAccountAttributesResult;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.time.Time;
import com.orion.web.services.cloud.amazon_web_services.rds.AWSRDSDetailsModel;
import com.orion.web.services.cloud.amazon_web_services.rds.AWSRDSInstanceDetailsModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetAWSRDSInstanceDetailsTask extends Orion
{
    public static AWSRDSDetailsModel run(ClientConfiguration clientConfiguration)
    {
        Regions clientRegion = Regions.EU_WEST_2;
        AmazonRDS client = AmazonRDSClientBuilder.standard()
                        .withRegion(clientRegion)
                        .withCredentials(new ProfileCredentialsProvider())
                        .withClientConfiguration(clientConfiguration)
                        .build();
        AWSRDSDetailsModel allDetailsModel = new AWSRDSDetailsModel();
        DescribeAccountAttributesResult accountAttributes = client.describeAccountAttributes();
        long numberOfInstances = accountAttributes.getAccountQuotas()
                        .stream()
                        .filter(quota -> "DBInstances".equals(quota.getAccountQuotaName()))
                        .collect(Collectors.toList())
                        .get(0)
                        .getUsed();
        allDetailsModel.setNumberOfInstances(numberOfInstances);
        DescribeDBInstancesResult databaseInstances = client.describeDBInstances();
        List<DBInstance> instances = databaseInstances.getDBInstances();
        List<AWSRDSInstanceDetailsModel> instancesDetails = new ArrayList<>();

        for(DBInstance instance : instances)
        {
            java.util.Date instanceCreationDateTime = instance.getInstanceCreateTime();
            Date date = Date.of(instanceCreationDateTime.getYear() + 1900, instanceCreationDateTime.getMonth() + 1, instanceCreationDateTime.getDate());
            Time time = Time.of(instanceCreationDateTime.getHours(), instanceCreationDateTime.getMinutes(), instanceCreationDateTime.getSeconds());
            DateTime instanceCreationDateTimeTemp = DateTime.of(date, time);
            AWSRDSInstanceDetailsModel model = AWSRDSInstanceDetailsModel.builder()
                            .storageCapacityInGigaBytes(instance.getAllocatedStorage())
                            .availabilityZone(instance.getAvailabilityZone())
                            .DBInstanceServerType(instance.getDBInstanceClass())
                            .DBInstanceID(instance.getDBInstanceIdentifier())
                            .DBInstanceStatus(instance.getDBInstanceStatus())
                            .connectionURL(instance.getEndpoint().getAddress())
                            .databaseEngineName(instance.getEngine())
                            .databaseEngineVersion(instance.getEngineVersion())
                            .databaseCreationDateTime(instanceCreationDateTimeTemp)
                            .build();
            instancesDetails.add(model);
        }

        allDetailsModel.setInstancesDetails(instancesDetails);
        client.shutdown();
        return allDetailsModel;
    }
}