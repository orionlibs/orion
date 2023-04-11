package com.orion.user_management.contact_us;

import com.orion.core.abstraction.OrionService;
import com.orion.user_management.contact_us.data_access.ContactUsMessagesDAO;
import com.orion.user_management.contact_us.model.ContactUsMessageModel;

public class UserManagementContactUsService extends OrionService
{
    public static boolean processContactUsForm(UserManagementContactUsRequestBean requestBean)
    {
        return ContactUsFormProcessorBO.of(requestBean).process();
    }


    public static int saveContactUsMessage(ContactUsMessageModel model)
    {
        return ContactUsMessagesDAO.save(model);
    }
}