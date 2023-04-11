package com.orion.data.source.configuration.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.data.source.configuration.model.ConfigurationDatabaseModel;
import com.orion.data.source.database.Database;

public class VersionDAO extends OrionDAO
{
    public static long getNumberOfVersions()
    {
        return Database.getNumberOfRecords(ConfigurationDatabaseModel.tableVersion, Database.configurationDatabaseName);
    }
}