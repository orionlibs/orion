package com.orion.core.document.velocity.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class GetVelocityTemplateFromFileAsStringTask extends Orion
{
    public static String run(VelocityEngine velocityEngine, VelocityContext velocityContext, String velocityTemplateFilePath) throws ResourceNotFoundException, ParseErrorException
    {
        Assert.notNull(velocityEngine, "The given velocityEngine input cannot be null.");
        Assert.notNull(velocityContext, "The given velocityContext input cannot be null.");
        Assert.notEmpty(velocityTemplateFilePath, "The given velocityTemplateFilePath input cannot be null/empty.");
        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate(velocityTemplateFilePath, "utf-8", velocityContext, writer);
        return writer.toString();
    }
}