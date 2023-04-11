package com.orion.data.geodata.postcode.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.geodata.postcode.model.DistanceBetweenPostcodesModel;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import java.util.Arrays;
import java.util.List;

public class DistancesBetweenPostcodesDAO extends OrionDAO
{
    public static DistanceBetweenPostcodesModel getByPostcodes(String postcode1, String postcode2)
    {
        DistanceBetweenPostcodesModel model = DistanceBetweenPostcodesModel.of(postcode1.toUpperCase().replace(" ", ""), postcode2.toUpperCase().replace(" ", ""));
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.geodataDatabaseName + GeodataDatabaseModel.tableDistancesBetweenPostcodes);
        mySQLQuery.where();
        mySQLQuery.leftParenthesis();
        mySQLQuery.columnsEqualsQuestionMarkConjunction(Arrays.asList(GeodataDatabaseModel.postcode1,
                        GeodataDatabaseModel.postcode2));
        mySQLQuery.rightParenthesis();
        mySQLQuery.or();
        mySQLQuery.leftParenthesis();
        mySQLQuery.columnsEqualsQuestionMarkConjunction(Arrays.asList(GeodataDatabaseModel.postcode2,
                        GeodataDatabaseModel.postcode1));
        mySQLQuery.rightParenthesis();
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            return (DistanceBetweenPostcodesModel)temp.get(0);
        }

        return null;
    }


    public static int save(DistanceBetweenPostcodesModel model)
    {
        Assert.notNull(model, "The given DistanceBetweenPostcodesModel is null.");
        return Database.saveModel(model,
                        GeodataDatabaseModel.tableDistancesBetweenPostcodes,
                        Database.geodataDatabaseName);
    }


    public static int update(DistanceBetweenPostcodesModel model)
    {
        Assert.notNull(model, "The given DistanceBetweenPostcodesModel is null.");
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableDistancesBetweenPostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcode1, GeodataDatabaseModel.postcode2));
    }
}