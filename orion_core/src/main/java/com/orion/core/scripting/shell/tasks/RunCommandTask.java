package com.orion.core.scripting.shell.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.operating_system.OperatingSystemType;
import com.orion.core.scripting.shell.ShellCommand;
import com.orion.core.scripting.shell.ShellCommandResult;
import com.orion.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class RunCommandTask extends Orion
{
    public static ShellCommandResult run(ShellCommand command) throws InterruptedException
    {
        return run(command, null);
    }


    public static ShellCommandResult run(ShellCommand command, File workingDirectory) throws InterruptedException
    {
        Assert.notNull(command, "The command input cannot be null.");
        Assert.notNull(command.getOperatingSystemType(), "The operating system type cannot be null.");
        String[] commandParameters = getCommandParametersBasedOnOperatingSystemType(command);
        ProcessBuilder processBuilder = new ProcessBuilder(commandParameters);

        if(workingDirectory != null)
        {
            processBuilder = processBuilder.directory(workingDirectory);
        }

        ShellCommandResult result = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try
        {
            Process process = processBuilder.start();
            inputStreamReader = new InputStreamReader(process.getInputStream());
            reader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null)
            {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
            }

            result = new ShellCommandResult(sb.toString());
        }
        catch(IOException e)
        {
            result = new ShellCommandResult(true, e.getMessage());
        }
        finally
        {
            OrionUtils.closeResource(inputStreamReader);
            OrionUtils.closeResource(reader);
        }

        return result;
    }


    private static String[] getCommandParametersBasedOnOperatingSystemType(ShellCommand command)
    {
        String[] commandParameters = new String[2 + command.getCommandParameters().length];

        if(command.getOperatingSystemType().is(OperatingSystemType.Windows))
        {
            commandParameters[0] = "cmd.exe";
            commandParameters[1] = "/C";
        }
        else if(command.getOperatingSystemType().is(OperatingSystemType.Linux) || command.getOperatingSystemType().is(OperatingSystemType.MacOSX))
        {
            commandParameters[0] = "/bin/bash";
            commandParameters[1] = "-c";
        }

        IntStream.range(0, command.getCommandParameters().length)
                        .forEach(i -> commandParameters[i + 2] = command.getCommandParameters()[i]);
        return commandParameters;
    }
}