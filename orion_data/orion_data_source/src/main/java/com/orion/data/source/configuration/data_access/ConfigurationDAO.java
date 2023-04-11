package com.orion.data.source.configuration.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.configuration.model.ConfigurationDatabaseModel;
import com.orion.data.source.configuration.model.ConfigurationModel;
import com.orion.data.source.database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigurationDAO extends OrionDAO
{
    public static long getNumberOfConfigurationProperties()
    {
        return Database.getNumberOfRecords(ConfigurationDatabaseModel.tableConfiguration, Database.configurationDatabaseName);
    }


    public static boolean doesConfigurationKeyExist(String configurationKey)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.of(configurationKey);
        return Database.doesRowExistWithConditionConjunction(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }


    public static boolean doesConfigurationValueExist(String configurationValue)
    {
        Assert.notEmpty(configurationValue, "The given configurationValue is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationValue(configurationValue)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationValue));
    }


    public static ConfigurationModel getConfigurationByKey(String configurationKey)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.of(configurationKey);
        return (ConfigurationModel)Database.getOneModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }


    public static String getConfigurationKeyByValue(String configurationValue)
    {
        Assert.notEmpty(configurationValue, "The given configurationValue is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationValue(configurationValue)
                        .build();
        Object temp = Database.getOneModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationValue));
        return (temp != null) ? ((ConfigurationModel)temp).getConfigurationKey() : "";
    }


    public static List<ConfigurationModel> getConfigurations()
    {
        List<Object> temp = Database.getAllRows(ConfigurationModel.of(),
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName);
        List<ConfigurationModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((ConfigurationModel)result));
        }

        return results;
    }


    public static List<String> getConfigurationKeysByValue(String configurationValue)
    {
        Assert.notEmpty(configurationValue, "The given configurationValue is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationValue(configurationValue)
                        .build();
        List<Object> temp = Database.getModels(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationValue));
        List<String> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add(((ConfigurationModel)result).getConfigurationKey()));
        }

        return results;
    }


    public static String getConfigurationValueByKey(String configurationKey)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.of(configurationKey);
        Object temp = Database.getOneModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
        return (temp != null) ? ((ConfigurationModel)temp).getConfigurationValue() : "";
    }


    public static List<ConfigurationModel> getConfigurationsByType(String configurationType)
    {
        Assert.notEmpty(configurationType, "The given configurationType is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationType(configurationType)
                        .build();
        List<Object> temp = Database.getModels(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationType));
        List<ConfigurationModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((ConfigurationModel)result));
        }

        return results;
    }


    public static int save(ConfigurationModel model)
    {
        return Database.saveModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName);
    }


    public static int save(String configurationKey, String configurationValue, String configurationType)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationKey(configurationKey)
                        .configurationValue(configurationValue)
                        .configurationType(configurationType)
                        .build();
        return Database.saveModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName);
    }


    public static int update(ConfigurationModel model)
    {
        return Database.updateModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }


    public static int update(String configurationKey, String configurationValue, String configurationType)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.builder()
                        .configurationKey(configurationKey)
                        .configurationValue(configurationValue)
                        .configurationType(configurationType)
                        .build();
        return Database.updateModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }


    public static int delete(String configurationKey)
    {
        Assert.notEmpty(configurationKey, "The given configurationKey is null/empty.");
        ConfigurationModel model = ConfigurationModel.of(configurationKey);
        return Database.deleteModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }


    public static int delete(ConfigurationModel model)
    {
        return Database.deleteModel(model,
                        ConfigurationDatabaseModel.tableConfiguration,
                        Database.configurationDatabaseName,
                        Arrays.asList(ConfigurationDatabaseModel.configurationKey));
    }
}