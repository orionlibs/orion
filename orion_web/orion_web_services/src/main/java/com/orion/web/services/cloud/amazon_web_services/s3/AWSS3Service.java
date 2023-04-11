package com.orion.web.services.cloud.amazon_web_services.s3;

import com.orion.core.abstraction.OrionService;
import com.orion.core.file_system.file.FileService;
import com.orion.web.core.urls.URLService;
import com.orion.web.services.cloud.amazon_web_services.AWSService;
import com.orion.web.services.cloud.amazon_web_services.s3.tasks.DeleteFileFromAWSS3Task;
import com.orion.web.services.cloud.amazon_web_services.s3.tasks.GetAWSS3DetailsTask;
import com.orion.web.services.cloud.amazon_web_services.s3.tasks.SaveTemporaryFileToServerTask;
import com.orion.web.services.cloud.amazon_web_services.s3.tasks.UploadFileToAWSS3AndGetFileURLTask;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class AWSS3Service extends OrionService
{
    public static File saveTemporaryFileToServer(MultipartFile file, String fileNameToUse)
    {
        return SaveTemporaryFileToServerTask.run(file, fileNameToUse);
    }


    public static File saveTemporaryFileToServer(String fileNameToUse, MultipartFile file)
    {
        return SaveTemporaryFileToServerTask.run(fileNameToUse, file);
    }


    public static String uploadFileAndGetFileURL(MultipartFile file, String bucketFolderName, String fileNamePrefix)
    {
        File tempFile = SaveTemporaryFileToServerTask.run(file, fileNamePrefix);
        return uploadFileAndGetFileURL(tempFile, bucketFolderName);
    }


    public static String uploadFileAndGetFileURL(String fileNameToUse, MultipartFile file, String bucketFolderName)
    {
        File tempFile = SaveTemporaryFileToServerTask.run(fileNameToUse, file);
        return uploadFileAndGetFileURL(tempFile, bucketFolderName);
    }


    public static String uploadFileAndGetFileURL(File file, String bucketFolderName)
    {
        String fileURL = UploadFileToAWSS3AndGetFileURLTask.run(AWSService.getDefaultClientConfiguration(), file, bucketFolderName);

        try
        {
            FileService.deleteFile(file);
        }
        catch(IOException e)
        {
        }

        return URLService.decodeURLWithUTF8(fileURL);
    }


    public static void deleteFile(String fileID)
    {
        DeleteFileFromAWSS3Task.run(AWSService.getDefaultClientConfiguration(), fileID);
    }


    public static AWSS3DetailsModel getAWSS3Details()
    {
        return GetAWSS3DetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}