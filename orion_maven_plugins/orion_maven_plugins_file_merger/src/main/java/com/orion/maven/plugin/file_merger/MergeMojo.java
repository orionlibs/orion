package com.orion.maven.plugin.file_merger;

import edu.emory.mathcs.backport.java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "merge", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class MergeMojo extends AbstractMojo
{
    @Parameter(property = "merges", required = true)
    private List<Merge> merges;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException
    {

        for(Merge merge : merges)
        {
            createTargetFile(merge);

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(merge.getTarget(), true)))
            {

                for(File file : getSources(merge))
                {

                    if(file.isDirectory())
                    {
                        merge(checkSourceDirectory(file), writer);
                    }
                    else
                    {
                        merge(checkSourceFile(file), writer);
                    }

                }

            }
            catch(MojoExecutionException e)
            {
                throw e;
            }
            catch(Exception e)
            {
                throw new MojoExecutionException("Failed to write into target file", e);
            }

        }

    }


    private List<File> getSources(Merge merge) throws MojoExecutionException
    {

        if(merge.getSources() != null)
        {
            return merge.getSources();
        }
        else if(merge.getFileExtension() != null)
        {

            if(!merge.getSearchDir().isDirectory())
            {
                throw new MojoExecutionException("searchDir is not a directory: " + merge.getSearchDir().getAbsolutePath());
            }

            List<String> fileNames = Arrays.stream(merge.getSearchDir().toPath().toFile().listFiles())
                            .map(file -> file.getName())
                            .filter(fileName -> fileName.endsWith(merge.getFileExtension()))
                            .collect(Collectors.toList());
            Collections.sort(fileNames);
            List<File> files = new ArrayList<>();

            for(String fileToMerge : fileNames)
            {
                String fileAbsolutePath = merge.getSearchDir().toPath().toFile().getAbsolutePath() + "/" + fileToMerge;
                System.out.println(fileAbsolutePath);
                files.add(new File(fileAbsolutePath));
            }

            return files;
        }
        else
        {
            throw new MojoExecutionException("Failed to find files to merge, <sources> or <pattern> are not defined");
        }

    }


    private void createTargetFile(Merge merge) throws MojoExecutionException
    {
        File file = merge.getTarget();

        if(file.isDirectory())
        {
            throw new MojoExecutionException("Target file cannot be a directory: " + file.getAbsolutePath());
        }

        if(!merge.isOverride() && file.exists())
        {
            throw new MojoExecutionException("Target file already exists: " + file.getAbsolutePath());
        }

        File parentFile = file.getParentFile();

        if(!parentFile.exists() && !parentFile.mkdirs())
        {
            throw new MojoExecutionException("Could not create target parent directory: " + parentFile.getAbsolutePath());
        }

        if(!parentFile.isDirectory())
        {
            throw new MojoExecutionException("Target parent file is not a directory: " + parentFile.getAbsolutePath());
        }

        if(merge.isOverride())
        {
            file.delete();
        }

        try
        {

            if(!file.createNewFile())
            {
                throw new MojoExecutionException("Could not create target file: " + file.getAbsolutePath());
            }

        }
        catch(IOException e)
        {
            throw new MojoExecutionException("Failed to create target file: " + file.getAbsolutePath(), e);
        }

    }


    private File checkSourceFile(File file) throws MojoExecutionException
    {

        if(!file.exists())
        {
            throw new MojoExecutionException("Source file " + file.getAbsolutePath() + " does not exist.");
        }

        return file;
    }


    private List<File> checkSourceDirectory(File file) throws MojoExecutionException
    {
        List<File> sourceFiles = new ArrayList<>();
        checkSourceFile(file);
        File[] files = file.listFiles();
        Arrays.sort(files);
        List<File> subFiles = new ArrayList<>();

        for(File subFile : files)
        {

            if(subFile.isDirectory())
            {
                sourceFiles.addAll(checkSourceDirectory(subFile));
            }
            else
            {
                subFiles.add(checkSourceFile(subFile));
            }

        }

        sourceFiles.addAll(subFiles);
        return sourceFiles;
    }


    private void merge(File file, BufferedWriter writer) throws MojoExecutionException
    {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            String line = null;
            writer.newLine();

            while((line = reader.readLine()) != null)
            {
                writer.write(line);
                writer.newLine();
            }

        }
        catch(Exception e)
        {
            throw new MojoExecutionException("Failed to write source file " + file.getAbsolutePath(), e);
        }

    }


    private void merge(List<File> files, BufferedWriter writer) throws MojoExecutionException
    {

        for(File file : files)
        {
            merge(file, writer);
        }

    }
}