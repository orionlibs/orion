package oriondevtools;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class OrionTargetsCleanerService
{
    public static void main(String[] args)
    {
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_core/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_data/orion_data_source/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_web/orion_web_app/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_web/orion_web_user_access/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_web/orion_web_java_tag_library/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_web/orion_web_jsp_fragments/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_calendar/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_cryptology/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_computation/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_file_system/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_documents/orion_documents_json/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_documents/orion_documents_xml/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_reflection/target/classes");
        emptyDirectory("C:/workspaces/OrionPlatform/orionplatform/orion_strings/target/classes");
        System.out.println("Orion Cleaned!!");
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
}