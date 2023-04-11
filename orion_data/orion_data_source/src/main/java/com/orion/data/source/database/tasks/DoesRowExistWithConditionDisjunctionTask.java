package com.orion.data.source.database.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionModel;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.data.source.security.DataSecurityService;
import com.orion.data.source.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class DoesRowExistWithConditionDisjunctionTask extends Orion
{
    public static boolean run(OrionModel model, String databaseTable, String databaseName, List<String> columnsForCondition)
    {
        Assert.notNull(model, "The given model is null.");
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
        mySQLQuery.existsWithConditionDisjunction(databaseName + databaseTable, columnsForCondition);
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, Boolean.FALSE, mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            return (boolean)temp.get(0);
        }

        return false;
    }
}