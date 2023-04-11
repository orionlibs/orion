package com.orion.web.services.cloud.amazon_web_services;

import com.amazonaws.ClientConfiguration;
import com.orion.core.abstraction.OrionService;

public class AWSService extends OrionService
{
    public static ClientConfiguration getDefaultClientConfiguration()
    {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setClientExecutionTimeout(20000);
        clientConfiguration.setConnectionMaxIdleMillis(20000);
        clientConfiguration.setConnectionTimeout(20000);
        clientConfiguration.setMaxErrorRetry(2);
        clientConfiguration.setRequestTimeout(20000);
        return clientConfiguration;
    }
}