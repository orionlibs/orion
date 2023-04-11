package com.orion.data.user.address.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.content.Pagination;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.user.address.model.AddressDatabaseModel;
import com.orion.data.user.address.model.OrionUserAddressModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionUserAddressesDAO extends OrionDAO
{
    public static long getNumberOfUserAddressesbyUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        return Database.getNumberOfRecords(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.hideFromUserProfile));
    }


    public static long getNumberOfPrimaryUserAddressesbyUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .isPrimaryAddress(Boolean.TRUE)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        return Database.getNumberOfRecords(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.isPrimaryAddress,
                                        AddressDatabaseModel.hideFromUserProfile));
    }


    public static long getNumberOfBillingUserAddressesbyUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .isBillingAddress(Boolean.TRUE)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        return Database.getNumberOfRecords(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.isBillingAddress,
                                        AddressDatabaseModel.hideFromUserProfile));
    }


    public static List<OrionUserAddressModel> getUserAddressesByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        List<Object> temp = Database.getModels(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.hideFromUserProfile));
        List<OrionUserAddressModel> addresses = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(address -> addresses.add((OrionUserAddressModel)address));
        }

        return addresses;
    }


    public static List<OrionUserAddressModel> getAll()
    {
        List<Object> temp = Database.getAllRows(OrionUserAddressModel.of(),
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName);
        List<OrionUserAddressModel> addresses = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(address -> addresses.add((OrionUserAddressModel)address));
        }

        return addresses;
    }


    public static OrionUserAddressModel getOldestAddressByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        List<Object> temp = Database.getModelsWithAscendingOrder(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.hideFromUserProfile),
                        AddressDatabaseModel.creationDateTime,
                        Pagination.ofLimit1());

        if(temp != null && !temp.isEmpty())
        {
            return (OrionUserAddressModel)temp.get(0);
        }

        return null;
    }


    public static OrionUserAddressModel getPrimaryUserAddressByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .isPrimaryAddress(Boolean.TRUE)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        List<Object> temp = Database.getModelsWithDescendingOrder(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.isPrimaryAddress,
                                        AddressDatabaseModel.hideFromUserProfile),
                        AddressDatabaseModel.creationDateTime,
                        Pagination.ofLimit1());

        if(temp != null && !temp.isEmpty())
        {
            return (OrionUserAddressModel)temp.get(0);
        }

        return null;
    }


    public static OrionUserAddressModel getNewestUserAddressByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        List<Object> temp = Database.getModelsWithDescendingOrder(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.hideFromUserProfile),
                        AddressDatabaseModel.creationDateTime,
                        Pagination.ofLimit1());

        if(temp != null && !temp.isEmpty())
        {
            return (OrionUserAddressModel)temp.get(0);
        }

        return null;
    }


    public static OrionUserAddressModel getByAddressID(String addressID)
    {
        OrionUserAddressModel model = OrionUserAddressModel.of(addressID);
        return (OrionUserAddressModel)Database.getOneModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.addressID));
    }


    public static OrionUserAddressModel getBillingAddressByUserID(String userID)
    {
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .isBillingAddress(Boolean.TRUE)
                        .hideFromUserProfile(Boolean.FALSE)
                        .build();
        return (OrionUserAddressModel)Database.getOneModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID,
                                        AddressDatabaseModel.isBillingAddress,
                                        AddressDatabaseModel.hideFromUserProfile));
    }


    public static int save(OrionUserAddressModel model)
    {
        return Database.saveModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserAddressModel model)
    {
        return Database.updateModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.addressID));
    }


    public static int deleteByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserAddressModel model = OrionUserAddressModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.userID));
    }


    public static int deleteByAddressID(String addressID)
    {
        OrionUserAddressModel model = OrionUserAddressModel.of(addressID);
        return Database.deleteModel(model,
                        AddressDatabaseModel.tableUserAddresses,
                        Database.usersDatabaseName,
                        Arrays.asList(AddressDatabaseModel.addressID));
    }
}