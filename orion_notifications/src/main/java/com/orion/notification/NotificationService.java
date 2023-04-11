package com.orion.notification;

import com.orion.core.abstraction.OrionService;
import com.orion.notification.data_access.NotificationsDAO;
import com.orion.notification.model.NotificationModel;

public class NotificationService extends OrionService
{
    public static void sendNotification(NotificationModel model)
    {
        NotificationsDAO.save(model);
    }
}