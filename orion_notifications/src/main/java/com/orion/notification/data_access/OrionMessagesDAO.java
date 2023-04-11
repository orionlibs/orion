package com.orion.notification.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.notification.model.NotificationsDatabaseModel;
import com.orion.notification.model.OrionMessageModel;
import java.util.Arrays;

public class OrionMessagesDAO extends OrionDAO
{
    public static OrionMessageModel getByID(String messageID)
    {
        Assert.notEmpty(messageID, "The given messageID is null/empty.");
        OrionMessageModel model = OrionMessageModel.of(messageID);
        return (OrionMessageModel)Database.getOneModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }


    public static OrionMessageModel getByDateTime(DateTime datetime)
    {
        /*Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionContactUsMessageModel model = OrionContactUsMessageModel.builder()
                        .userID(userID).build();
        return (OrionContactUsMessageModel)Database.getOneModel(model,
                        OrionDatabaseModel.tableContactUsMessages,
                        Arrays.asList(OrionDatabaseModel.userID));*/
        return null;
    }


    public static int save(OrionMessageModel model)
    {
        Assert.notNull(model, "The given OrionMessageModel is null.");
        return Database.saveModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName);
    }


    public static int update(OrionMessageModel model)
    {
        Assert.notNull(model, "The given OrionMessageModel is null.");
        return Database.updateModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }


    public static int delete(String messageID)
    {
        OrionMessageModel model = OrionMessageModel.of(messageID);
        return Database.deleteModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }
}