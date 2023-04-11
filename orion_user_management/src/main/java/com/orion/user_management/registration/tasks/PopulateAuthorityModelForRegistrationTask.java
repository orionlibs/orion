package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.user_management.model.OrionAuthorityModel;

public class PopulateAuthorityModelForRegistrationTask extends Orion
{
    public static OrionAuthorityModel run(OrionAuthorityModel authority, String username, boolean generateUserID)
    {
        authority.setUsername(username);
        authority.setIsDeleted(Boolean.FALSE);
        authority.setIsDeactivated(Boolean.FALSE);
        authority.setIsTestUser(Boolean.FALSE);
        authority.setIsSendDriverEmails(Boolean.FALSE);

        if(generateUserID)
        {
            authority.setUserID(UUIDSecurityService.generateUUIDWithoutHyphens());
        }

        return authority;
    }
}