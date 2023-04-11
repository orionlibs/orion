package com.orion.data.geodata.postcode.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.geodata.postcode.model.PostcodePrefixVoteModel;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostcodePrefixVotesDAO extends OrionDAO
{
    public static boolean doesRowExistByPostcodePrefix(PostcodePrefixVoteModel model)
    {
        Assert.notNull(model, "The given PostcodePrefixVoteModel is null/empty.");
        return Database.doesRowExistWithConditionConjunction(model,
                        GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodePrefix));
    }


    public static List<PostcodePrefixVoteModel> getPostcodePrefixVotes()
    {
        List<Object> temp = Database.getAllRows(PostcodePrefixVoteModel.of(),
                        GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName);
        List<PostcodePrefixVoteModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((PostcodePrefixVoteModel)result));
        }

        return results;
    }


    public static int incrementVoteByPostcodePrefix(PostcodePrefixVoteModel model)
    {
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.updateTable(Database.geodataDatabaseName + GeodataDatabaseModel.tablePostcodePrefixVotes);
        mySQLQuery.set();
        mySQLQuery.columnWithExpression(GeodataDatabaseModel.numberOfVotes,
                        "=" + GeodataDatabaseModel.numberOfVotes + "+1");
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(GeodataDatabaseModel.postcodePrefix));
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();

        try
        {
            return Database.runSQL(SQL, mySQLQuery.getParameters());
        }
        catch(Exception e)
        {
            return 0;
        }

    }


    public static int savePostcodePrefixVote(PostcodePrefixVoteModel model)
    {
        Assert.notNull(model, "The given PostcodePrefixVoteModel is null.");
        return Database.saveModel(model,
                        GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName);
    }


    public static int updatePostcodePrefixVote(PostcodePrefixVoteModel model)
    {
        Assert.notNull(model, "The given PostcodePrefixVoteModel is null.");
        return Database.updateModel(model,
                        GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodePrefix));
    }


    public static int deleteByPostcodePrefix(String postcodePrefix)
    {
        Assert.notEmpty(postcodePrefix, "The given postcodePrefix is null/empty.");
        PostcodePrefixVoteModel model = PostcodePrefixVoteModel.builder()
                        .postcodePrefix(postcodePrefix)
                        .build();
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodePrefix));
    }


    public static int truncate()
    {
        return Database.truncateTable(GeodataDatabaseModel.tablePostcodePrefixVotes,
                        Database.geodataDatabaseName);
    }
}