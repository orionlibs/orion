package com.orion.admin.system;

import com.orion.admin.system.tasks.GetAllConfigurationPropertiesAsCSVTask;
import com.orion.admin.system.tasks.GetSearchedConfigurationPropertiesTask;
import com.orion.core.abstraction.OrionService;
import com.orion.core.configuration.ConfigurationProperty;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.source.configuration.model.ConfigurationModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminSystemConfigurationService extends OrionService
{
    public static boolean containsPropKey(String key)
    {
        return ConfigurationService.containsPropKey(key);
    }


    public static Set<Map.Entry<String, String>> getAllOfConfigurationPropertiesAsSetOfMapEntries()
    {
        return ConfigurationService.getPropsAsMap().entrySet();
    }


    public static List<ConfigurationProperty> getAllOfConfigurationProperties()
    {
        List<ConfigurationModel> models = ConfigurationService.getAllProps();
        List<ConfigurationProperty> props = new ArrayList<>();
        models.forEach(model -> props.add(ConfigurationProperty.builder()
                        .key(model.getConfigurationKey())
                        .value(model.getConfigurationValue())
                        .type(model.getConfigurationType())
                        .build()));
        return props;
    }


    public static long getNumberOfConfigurationProperties()
    {
        return ConfigurationService.getNumberOfProps();
    }


    public static Set<ConfigurationProperty> getProps(String key, int searchOption)
    {
        return GetSearchedConfigurationPropertiesTask.run(key, searchOption);
    }


    public static void updateProp(String key, String value, String type)
    {
        ConfigurationService.updateProp(key, value, type);
    }


    public static void registerProp(String key, String value, String type)
    {
        ConfigurationService.registerProp(key, value, type);
    }


    public static void deleteProp(String key)
    {
        ConfigurationService.deleteProp(key);
    }


    public static String getAllConfigurationPropertiesAsCSV()
    {
        return GetAllConfigurationPropertiesAsCSVTask.run();
    }
}