package com.orion.data.geodata.country.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.geodata.country.model.CountryModel;
import com.orion.data.geodata.model.GeodataDatabaseModel;
import com.orion.data.source.database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesDAO extends OrionDAO
{
    public static List<CountryModel> getCountries()
    {
        List<Object> temp = Database.getAllRows(CountryModel.of(),
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName);
        List<CountryModel> countries = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(country -> countries.add((CountryModel)country));
        }

        return countries;
    }


    public static CountryModel getCountryByCodeAlpha2(String countryCodeAlpha2)
    {
        Assert.notEmpty(countryCodeAlpha2, "The given countryCodeAlpha2 is null/empty.");
        CountryModel model = CountryModel.of(countryCodeAlpha2);
        return (CountryModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha2));
    }


    public static CountryModel getCountryByCodeAlpha3(String countryCodeAlpha3)
    {
        Assert.notEmpty(countryCodeAlpha3, "The given countryCodeAlpha3 is null/empty.");
        CountryModel model = CountryModel.builder()
                        .countryCodeAlpha3(countryCodeAlpha3)
                        .build();
        return (CountryModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha3));
    }


    public static CountryModel getCountryByShortName(String countryShortName)
    {
        Assert.notEmpty(countryShortName, "The given countryShortName is null/empty.");
        CountryModel model = CountryModel.builder()
                        .countryShortName(countryShortName)
                        .build();
        return (CountryModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryShortName));
    }


    public static CountryModel getCountryByLongName(String countryLongName)
    {
        Assert.notEmpty(countryLongName, "The given countryLongName is null/empty.");
        CountryModel model = CountryModel.builder()
                        .countryLongName(countryLongName)
                        .build();
        return (CountryModel)Database.getOneModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryLongName));
    }


    public static int saveCountry(CountryModel model)
    {
        return Database.saveModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName);
    }


    public static int updateCountryByCodeAlpha2(CountryModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha2));
    }


    public static int updateCountryByCodeAlpha3(CountryModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha3));
    }


    public static int updateCountryByShortName(CountryModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryShortName));
    }


    public static int updateCountryByLongName(CountryModel model)
    {
        return Database.updateModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryLongName));
    }


    public static int deleteCountryByCodeAlpha2(String countryCodeAlpha2)
    {
        Assert.notEmpty(countryCodeAlpha2, "The given countryCodeAlpha2 is null/empty.");
        CountryModel model = CountryModel.of(countryCodeAlpha2);
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha2));
    }


    public static int deleteCountryByCodeAlpha3(String countryCodeAlpha3)
    {
        Assert.notEmpty(countryCodeAlpha3, "The given countryCodeAlpha3 is null/empty.");
        CountryModel model = CountryModel.of(countryCodeAlpha3);
        return Database.deleteModel(model,
                        GeodataDatabaseModel.tableCountries,
                        Database.geodataDatabaseName,
                        Arrays.asList(GeodataDatabaseModel.countryCodeAlpha3));
    }
}