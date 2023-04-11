package com.orion.user_management.contact_us.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.contact_us.model.ContactUsDatabaseModel;
import com.orion.user_management.contact_us.model.ContactUsMessageModel;
import java.util.Arrays;

public class ContactUsMessagesDAO extends OrionDAO
{
    public static ContactUsMessageModel getByID(long contactUsMessageID)
    {
        ContactUsMessageModel model = ContactUsMessageModel.of(contactUsMessageID);
        return (ContactUsMessageModel)Database.getOneModel(model,
                        ContactUsDatabaseModel.tableContactUsMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(ContactUsDatabaseModel.contactUsMessageID));
    }


    public static ContactUsMessageModel getByMessageID(String messageID)
    {
        ContactUsMessageModel model = ContactUsMessageModel.builder()
                        .messageID(messageID)
                        .build();
        return (ContactUsMessageModel)Database.getOneModel(model,
                        ContactUsDatabaseModel.tableContactUsMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(ContactUsDatabaseModel.messageID));
    }


    public static int save(ContactUsMessageModel model)
    {
        Assert.notNull(model, "The given OrionContactUsMessageModel is null.");
        return Database.saveModel(model,
                        ContactUsDatabaseModel.tableContactUsMessages,
                        Database.messagesDatabaseName);
    }


    public static int update(ContactUsMessageModel model)
    {
        Assert.notNull(model, "The given OrionContactUsMessageModel is null.");
        return Database.updateModel(model,
                        ContactUsDatabaseModel.tableContactUsMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(ContactUsDatabaseModel.contactUsMessageID));
    }


    public static int delete(long contactUsMessageID)
    {
        ContactUsMessageModel model = ContactUsMessageModel.of(contactUsMessageID);
        return Database.deleteModel(model,
                        ContactUsDatabaseModel.tableContactUsMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(ContactUsDatabaseModel.contactUsMessageID));
    }
}