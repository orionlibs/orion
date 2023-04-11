package com.orion.web.services.cloud.amazon_web_services.s3.tasks;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.LoggingService;
import com.orion.web.services.cloud.amazon_web_services.CloudAWSErrorType;
import com.orion.web.services.cloud.amazon_web_services.s3.CloudAWSS3Errors;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadFileToAWSS3AndGetFileURLTask extends Orion
{
    public static String run(ClientConfiguration clientConfiguration, File file, String bucketFolderName)
    {
        return run(clientConfiguration, file, bucketFolderName, CannedAccessControlList.PublicRead);
    }


    public static String run(ClientConfiguration clientConfiguration, File file, String bucketFolderName, CannedAccessControlList fileAccessMode)
    {

        if(file != null)
        {
            Regions clientRegion = Regions.EU_WEST_2;
            String bucketName = ConfigurationService.getProp("cloud.aws.s3.bucket.name");
            String keyName = bucketFolderName + "/" + file.getName();
            long contentLength = file.length();
            long partSize = 5 * 1024 * 1024;

            try
            {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                                .withRegion(clientRegion)
                                .withCredentials(new ProfileCredentialsProvider())
                                .withClientConfiguration(clientConfiguration)
                                .build();
                List<PartETag> partETags = new ArrayList<>();
                InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, keyName);
                initRequest.setCannedACL(CannedAccessControlList.PublicRead);
                InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);
                long filePosition = 0;

                for(int i = 1; filePosition < contentLength; i++)
                {
                    //Because the last part could be less than 5 MB, adjust the part size as needed.
                    partSize = Math.min(partSize, (contentLength - filePosition));
                    UploadPartRequest uploadRequest = new UploadPartRequest()
                                    .withBucketName(bucketName)
                                    .withKey(keyName)
                                    .withUploadId(initResponse.getUploadId())
                                    .withPartNumber(i)
                                    .withFileOffset(filePosition)
                                    .withFile(file)
                                    .withPartSize(partSize);
                    //.withCannedAcl(CannedAccessControlList.PublicRead)
                    UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                    partETags.add(uploadResult.getPartETag());
                    filePosition += partSize;
                }

                CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, keyName, initResponse.getUploadId(), partETags);
                CompleteMultipartUploadResult result = s3Client.completeMultipartUpload(compRequest);
                return result.getLocation();
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

        return null;
    }
}