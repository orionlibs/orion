package com.orion.core.document.velocity;

import com.orion.core.abstraction.OrionService;
import com.orion.core.document.velocity.tasks.BuildVelocityTemplateContextTask;
import com.orion.core.document.velocity.tasks.GetVelocityTemplateAsStringTask;
import com.orion.core.document.velocity.tasks.GetVelocityTemplateFromFileAsStringTask;
import com.orion.core.document.velocity.tasks.InitialiseVelocityEngineTask;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocityTemplateService extends OrionService
{
    public static VelocityEngine initialiseVelocityEngine()
    {
        return InitialiseVelocityEngineTask.run();
    }


    public static VelocityContext buildVelocityContext()
    {
        return BuildVelocityTemplateContextTask.run();
    }


    public static VelocityContext buildVelocityContext(Map<String, String> templateParametersMapper)
    {
        return BuildVelocityTemplateContextTask.run(templateParametersMapper);
    }


    public static String getVelocityTemplateFromFileAsString(VelocityEngine velocityEngine, VelocityContext velocityContext, String velocityTemplateFilePath) throws ResourceNotFoundException, ParseErrorException
    {
        return GetVelocityTemplateFromFileAsStringTask.run(velocityEngine, velocityContext, velocityTemplateFilePath);
    }


    public static String getVelocityTemplateFromFileAsString(Map<String, String> templateParametersMapper, String velocityTemplateFilePath) throws ResourceNotFoundException, ParseErrorException
    {
        return GetVelocityTemplateFromFileAsStringTask.run(initialiseVelocityEngine(), buildVelocityContext(templateParametersMapper), velocityTemplateFilePath);
    }


    public static String getVelocityTemplateFromFileAsString(String velocityTemplateFilePath) throws ResourceNotFoundException, ParseErrorException
    {
        return GetVelocityTemplateFromFileAsStringTask.run(initialiseVelocityEngine(), buildVelocityContext(), velocityTemplateFilePath);
    }


    public static String getVelocityTemplateAsString(Map<String, String> templateParametersMapper, String velocityTemplateName, String velocityTemplate) throws ParseErrorException
    {
        return GetVelocityTemplateAsStringTask.run(initialiseVelocityEngine(), buildVelocityContext(templateParametersMapper), velocityTemplateName, velocityTemplate);
    }


    public static String getVelocityTemplateAsString(String velocityTemplateName, String velocityTemplate) throws ParseErrorException
    {
        return GetVelocityTemplateAsStringTask.run(initialiseVelocityEngine(), buildVelocityContext(), velocityTemplateName, velocityTemplate);
    }
}