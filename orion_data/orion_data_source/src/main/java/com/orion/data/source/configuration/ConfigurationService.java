package com.orion.data.source.configuration;

import com.orion.core.configuration.ConfigurationPropertyMissingException;
import com.orion.core.configuration.InvalidConfigurationPropertyException;
import com.orion.data.source.configuration.data_access.ConfigurationDAO;
import com.orion.data.source.configuration.model.ConfigurationModel;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationService
{
    public static List<ConfigurationModel> getAllProps()
    {
        return ConfigurationDAO.getConfigurations();
    }


    public static List<ConfigurationModel> getAllPropsByType(String type)
    {
        return ConfigurationDAO.getConfigurationsByType(type);
    }


    public static List<String> getPropAsList(String key, String delimiter)
    {
        String value = getProp(key);

        if(value != null && !value.isEmpty())
        {
            return Arrays.asList(value.split(","));
        }
        else
        {
            return null;
        }

    }


    public static boolean doesKeyExist(String key)
    {
        return ConfigurationDAO.doesConfigurationKeyExist(key);
    }


    public static boolean doesValueExist(String value)
    {
        return ConfigurationDAO.doesConfigurationValueExist(value);
    }


    public static String getKeyFromValue(String value)
    {
        return ConfigurationDAO.getConfigurationKeyByValue(value);
    }


    public static List<String> getKeysFromValue(String value)
    {
        return ConfigurationDAO.getConfigurationKeysByValue(value);
    }


    public static void registerProp(String key, String value, String type)
    {
        ConfigurationDAO.save(key, value, type);
    }


    public static void registerProp(ConfigurationModel model)
    {
        ConfigurationDAO.save(model);
    }


    public static void updateProp(String key, String value, String type)
    {
        ConfigurationDAO.update(key, value, type);
    }


    public static void updateProp(ConfigurationModel model)
    {
        ConfigurationDAO.update(model);
    }


    public static void deleteProp(String key)
    {
        ConfigurationDAO.delete(key);
    }


    public static void deleteProp(ConfigurationModel model)
    {
        ConfigurationDAO.delete(model);
    }


    public static long getNumberOfProps()
    {
        return ConfigurationDAO.getNumberOfConfigurationProperties();
    }


    public static Map<String, String> getPropsAsMap()
    {
        Map<String, String> entries = new HashMap<>();
        getAllProps().forEach(prop -> entries.put(prop.getConfigurationKey(), prop.getConfigurationValue()));
        return entries;
    }


    public static boolean containsPropKey(String key)
    {
        return doesKeyExist(key);
    }


    public static boolean containsPropValue(String value)
    {
        return doesValueExist(value);
    }


    public static String getProp(String key)
    {
        return ConfigurationDAO.getConfigurationValueByKey(key);
    }


    public static String getProp(String key, String defaultValue)
    {
        String value = ConfigurationDAO.getConfigurationValueByKey(key);
        return (value != null) ? value : defaultValue;
    }


    public static ConfigurationModel getPropModel(String key)
    {
        return ConfigurationDAO.getConfigurationByKey(key);
    }


    public static ConfigurationModel getPropModel(String key, String defaultValue)
    {
        ConfigurationModel model = ConfigurationDAO.getConfigurationByKey(key);

        if(model == null)
        {
            model = ConfigurationModel.builder()
                            .configurationKey(key)
                            .configurationValue(defaultValue)
                            .configurationType("")
                            .build();
        }

        return model;
    }


    public static String getPropOrThrowException(String key) throws ConfigurationPropertyMissingException
    {
        String value = getProp(key);

        if(value == null)
        {
            throw new ConfigurationPropertyMissingException("Configuration property {} is missing.", key);
        }
        else
        {
            return value;
        }

    }


    public static String getPropWithPlaceholders(String key, List<String> propertyPlaceholders)
    {
        return getPropWithPlaceholders(key, null, propertyPlaceholders);
    }


    public static String getPropWithPlaceholders(String key, String defaultValue, List<String> propertyPlaceholders)
    {
        return applyPlaceholders(getProp(key, defaultValue), propertyPlaceholders);
    }


    private static String applyPlaceholders(String aString, List<String> placeholders)
    {

        if(aString != null && !aString.isEmpty() && placeholders != null && !placeholders.isEmpty())
        {
            Object[] placeholders1 = placeholders.toArray(new Object[0]);
            return MessageFormat.format(aString, placeholders1);
        }
        else
        {
            return aString;
        }

    }


    private static boolean keyIsNotEmpty(String key)
    {
        return key != null && !key.isEmpty();
    }


    public static Byte getByteProp(String key)
    {
        return getByteProp(key, Byte.MIN_VALUE);
    }


    public static Byte getByteProp(String key, byte defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Byte.parseByte(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Short getShortProp(String key)
    {
        return getShortProp(key, Short.MIN_VALUE);
    }


    public static Short getShortProp(String key, short defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Short.parseShort(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Integer getIntegerProp(String key)
    {
        return getIntegerProp(key, Integer.MIN_VALUE);
    }


    public static Integer getIntegerProp(String key, int defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Integer.parseInt(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Long getLongProp(String key)
    {
        return getLongProp(key, Long.MIN_VALUE);
    }


    public static Long getLongProp(String key, long defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Long.parseLong(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Float getFloatProp(String key)
    {
        return getFloatProp(key, Float.MIN_VALUE);
    }


    public static Float getFloatProp(String key, float defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Float.parseFloat(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Double getDoubleProp(String key)
    {
        return getDoubleProp(key, Double.MIN_VALUE);
    }


    public static Double getDoubleProp(String key, double defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return Double.parseDouble(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static BigDecimal getBigDecimalProp(String key)
    {
        return getBigDecimalProp(key, BigDecimal.ZERO);
    }


    public static BigDecimal getBigDecimalProp(String key, BigDecimal defaultValue)
    {

        if(keyIsNotEmpty(key))
        {

            try
            {
                return new BigDecimal(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }

        }

        return defaultValue;
    }


    public static Boolean getBooleanProp(String key)
    {
        return getBooleanProp(key, Boolean.FALSE);
    }


    public static Boolean getBooleanProp(String key, boolean defaultValue)
    {

        if(keyIsNotEmpty(key))
        {
            return Boolean.parseBoolean(getProp(key));
        }

        return defaultValue;
    }


    public static Character getCharacterProp(String key) throws InvalidConfigurationPropertyException
    {
        return getCharacterProp(key, Character.MIN_VALUE);
    }


    public static Character getCharacterProp(String key, char defaultValue) throws InvalidConfigurationPropertyException
    {

        if(keyIsNotEmpty(key))
        {
            String value = getProp(key);

            if(value.length() == 1)
            {
                return Character.valueOf(value.toCharArray()[0]);
            }
            else
            {
                throw new InvalidConfigurationPropertyException(String.format("The property value '{}', cannot be converted to a character object.", value));
            }

        }

        return defaultValue;
    }
}