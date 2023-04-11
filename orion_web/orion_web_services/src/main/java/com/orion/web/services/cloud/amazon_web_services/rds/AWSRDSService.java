package com.orion.web.services.cloud.amazon_web_services.rds;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.cloud.amazon_web_services.AWSService;
import com.orion.web.services.cloud.amazon_web_services.rds.tasks.GetAWSRDSInstanceDetailsTask;

public class AWSRDSService extends OrionService
{
    public static AWSRDSDetailsModel getAWSRDSInstanceDetails()
    {
        return GetAWSRDSInstanceDetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}