package com.orion.core.document.xml.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConvertXMLToObjectTask extends Orion
{
    public static Object run(Class<?> classToMapTheXMLData, File XMLFilePath) throws JAXBException
    {
        Assert.notNull(classToMapTheXMLData, "The given classToMapTheXMLData is null.");
        Assert.notNull(XMLFilePath, "The given XMLFilePath is null.");
        JAXBContext JAXBContext1 = JAXBContext.newInstance(classToMapTheXMLData);
        Unmarshaller JAXBUnmarshaller = JAXBContext1.createUnmarshaller();
        return JAXBUnmarshaller.unmarshal(XMLFilePath);
    }
}