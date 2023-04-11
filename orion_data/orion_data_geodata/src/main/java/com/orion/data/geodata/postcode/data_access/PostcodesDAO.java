package com.orion.data.geodata.postcode.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.geodata.postcode.model.PostcodeModel;
import com.orion.data.source.database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostcodesDAO extends OrionDAO
{
    public static List<PostcodeModel> getPostcodes()
    {
        List<Object> temp = Database.getAllRows(PostcodeModel.of(),
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName);
        List<PostcodeModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(result -> results.add((PostcodeModel)result));
        }

        return results;
    }


    public static PostcodeModel getPostcodeByBoroughName(String boroughName)
    {
        PostcodeModel model = PostcodeModel.of(boroughName);
        return (PostcodeModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.boroughName));
    }


    public static PostcodeModel getPostcodeByPostcode(String postcode)
    {
        PostcodeModel model = PostcodeModel.builder()
                        .postcode(postcode.toUpperCase())
                        .build();
        return (PostcodeModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcode));
    }


    public static PostcodeModel getPostcodeByPostcodeWithoutSpace(String postcodeWithoutSpace)
    {
        PostcodeModel model = PostcodeModel.builder()
                        .postcodeWithoutSpace(postcodeWithoutSpace.toUpperCase())
                        .build();
        return (PostcodeModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static boolean doesPostcodeBelongToPostcodes(String postcode)
    {
        String postcodeInUpperCase = postcode.toUpperCase();
        PostcodeModel model = PostcodeModel.builder()
                        .postcode(postcodeInUpperCase)
                        .postcodeWithoutSpace(postcodeInUpperCase)
                        .build();
        return Database.doesRowExistWithConditionDisjunction(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcode,
                                        GeodataDatabaseModel.postcodeWithoutSpace));
    }


    public static int getBoroughIDForPostcode(String postcode)
    {
        PostcodeModel model = PostcodeModel.builder()
                        .postcode(postcode.toUpperCase())
                        .build();
        PostcodeModel result = (PostcodeModel)Database.getOneModel(model,
                        PostcodeModel.of(),
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.boroughID),
                        Arrays.asList(GeodataDatabaseModel.postcode));
        return (result != null) ? result.getBoroughID() : -1;
    }


    public static int getBoroughIDForPostcodeWithoutSpace(String postcodeWithoutSpace)
    {
        PostcodeModel model = PostcodeModel.builder()
                        .postcodeWithoutSpace(postcodeWithoutSpace.toUpperCase())
                        .build();
        PostcodeModel result = (PostcodeModel)Database.getOneModel(model,
                        PostcodeModel.of(),
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.boroughID),
                        Arrays.asList(GeodataDatabaseModel.postcodeWithoutSpace));
        return (result != null) ? result.getBoroughID() : -1;
    }


    public static int save(PostcodeModel model)
    {
        Assert.notNull(model, "The given SupportedBoroughModel is null.");

        if(model.getPostcode() != null)
        {
            model.setPostcode(model.getPostcode().toUpperCase());
        }

        if(model.getPostcode() != null)
        {
            model.setPostcodeWithoutSpace(model.getPostcodeWithoutSpace().toUpperCase());
        }

        return Database.saveModel(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName);
    }


    public static int update(PostcodeModel model)
    {
        Assert.notNull(model, "The given SupportedBoroughModel is null.");

        if(model.getPostcode() != null)
        {
            model.setPostcode(model.getPostcode().toUpperCase());
        }

        if(model.getPostcode() != null)
        {
            model.setPostcodeWithoutSpace(model.getPostcodeWithoutSpace().toUpperCase());
        }

        return Database.updateModel(model,
                        GeodataDatabaseModel.tablePostcodes,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.postcode));
    }
}