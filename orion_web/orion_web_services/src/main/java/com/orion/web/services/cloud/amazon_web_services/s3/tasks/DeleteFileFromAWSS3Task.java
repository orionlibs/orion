package com.orion.web.services.cloud.amazon_web_services.s3.tasks;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.LoggingService;
import com.orion.web.services.cloud.amazon_web_services.CloudAWSErrorType;
import com.orion.web.services.cloud.amazon_web_services.s3.CloudAWSS3Errors;

public class DeleteFileFromAWSS3Task extends Orion
{
    public static void run(ClientConfiguration clientConfiguration, String fileID)
    {

        if(fileID != null)
        {
            Regions clientRegion = Regions.EU_WEST_2;
            String bucketName = ConfigurationService.getProp("cloud.aws.s3.bucket.name");

            try
            {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                                .withRegion(clientRegion)
                                .withCredentials(new ProfileCredentialsProvider())
                                .withClientConfiguration(clientConfiguration)
                                .build();
                s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileID));
            }
            catch(AmazonServiceException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }
            catch(SdkClientException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3UnreachableProblem);
            }
            catch(Exception e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }

        }

    }
}