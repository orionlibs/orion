package oriondevtools;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class OrionWebAppDeployerService
{
    public static void main(String[] args)
    {
        emptyDirectory("C:/tomcat9/work");
        emptyDirectory("C:/tomcat9/webapps/ROOT");
        copyDirectory("C:/workspaces/OrionPlatform/orionplatform/orionplatform_webapp/target/orionplatform_webapp-1.0.0", "C:/tomcat10/webapps/ROOT");
        System.out.println("Deployed!!");
    }


    private static void emptyDirectory(String directory)
    {

        try
        {
            FileUtils.cleanDirectory(new File(directory));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

    }


    private static void copyDirectory(String directoryToCopy, String destinationDirectory)
    {

        try
        {
            FileUtils.copyDirectory(new File(directoryToCopy), new File(destinationDirectory));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

    }
}