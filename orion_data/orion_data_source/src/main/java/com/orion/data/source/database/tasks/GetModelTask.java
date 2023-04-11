package com.orion.data.source.database.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionModel;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.data.source.security.DataSecurityService;
import com.orion.data.source.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class GetModelTask extends Orion
{
    public static List<Object> run(OrionModel model, OrionModel emptyModel, String databaseTable, String databaseName, List<String> columnsForCondition)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notNull(emptyModel, "The given emptyModel is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsForCondition, "The given columnsForCondition is null/empty.");
        OrionModel modelCopy = model.getCopy();

        try
        {
            DataSecurityService.encryptObject(modelCopy);
        }
        catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
        {
            //
        }

        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(databaseName + databaseTable);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(columnsForCondition);
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, emptyModel, mySQLQuery.getParameters());
    }


    public static List<Object> run(OrionModel model, OrionModel emptyModel, String databaseTable, String databaseName, List<String> columnNames, List<String> columnsForCondition)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notNull(emptyModel, "The given emptyModel is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        OrionModel modelCopy = model.getCopy();

        try
        {
            DataSecurityService.encryptObject(modelCopy);
        }
        catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
        {
            //
        }

        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumns(columnNames);
        mySQLQuery.fromTable(databaseName + databaseTable);

        if(columnsForCondition != null && !columnsForCondition.isEmpty())
        {
            mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(columnsForCondition);
            mySQLQuery.buildParametersArray(modelCopy);
        }

        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, emptyModel, mySQLQuery.getParameters());
    }
}