package com.orion.admin.database;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.cloud.amazon_web_services.rds.AWSRDSDetailsModel;
import com.orion.web.services.cloud.amazon_web_services.rds.AWSRDSService;

public class AdminDatabaseService extends OrionService
{
    public static AWSRDSDetailsModel getRDSInstanceDetails()
    {
        return AWSRDSService.getAWSRDSInstanceDetails();
    }
}