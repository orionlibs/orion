package com.orion.maven.plugin.file_merger;

import java.io.File;
import java.util.List;
import org.apache.maven.plugins.annotations.Parameter;

public class Merge
{
    @Parameter(property = "target", required = true)
    private File target;
    @Parameter(property = "sources", required = false)
    private List<File> sources;
    @Parameter(property = "fileExtension", required = false)
    private String fileExtension;
    @Parameter(property = "override")
    private boolean override;
    @Parameter(defaultValue = "${project.basedir}", readonly = true)
    private File searchDir;


    public File getTarget()
    {
        return target;
    }


    public List<File> getSources()
    {
        return sources;
    }


    public String getFileExtension()
    {
        return fileExtension;
    }


    public boolean isOverride()
    {
        return override;
    }


    public File getSearchDir()
    {
        return searchDir;
    }


    @Override
    public String toString()
    {
        return "Merge [target=" + target + ", sources=" + sources + ", fileExtension=" + getFileExtension() + ", override=" + override + ", searchDir=" + searchDir + "]";
    }
}