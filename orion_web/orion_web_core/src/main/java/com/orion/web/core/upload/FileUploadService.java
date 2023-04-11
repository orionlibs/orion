package com.orion.web.core.upload;

import com.orion.core.abstraction.OrionService;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;

public class FileUploadService extends OrionService
{
    public static void uploadFileToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, String fileLocation)
    {
        FileUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .fileLocation(fileLocation)
                        .build()
                        .upload();
    }


    public static void uploadStreamToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, InputStream stream)
    {
        StreamUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .stream(stream)
                        .build()
                        .upload();
    }


    public static void uploadTextToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, String contentToUpload)
    {
        TextUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .contentToUpload(contentToUpload)
                        .build()
                        .upload();
    }
}