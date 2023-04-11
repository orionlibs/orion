package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.core.exception.Assert;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.data_access.OrionAuthoritiesDAO;
import com.orion.user_management.data_access.OrionUserSettingsDAO;
import com.orion.user_management.data_access.OrionUsersDAO;
import com.orion.user_management.exception.CouldNotSaveUserAuthorityException;
import com.orion.user_management.exception.CouldNotSaveUserDetailsException;
import com.orion.user_management.exception.CouldNotSaveUserException;
import com.orion.user_management.exception.UserAlreadyExistsException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.model.OrionUserSettingsModel;

public class RegisterUserTask extends Orion
{
    public static OrionUserDetailsModel run(OrionAuthorityModel authority, OrionUserModel user, OrionUserDetailsModel userDetails, boolean generateUserID, Boolean sendEmailValidationEmailToUser)
                    throws UserAlreadyExistsException, CouldNotSaveUserAuthorityException, CouldNotSaveUserException, CouldNotSaveUserDetailsException, InvalidDateException, UserHasNoAuthorityException
    {
        Assert.notNull(authority, "The authority input cannot be null.");
        Assert.notNull(user, "The user input cannot be null.");
        Assert.notNull(userDetails, "The userDetails input cannot be null.");
        String username = authority.getUsername();
        username = EmailAddressService.normaliseEmailAddress(username);
        OrionAuthorityModel existingAuthority = UserAccountService.getAuthorityByUsername(username);

        if(existingAuthority != null)
        {
            throw new UserAlreadyExistsException("User with username '{}' already exists.", username);
        }
        else
        {
            OrionAuthorityModel secureAuthority = PopulateAuthorityModelForRegistrationTask.run(authority, username, generateUserID);
            int numberOfRowsAffected = UserAccountService.saveAuthority(secureAuthority);

            if(numberOfRowsAffected > 0)
            {
                OrionUserModel secureUser = user.getCopy();
                secureUser.setPassword(BCryptEncryptionService.encrypt(secureUser.getPassword()));
                secureUser.setUserID(secureAuthority.getUserID());
                PopulateUserModelForRegistrationTask.run(secureUser);
                numberOfRowsAffected = UserAccountService.saveUser(secureUser);

                if(numberOfRowsAffected > 0)
                {
                    userDetails.setUserID(secureAuthority.getUserID());
                    numberOfRowsAffected = UserAccountService.saveUserDetails(userDetails);

                    if(numberOfRowsAffected > 0)
                    {
                        OrionUserSettingsModel userSettings = new OrionUserSettingsModel();
                        userSettings.setUserID(secureAuthority.getUserID());
                        userSettings.setAvatarURL(ConfigurationService.getProp("user.management.default.setting.avatar.url"));
                        userSettings.setSelectedTheme(ConfigurationService.getProp("user.management.default.setting.theme"));
                        userSettings.setReceiveSpecialOffersByEmail(ConfigurationService.getBooleanProp("user.management.default.setting.receive.special.offers.by.email"));
                        userSettings.setReceiveSpecialOffersBySMS(ConfigurationService.getBooleanProp("user.management.default.setting.receive.special.offers.by.sms"));
                        numberOfRowsAffected = OrionUserSettingsDAO.save(userSettings);

                        if(numberOfRowsAffected > 0)
                        {
                            processEmailValidation(sendEmailValidationEmailToUser, secureAuthority.getUserID(), username, secureUser);
                        }

                        return userDetails;
                    }
                    else
                    {
                        OrionAuthoritiesDAO.delete(secureAuthority.getUserID());
                        OrionUsersDAO.delete(secureAuthority.getUserID());
                        throw new CouldNotSaveUserDetailsException("Could not save user details for username '{}'" + username);
                    }

                }
                else
                {
                    OrionAuthoritiesDAO.delete(secureAuthority.getUserID());
                    throw new CouldNotSaveUserException("Could not save user for username '{}'" + username);
                }

            }
            else
            {
                throw new CouldNotSaveUserAuthorityException("Could not save user authority with userID '{}'" + secureAuthority.getUserID());
            }

        }

    }


    private static void processEmailValidation(Boolean sendEmailValidationEmailToUser, String userID, String username, OrionUserModel secureUser) throws InvalidDateException
    {
        boolean sendEmailValidation = sendEmailValidationEmailToUser != null && sendEmailValidationEmailToUser;

        if(sendEmailValidation)
        {
            String UUIDBase64Encoded = CreateAndSaveEmailValidationCodeTask.run(userID);
            EmailValidationURLToUserTask.run(userID, username, UUIDBase64Encoded);
            secureUser.setPendingEmailAddressValidation(true);
            UserAccountService.updateUserByUserID(secureUser);
        }
        else
        {
            UserAccountService.enableAccountByUserID(userID);
        }

    }
}