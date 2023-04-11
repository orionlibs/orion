package com.orion.web.services.cloud.amazon_web_services.ec2;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.cloud.amazon_web_services.AWSService;
import com.orion.web.services.cloud.amazon_web_services.ec2.tasks.GetAWSEC2DetailsTask;

public class AWSEC2Service extends OrionService
{
    public static AWSEC2DetailsModel getAWSEC2Details()
    {
        return GetAWSEC2DetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}