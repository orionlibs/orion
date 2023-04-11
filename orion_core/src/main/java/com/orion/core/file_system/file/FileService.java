package com.orion.core.file_system.file;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.core.file_system.FileSystemService;
import com.orion.core.file_system.file.tasks.AppendToFileTask;
import com.orion.core.file_system.file.tasks.ConvertFileToStringListTask;
import com.orion.core.file_system.file.tasks.ConvertFileToStringTask;
import com.orion.core.file_system.file.tasks.ConvertURLToFileTask;
import com.orion.core.file_system.file.tasks.CreateFileTask;
import com.orion.core.file_system.file.tasks.DeleteFileTask;
import com.orion.core.file_system.file.tasks.DownloadFileTask;
import com.orion.core.file_system.file.tasks.GetFileExtensionTask;
import com.orion.core.file_system.file.tasks.MoveFileTask;
import com.orion.core.file_system.file.tasks.ReadFirstLineFromFileTask;
import com.orion.core.file_system.file.tasks.SaveFileTask;
import com.orion.core.file_system.file.tasks.SaveStringToFileTask;
import com.orion.core.file_system.file.tasks.UploadFileTask;
import com.orion.core.file_system.stream.FileSystemStreamsService;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.util.List;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.web.multipart.MultipartFile;

public class FileService extends OrionService
{
    /*public static void main(String[] args) throws IOException
    {
        List<String> lines = convertFileToStringList("D:/temp/onelivery.txt");
        String content = "";
    
        for(int i = 0; i < lines.size() - 1; i++)
        {
    
            for(int j = i + 1; j < lines.size(); j++)
            {
                content += lines.get(i) + " -- " + lines.get(j);
    
                if(i != lines.size() - 1 || j != lines.size())
                {
                    content += "\n";
                }
    
            }
    
        }
    
        saveStringToFile("D:/temp/onelivery1.txt", content);
    }*/
    public static String convertFileResourceToString(String filePath) throws FileNotFoundException, IOException
    {
        return new String(FileService.class.getResourceAsStream(filePath).readAllBytes(), Charset.forName("UTF-8"));
    }


    public static File convertURLToFile(URL file)
    {
        return ConvertURLToFileTask.run(file);
    }


    public static String convertFileToString(String filePath) throws FileNotFoundException, IOException
    {
        return ConvertFileToStringTask.run((BufferedReader)FileSystemStreamsService.getReaderForFile(filePath));
    }


    public static String convertFileToString(File file) throws FileNotFoundException, IOException
    {
        return ConvertFileToStringTask.run((BufferedReader)FileSystemStreamsService.getReaderForFile(file));
    }


    public static List<String> convertFileToStringList(String filePath) throws IOException
    {
        return ConvertFileToStringListTask.run((BufferedReader)FileSystemStreamsService.getReaderForFile(filePath));
    }


    public static List<String> convertFileToStringList(File file) throws IOException
    {
        return ConvertFileToStringListTask.run((BufferedReader)FileSystemStreamsService.getReaderForFile(file));
    }


    public static String readFirstLine(File file) throws IOException
    {
        return ReadFirstLineFromFileTask.run((BufferedReader)FileSystemStreamsService.getReaderForFile(file));
    }


    public static void saveStringToFile(String filePath, String fileContent, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        new SaveStringToFileTask().run(filePath, fileContent, addEmptyLineAtTheEndOfTheFile);
    }


    public static void saveStringToFile(File file, String fileContent, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        new SaveStringToFileTask().run(file, fileContent, addEmptyLineAtTheEndOfTheFile);
    }


    public static void saveStringToFile(String filePath, String fileContent) throws IOException
    {
        new SaveStringToFileTask().run(filePath, fileContent);
    }


    public static void saveStringToFile(File file, String fileContent) throws IOException
    {
        new SaveStringToFileTask().run(file, fileContent);
    }


    public static void renameFile(String originalFilePath, String newFileName) throws IOException
    {
        FileSystemService.renameFileOrDirectory(originalFilePath, newFileName);
    }


    public static void renameFile(File originalFile, String newFileName) throws IOException
    {
        FileSystemService.renameFileOrDirectory(originalFile, newFileName);
    }


