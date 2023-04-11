package com.orion.core.abstraction;

import com.orion.core.configuration.ConfigurationPropertyMissingException;
import com.orion.core.configuration.InvalidConfigurationPropertyException;
import com.orion.core.configuration.annotations.prop.PropertyDependencyInjectorService;
import com.orion.core.logger.LoggerService;
import com.orion.core.profile.Profile;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

public abstract class Orion implements Serializable
{
    public static String systemProfileMode = "localhost";
    public static String domainName = "localhost";


    public Orion()
    {

        if(this instanceof OrionConfigurable)
        {

            try
            {
                new PropertyDependencyInjectorService().injectToFields(this);
            }
            catch(InvocationTargetException e)
            {
                e.printStackTrace();
            }

        }

    }


    public static boolean isTesting()
    {
        return Profile.TestingProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotTesting()
    {
        return !isTesting();
    }


    public static boolean isLocalhost()
    {
        return Profile.LocalhostProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotLocalhost()
    {
        return !isLocalhost();
    }


    public static boolean isDev()
    {
        return Profile.DevProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotDev()
    {
        return !isDev();
    }


    public static boolean isProduction()
    {
        return Profile.ProductionProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotProduction()
    {
        return !isProduction();
    }


    protected static void log(String message, Object... parameters)
    {
        LoggerService.log(message, parameters);
    }


    protected static void logWarning(String message, Object... parameters)
    {
        LoggerService.logWarning(message, parameters);
    }


    protected static void logError(String message, Object... parameters)
    {
        LoggerService.logError(message, parameters);
    }


    protected static void logError(Throwable exception, String message, Object... parameters)
    {
        LoggerService.logError(exception, message, parameters);
    }


    public static boolean doesKeyExist(String key)
    {
        return System.getProperty(key) != null;
    }


    public static boolean containsPropKey(String key)
    {
        return doesKeyExist(key);
    }


    public static String getProp(String key)
    {
        return System.getProperty(key);
    }


    public static String getProp(String key, String defaultValue)
    {
        String value = System.getProperty(key);
        return (value != null) ? value : defaultValue;
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
            return Byte.parseByte(getProp(key));
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
            return Short.parseShort(getProp(key));
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
            return Integer.parseInt(getProp(key));
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
            return Long.parseLong(getProp(key));
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
            return Float.parseFloat(getProp(key));
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
            return Double.parseDouble(getProp(key));
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
            return new BigDecimal(getProp(key));
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