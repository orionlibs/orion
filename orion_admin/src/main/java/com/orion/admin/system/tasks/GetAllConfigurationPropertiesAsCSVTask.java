package com.orion.admin.system.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.document.csv.CSVWriterService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.source.configuration.model.ConfigurationModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllConfigurationPropertiesAsCSVTask extends Orion
{
    public static String run()
    {
        CSVWriterService csvService = new CSVWriterService();
        csvService.buildHeader(Arrays.asList("property name", "property value", "property type"));
        List<List<String>> properties = new ArrayList<List<String>>();

        for(ConfigurationModel prop : ConfigurationService.getAllProps())
        {
            properties.add(Arrays.asList(prop.getConfigurationKey(), prop.getConfigurationValue(), prop.getConfigurationType()));
        }

        csvService.buildBody(properties);
        return csvService.getCSV();
    }
}