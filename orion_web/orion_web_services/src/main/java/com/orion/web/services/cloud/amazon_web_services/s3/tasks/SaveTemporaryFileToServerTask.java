package com.orion.web.services.cloud.amazon_web_services.s3.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.file_system.file.FileService;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.data.source.configuration.ConfigurationService;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class SaveTemporaryFileToServerTask extends Orion
{
    public static File run(MultipartFile file, String fileNamePrefix)
    {

        if(file != null)
        {
            File tempFile = null;

            try
            {
                String fileExtension = FileService.getFileExtension(file.getOriginalFilename());
                String tempFolder = ConfigurationService.getProp("file.upload.temporary.path.on.aws.ec2.tomcat");
                String tempFileName = tempFolder;

                if(fileNamePrefix != null && !fileNamePrefix.isEmpty())
                {
                    tempFileName += fileNamePrefix + "-";
                }

                tempFileName += UUIDSecurityService.generateUUIDWithoutHyphens() + "." + fileExtension;
                tempFile = new File(tempFileName);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }

        }

        return null;
    }


    public static File run(String fileNameToUse, MultipartFile file)
    {

        if(file != null)
        {
            File tempFile = null;

            try
            {
                String tempFolder = ConfigurationService.getProp("file.upload.temporary.path.on.aws.ec2.tomcat");
                tempFile = new File(tempFolder + fileNameToUse);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }

        }

        return null;
    }
}