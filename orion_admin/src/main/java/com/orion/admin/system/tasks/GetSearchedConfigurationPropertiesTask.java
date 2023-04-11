package com.orion.admin.system.tasks;

import com.orion.admin.system.SystemConfigurationPropertiesSearchOptions;
import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.ConfigurationProperty;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.source.configuration.model.ConfigurationModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetSearchedConfigurationPropertiesTask extends Orion
{
    public static Set<ConfigurationProperty> run(String key, int searchOption)
    {

        if(searchOption == SystemConfigurationPropertiesSearchOptions.Exact)
        {
            Set<ConfigurationProperty> propertiesFound = new HashSet<>();
            ConfigurationModel model = ConfigurationService.getPropModel(key);

            if(model != null)
            {
                propertiesFound.add(ConfigurationProperty.builder()
                                .key(key)
                                .value(model.getConfigurationValue())
                                .type(model.getConfigurationType())
                                .build());
            }

            return propertiesFound;
        }
        else
        {
            List<ConfigurationModel> models = ConfigurationService.getAllProps();
            List<ConfigurationModel> results = null;

            if(searchOption == SystemConfigurationPropertiesSearchOptions.StartsWith)
            {
                results = models.stream()
                                .filter(entry -> entry.getConfigurationKey().startsWith(key))
                                .collect(Collectors.toList());
            }
            else if(searchOption == SystemConfigurationPropertiesSearchOptions.Contains)
            {
                results = models.stream()
                                .filter(entry -> entry.getConfigurationKey().contains(key))
                                .collect(Collectors.toList());
            }
            else if(searchOption == SystemConfigurationPropertiesSearchOptions.EndsWith)
            {
                results = models.stream()
                                .filter(entry -> entry.getConfigurationKey().endsWith(key))
                                .collect(Collectors.toList());
            }

            Set<ConfigurationProperty> entries = new HashSet<>();

            for(ConfigurationModel propertyModel : results)
            {
                entries.add(ConfigurationProperty.builder()
                                .key(propertyModel.getConfigurationKey())
                                .value(propertyModel.getConfigurationValue())
                                .type(propertyModel.getConfigurationType())
                                .build());
            }

            return entries;
        }

    }
}