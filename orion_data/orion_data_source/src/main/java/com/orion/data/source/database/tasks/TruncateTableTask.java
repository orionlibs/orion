package com.orion.data.source.database.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;

public class TruncateTableTask extends Orion
{
    public static int run(String databaseTable, String databaseName)
    {
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.truncateTable(databaseName + databaseTable);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL);
    }
}