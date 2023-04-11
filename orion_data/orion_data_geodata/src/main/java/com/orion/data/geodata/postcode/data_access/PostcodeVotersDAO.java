package com.orion.data.geodata.postcode.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.geodata.postcode.model.PostcodeVoterModel;
import com.orion.data.source.database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostcodeVotersDAO extends OrionDAO
{
    public static boolean doesRowExistByEmailAddressAndPostcodeWithoutSpace(PostcodeVoterModel model)
    {
        Assert.notNull(model, "The given PostcodeVoterModel is null/empty.");
        return Database.doesRowExistWithConditionConjunction(model,
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.emailAddress,
                                        GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static boolean doesRowNotExistByEmailAddressAndPostcodeWithoutSpace(PostcodeVoterModel model)
    {
        return !doesRowExistByEmailAddressAndPostcodeWithoutSpace(model);
    }


    public static List<PostcodeVoterModel> getPostcodeVoters()
    {
        List<Object> temp = Database.getAllRows(PostcodeVoterModel.of(),
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName);
        List<PostcodeVoterModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((PostcodeVoterModel)result));
        }

        return results;
    }


    public static List<String> getDistinctEmailAddressesOfVoters()
    {
        List<Object> temp = Database.getAllRows(PostcodeVoterModel.of(),
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.emailAddress));
        Set<String> results = new HashSet<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add(((PostcodeVoterModel)result).getEmailAddress()));
        }

        return new ArrayList<String>(results);
    }


    public static int save(PostcodeVoterModel model)
    {
        Assert.notNull(model, "The given PostcodeVoterModel is null.");
        return Database.saveModel(model,
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName);
    }


    public static int update(PostcodeVoterModel model)
    {
        Assert.notNull(model, "The given PostcodeVoterModel is null.");
        return Database.updateModel(model,
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeVoterID));
    }


    public static int delete(long postcodeVoterID)
    {
        PostcodeVoterModel model = PostcodeVoterModel.builder()
                        .postcodeVoterID(postcodeVoterID)
                        .build();
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeVoterID));
    }


    public static int truncate()
    {
        return Database.truncateTable(GeodataDatabaseModel.tablePostcodeVoters,
                        Database.geodataDatabaseName);
    }
}