package com.orion.data.source.database.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionModel;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import java.util.List;

public class GetAllRowsWithAscendingOrderTask extends Orion
{
    public static List<Object> run(OrionModel emptyModel, String databaseTable, String databaseName, String ascendingOrderForColumn)
    {
        Assert.notNull(emptyModel, "The given emptyModel is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(databaseName + databaseTable);
        mySQLQuery.ascendingOrderByColumn(ascendingOrderForColumn);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, emptyModel);
    }
}