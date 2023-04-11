package com.orion.data.geodata.postcode.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.geodata.postcode.model.PostcodeVoteModel;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostcodeVotesDAO extends OrionDAO
{
    public static boolean doesRowExistByPostcodeWithoutSpace(PostcodeVoteModel model)
    {
        Assert.notNull(model, "The given PostcodeVoteModel is null/empty.");
        return Database.doesRowExistWithConditionConjunction(model,
                        GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static List<PostcodeVoteModel> getPostcodeVotes()
    {
        List<Object> temp = Database.getAllRows(PostcodeVoteModel.of(),
                        GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName);
        List<PostcodeVoteModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((PostcodeVoteModel)result));
        }

        return results;
    }


    public static int incrementVoteByPostcodeWithoutSpace(PostcodeVoteModel model)
    {
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.updateTable(Database.geodataDatabaseName + GeodataDatabaseModel.tablePostcodeVotes);
        mySQLQuery.set();
        mySQLQuery.columnWithExpression(GeodataDatabaseModel.numberOfVotes,
                        "=" + GeodataDatabaseModel.numberOfVotes + "+1");
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
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


    public static int savePostcodeVote(PostcodeVoteModel model)
    {
        Assert.notNull(model, "The given PostcodeVoteModel is null.");
        return Database.saveModel(model,
                        GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName);
    }


    public static int updatePostcodeVote(PostcodeVoteModel model)
    {
        Assert.notNull(model, "The given PostcodeVoteModel is null.");
        return Database.updateModel(model,
                        GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static int deleteByPostcodeWithoutSpace(String postcodeWithoutSpace)
    {
        Assert.notEmpty(postcodeWithoutSpace, "The given postcodeWithoutSpace is null/empty.");
        PostcodeVoteModel model = PostcodeVoteModel.builder()
                        .postcodeWithoutSpace(postcodeWithoutSpace)
                        .build();
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static int truncate()
    {
        return Database.truncateTable(GeodataDatabaseModel.tablePostcodeVotes,
                        Database.geodataDatabaseName);
    }
}