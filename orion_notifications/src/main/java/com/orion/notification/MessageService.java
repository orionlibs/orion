package com.orion.notification;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.notification.data_access.OrionMessagesDAO;
import com.orion.notification.model.OrionMessageModel;

public class MessageService extends OrionService
{
    public static OrionMessageModel getMessageByID(String messageID)
    {
        return OrionMessagesDAO.getByID(messageID);
    }


    public static OrionMessageModel saveMessage(OrionMessageModel model)
    {

        if(model != null)
        {

            if(model.getMessageID() == null || model.getMessageID().isEmpty())
            {
                model.setMessageID(UUIDSecurityService.generateUUIDWithoutHyphens());
            }

            model.setMessageDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
            model.setHasBeenRead(false);
            OrionMessagesDAO.save(model);
        }

        return model;
    }
}