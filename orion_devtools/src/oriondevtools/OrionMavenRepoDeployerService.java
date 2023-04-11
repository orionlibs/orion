package oriondevtools;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class OrionMavenRepoDeployerService
{
    private static String orionPlatformHomePath = "C:/workspaces/OrionPlatform";
    private static String releasesMavenRepoPath = orionPlatformHomePath + "/OrionPlatformMavenRepo/releases";
    private static String readmeFilePath = releasesMavenRepoPath + "/README.md";


    public static void main(String[] args) throws IOException
    {
        emptyDirectory(releasesMavenRepoPath);
        copyFile(orionPlatformHomePath + "/OrionPlatformMavenRepo/README.md", readmeFilePath);
        File orionHomePath = new File(orionPlatformHomePath + "/orionplatform");
        copyOrionJARFilesToMavenReleasesPath(orionHomePath);
        System.out.println("Maven Repo Deployed!!");
    }


    private static void copyOrionJARFilesToMavenReleasesPath(File orionHomePath) throws IOException
    {
        File[] files = orionHomePath.listFiles();

        for(File file : files)
        {

            if(file.isDirectory() && !".git".equals(file.getName()))
            {

                if("target".equals(file.getName()))
                {
                    copyFilesToRepo(file);
                    break;
                }
                else
                {
                    copyOrionJARFilesToMavenReleasesPath(file);
                }

            }

        }

    }


    private static void copyFilesToRepo(File file) throws IOException
    {
        File[] targetFiles = file.listFiles();

        for(File targetFile : targetFiles)
        {

            if(targetFile.isDirectory() && "mvn-repo".equals(targetFile.getName()))
            {
                copyDirectory(targetFile.getAbsolutePath(), releasesMavenRepoPath);
                break;
            }

        }

    }


    private static void emptyDirectory(String directory) throws IOException
    {
        FileUtils.cleanDirectory(new File(directory));
    }


    private static void copyDirectory(String directoryToCopy, String destinationDirectory) throws IOException
    {
        FileUtils.copyDirectory(new File(directoryToCopy), new File(destinationDirectory));
    }


    private static void copyFile(String fileToCopy, String destinationfile) throws IOException
    {
        FileUtils.copyFile(new File(fileToCopy), new File(destinationfile));
    }
}