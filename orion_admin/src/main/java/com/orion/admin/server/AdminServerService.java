package com.orion.admin.server;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.cloud.amazon_web_services.ec2.AWSEC2DetailsModel;
import com.orion.web.services.cloud.amazon_web_services.ec2.AWSEC2Service;

public class AdminServerService extends OrionService
{
    public static AWSEC2DetailsModel getEC2Details()
    {
        return AWSEC2Service.getAWSEC2Details();
    }
}