    public static void downloadFile(String URLResourceToDownload, String filePathToDownloadTo) throws IOException
    {
        DownloadFileTask.run(URLResourceToDownload, filePathToDownloadTo);
    }


    public static BufferedInputStream downloadFileAsStream(String URLResourceToDownload) throws IOException
    {
        //Response response = Jsoup.connect(URLResourceToDownload).validateTLSCertificates(false).ignoreContentType(true).execute();
        Response response = Jsoup.connect(URLResourceToDownload).ignoreContentType(true).execute();
        return response.bodyStream();
    }


    public static void uploadFile(MultipartFile fileToUpload, String filePathToDownloadTo, String fileName) throws IOException
    {
        UploadFileTask.run(fileToUpload, filePathToDownloadTo, fileName);
    }


    public static void createFile(String newFileName) throws IOException
    {
        CreateFileTask.run(newFileName);
    }


    public static void createFile(File newFileName) throws IOException
    {
        CreateFileTask.run(newFileName);
    }


    public static void copyFile(String filePathToCopy, String destinationFilePath) throws InvalidPathException, IOException
    {
        Assert.notEmpty(filePathToCopy, "filePathToCopy input cannot be null/empty.");
        Assert.notEmpty(destinationFilePath, "destinationFilePath input cannot be null/empty.");
        copyFile(new File(filePathToCopy), new File(destinationFilePath));
    }


    public static void copyFile(File filePathToCopy, File destinationFilePath) throws InvalidPathException, IOException
    {
        Assert.notNull(filePathToCopy, "filePathToCopy input cannot be null.");
        Assert.notNull(destinationFilePath, "destinationFilePath input cannot be null.");
        Files.copy(filePathToCopy.toPath(), destinationFilePath.toPath());
    }


    public static void copyFile(File filePathToCopy, String destinationFilePath) throws InvalidPathException, IOException
    {
        copyFile(filePathToCopy, new File(destinationFilePath));
    }


    public static void copyFile(String filePathToCopy, File destinationFilePath) throws InvalidPathException, IOException
    {
        copyFile(new File(filePathToCopy), destinationFilePath);
    }


    public static void moveFile(String filePathToMove, String destinationFilePath) throws InvalidPathException, IOException
    {
        MoveFileTask.run(filePathToMove, destinationFilePath);
    }


    public static void moveFile(File filePathToMove, File destinationFilePath) throws InvalidPathException, IOException
    {
        MoveFileTask.run(filePathToMove, destinationFilePath);
    }


    public static void moveFile(File filePathToMove, String destinationFilePath) throws InvalidPathException, IOException
    {
        MoveFileTask.run(filePathToMove, destinationFilePath);
    }


    public static void moveFile(String filePathToMove, File destinationFilePath) throws InvalidPathException, IOException
    {
        MoveFileTask.run(filePathToMove, destinationFilePath);
    }


    public static void saveFile(MultipartFile file, String destinationFilePath) throws IOException
    {
        SaveFileTask.run(file, destinationFilePath);
    }


    public static void saveFile(MultipartFile file, File destinationFilePath) throws IOException
    {
        SaveFileTask.run(file, destinationFilePath);
    }


    public static void deleteFile(String filePathToDelete) throws IOException
    {
        DeleteFileTask.run(filePathToDelete);
    }


    public static void deleteFile(File filePathToDelete) throws IOException
    {
        DeleteFileTask.run(filePathToDelete);
    }


    public static boolean appendToFile(String file, String contentsToAppend)
    {
        return appendToFile(new File(file), contentsToAppend);
    }


    public static boolean appendToFile(File file, String contentsToAppend)
    {
        return AppendToFileTask.run(file, contentsToAppend);
    }


    public static String getFileExtension(String fileName)
    {
        return GetFileExtensionTask.run(fileName);
    }


    public static InputStream getFileAsInputStream(File file) throws IOException
    {
        return Files.newInputStream(file.toPath());
    }


    public static InputStream getFileAsInputStream(String fileLocation) throws IOException
    {
        return Files.newInputStream(new File(fileLocation).toPath());
    }
}