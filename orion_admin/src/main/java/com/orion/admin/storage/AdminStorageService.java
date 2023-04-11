package com.orion.admin.storage;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.cloud.amazon_web_services.s3.AWSS3DetailsModel;
import com.orion.web.services.cloud.amazon_web_services.s3.AWSS3Service;

public class AdminStorageService extends OrionService
{
    public static AWSS3DetailsModel getAWSS3Details()
    {
        return AWSS3Service.getAWSS3Details();
    }
}