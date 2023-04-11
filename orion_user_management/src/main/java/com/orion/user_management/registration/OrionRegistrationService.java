package com.orion.user_management.registration;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.user_management.exception.CouldNotSaveUserAuthorityException;
import com.orion.user_management.exception.CouldNotSaveUserDetailsException;
import com.orion.user_management.exception.CouldNotSaveUserException;
import com.orion.user_management.exception.UserAlreadyExistsException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.registration.tasks.BuildUserDetailsModelForRegistrationTask;
import com.orion.user_management.registration.tasks.CreateAndSaveEmailValidationCodeTask;
import com.orion.user_management.registration.tasks.EmailValidationURLToUserTask;
import com.orion.user_management.registration.tasks.RegisterUserTask;
import com.orion.user_management.registration.tasks.UpdateEmailValidationCodeTask;
import com.orion.user_management.security_question.SecurityQuestionsService;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;
import java.io.IOException;

public class OrionRegistrationService extends OrionService
{
    public static OrionUserModel buildUserModel(String password)
    {
        OrionUserModel user = new OrionUserModel();
        user.setPassword(password);
        return user;
    }


    public static OrionUserDetailsModel buildUserDetailsModel(OrionRegistrationRequestBean registrationRequestBean, String username) throws InvalidDateException
    {
        return BuildUserDetailsModelForRegistrationTask.run(registrationRequestBean, username);
    }


    public static OrionUserSecurityQuestionModel buildUserSecurityQuestionsModel(OrionRegistrationRequestBean registrationRequestBean, String userID)
    {
        return SecurityQuestionsService.saveQuestionsAndAnswersAfterRegistration(registrationRequestBean, userID);
    }


    public static OrionUserDetailsModel registerUser(OrionAuthorityModel authority, OrionUserModel user, OrionUserDetailsModel userDetails, boolean generateUserID, Boolean sendEmailValidationEmailToUser)
                    throws UserAlreadyExistsException, CouldNotSaveUserAuthorityException, CouldNotSaveUserException, CouldNotSaveUserDetailsException, IOException, InvalidDateException, UserHasNoAuthorityException
    {
        return RegisterUserTask.run(authority, user, userDetails, generateUserID, sendEmailValidationEmailToUser);
    }


    public static String createAndSaveEmailValidationCode(String userID)
    {
        return CreateAndSaveEmailValidationCodeTask.run(userID);
    }


    public static String updateEmailValidationCode(String userID)
    {
        return UpdateEmailValidationCodeTask.run(userID);
    }


    public static void emailValidationURLToUser(String userID, String username, String UUIDBase64Encoded, SQLTimestamp registrationDateTime) throws InvalidDateException
    {
        EmailValidationURLToUserTask.run(userID, username, UUIDBase64Encoded, registrationDateTime);
    }
}