package com.orion.data.geodata.continent.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.continent.model.ContinentModel;
import com.orion.data.geodata.country.model.CountryModel;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.source.database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinentsDAO extends OrionDAO
{
    public static List<ContinentModel> getContinents()
    {
        List<Object> temp = Database.getAllRows(ContinentModel.of(),
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName);
        List<ContinentModel> countries = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(country -> countries.add((ContinentModel)country));
        }

        return countries;
    }


    public static ContinentModel getContinentByCode(String continentCode)
    {
        Assert.notEmpty(continentCode, "The given continentCode is null/empty.");
        CountryModel model = CountryModel.of(continentCode);
        return (ContinentModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentCode));
    }


    public static ContinentModel getContinentByName(String continentName)
    {
        Assert.notEmpty(continentName, "The given continentName is null/empty.");
        ContinentModel model = ContinentModel.builder()
                        .continentName(continentName)
                        .build();
        return (ContinentModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentName));
    }


    public static int saveContinent(ContinentModel model)
    {
        return Database.saveModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName);
    }


    public static int updateContinentByCode(ContinentModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentCode));
    }


    public static int updateContinentByName(ContinentModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentName));
    }


    public static int deleteContinentByCode(String continentCode)
    {
        Assert.notEmpty(continentCode, "The given continentCode is null/empty.");
        CountryModel model = CountryModel.of(continentCode);
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentCode));
    }


    public static int deleteContinentByName(String continentName)
    {
        Assert.notEmpty(continentName, "The given continentName is null/empty.");
        ContinentModel model = ContinentModel.builder()
                        .continentName(continentName)
                        .build();
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tableContinents,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.continentName));
    }
}