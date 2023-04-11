package com.orion.data.source.configuration.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class ConfigurationDatabaseModel
{
    public static final String tableVersion = "." + "version";
    public static final String version = "version";
    public static final String majorVersion = "majorVersion";
    public static final String minorVersion = "minorVersion";
    public static final String patchVersion = "patchVersion";
    public static final String tableConfiguration = "." + "configuration";
    public static final String configurationKey = "configurationKey";
    public static final String configurationValue = "configurationValue";
    public static final String configurationType = "configurationType";
}