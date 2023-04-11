package com.orion.user_management.forgot_password;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.configuration.ConfigurationPropertyMissingException;
import com.orion.core.content.MIMEType;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.document.velocity.VelocityTemplateService;
import com.orion.core.exception.Assert;
import com.orion.core.exception.ResourceException;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.email_validation.OrionEmailValidationService;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.forgot_password.data_access.OrionForgotPasswordCodesDAO;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class ForgotPasswordBO extends Orion
{
    private String username;
    private String userID;
    private OrionForgotPasswordRequestBean forgotPasswordRequestBean;


    public static ForgotPasswordBO of(String username, String userID)
    {
        return ForgotPasswordBO.builder().username(username).userID(userID).build();
    }


    public static ForgotPasswordBO ofRequest(OrionForgotPasswordRequestBean forgotPasswordRequestBean)
    {
        return ForgotPasswordBO.builder().forgotPasswordRequestBean(forgotPasswordRequestBean).build();
    }


    public ForgotPasswordResponseBean generateForgotPasswordEmailHTML() throws ResourceException
    {
        Assert.notEmpty(username, "The username input cannot be null/empty.");
        OrionForgotPasswordCodesModel forgotPasswordCodesModel = OrionForgotPasswordCodesDAO.getForgotPasswordCodeByUserID(userID);
        String UUIDBase64Encoded = generateUUIDWithoutHyphensForURLEncoded();

        if(forgotPasswordCodesModel != null)
        {
            UUIDBase64Encoded = forgotPasswordCodesModel.getForgotPasswordCode();
            updateForgotPasswordCodeModel(forgotPasswordCodesModel);
            OrionForgotPasswordCodesDAO.update(forgotPasswordCodesModel);
        }
        else
        {
            forgotPasswordCodesModel = buildForgotPasswordCodeModel(UUIDBase64Encoded);
            OrionForgotPasswordCodesDAO.save(forgotPasswordCodesModel);
        }

        String messageID = UUIDSecurityService.generateUUIDWithoutHyphens();
        Map<String, String> templateParameters = new HashMap<>();
        templateParameters.put("emailID", messageID);
        templateParameters.put("emailValidationCode", UUIDBase64Encoded);
        templateParameters.put("currentYear", Integer.toString(CalendarService.getCurrentYear()));
        String resetPasswordEmailHTMLTemplate = ConfigurationService.getProp("user.management.reset.password.email.velocity.template");
        String decodedResetPasswordEmailHTMLTemplate = Base64EncodingService.decodeBase64ForString(resetPasswordEmailHTMLTemplate);
        String resetPasswordEmailHTML = VelocityTemplateService.getVelocityTemplateAsString(templateParameters, "ResetPasswordEmailTemplate", decodedResetPasswordEmailHTMLTemplate);
        //deleteForgotPasswordCodeForUserToCreateNewOne(userID);
        //boolean rowsAffected = UserAccountService.disableUserAccountByUserID(userID);

        if(forgotPasswordCodesModel != null)
        {
            updateForgotPasswordCodeModel(forgotPasswordCodesModel);
            OrionForgotPasswordCodesDAO.update(forgotPasswordCodesModel);
        }
        else
        {
            forgotPasswordCodesModel = buildForgotPasswordCodeModel(UUIDBase64Encoded);
            OrionForgotPasswordCodesDAO.save(forgotPasswordCodesModel);
        }

        ForgotPasswordResponseBean forgotPasswordResponseBean;

        try
        {
            forgotPasswordResponseBean = buildForgotPasswordResponseBean(resetPasswordEmailHTML);
            EmailData emailData = EmailData.builder()
                            .emailMessage(forgotPasswordResponseBean.getResetPasswordEmailHTML())
                            .emailRecipient(forgotPasswordResponseBean.getEmailAddress())
                            .emailSender(forgotPasswordResponseBean.getSender())
                            .emailSenderName(forgotPasswordResponseBean.getSenderName())
                            .emailSubject(forgotPasswordResponseBean.getSubject())
                            .messageMIMEType(MIMEType.HTML_UTF8)
                            .build();
            OrionMessageModel messageModel = OrionMessageModel.builder()
                            .messageID(messageID)
                            .emailAddress(forgotPasswordResponseBean.getEmailAddress())
                            .message(emailData.getEmailMessage())
                            .messageDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                            .build();
            messageModel = MessageService.saveMessage(messageModel);

            try
            {
                EmailService.sendEmail(emailData);
            }
            catch(Exception e)
            {
                logError(ForgotPasswordErrors.ErrorWithSendingForgotPasswordEmailToUser, e);
            }

            ForgotPasswordResponseBean forgotPasswordResponseBean1 = new ForgotPasswordResponseBean();
            forgotPasswordResponseBean1.setIsPasswordChangeRequestSuccessful(forgotPasswordResponseBean.getIsPasswordChangeRequestSuccessful());
            return forgotPasswordResponseBean1;
        }
        catch(ConfigurationPropertyMissingException e)
        {
            ForgotPasswordResponseBean forgotPasswordResponseBean1 = new ForgotPasswordResponseBean();
            forgotPasswordResponseBean1.setIsPasswordChangeRequestSuccessful(Boolean.FALSE);
            return forgotPasswordResponseBean1;
        }

    }


    public ForgotPasswordResponseBean processForgotPasswordRequest() throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUsername(forgotPasswordRequestBean.getUsername().trim());

        if(authority != null)
        {

            if(!OrionEmailValidationService.pendingEmailValidationByUserID(authority.getUserID()))
            {

                try
                {
                    this.username = forgotPasswordRequestBean.getUsername();
                    this.userID = authority.getUserID();
                    return generateForgotPasswordEmailHTML();
                }
                catch(ResourceException e)
                {
                    ForgotPasswordResponseBean forgotPasswordResponseBean1 = new ForgotPasswordResponseBean();
                    forgotPasswordResponseBean1.setIsPasswordChangeRequestSuccessful(Boolean.FALSE);
                    return forgotPasswordResponseBean1;
                }

            }
            else
            {
                return ForgotPasswordResponseBean.builder()
                                .isPasswordChangeRequestSuccessful(false)
                                .accountPendingValidation(true)
                                .build();
            }

        }
        else
        {
            return ForgotPasswordResponseBean.builder()
                            .userExists(false)
                            .isPasswordChangeRequestSuccessful(false)
                            .build();
        }

    }


    private ForgotPasswordResponseBean buildForgotPasswordResponseBean(String resetPasswordEmailHTML) throws ConfigurationPropertyMissingException
    {
        ForgotPasswordResponseBean forgotPasswordResponseBean = new ForgotPasswordResponseBean();
        forgotPasswordResponseBean.setEmailAddress(username);

        try
        {
            String subject = ConfigurationService.getPropOrThrowException("user.management.reset.password.email.subject");
            String sender = ConfigurationService.getPropOrThrowException("email.administrator.email.address");
            String senderName = ConfigurationService.getPropOrThrowException("user.management.reset.password.email.sender.name");
            forgotPasswordResponseBean.setSubject(subject);
            forgotPasswordResponseBean.setSender(sender);
            forgotPasswordResponseBean.setSenderName(senderName);
        }
        catch(ConfigurationPropertyMissingException e)
        {
            throw e;
        }

        forgotPasswordResponseBean.setResetPasswordEmailHTML(resetPasswordEmailHTML);
        forgotPasswordResponseBean.setIsPasswordChangeRequestSuccessful(true);
        return forgotPasswordResponseBean;
    }


    private String generateUUIDWithoutHyphensForURLEncoded()
    {
        String UUID1 = UUIDSecurityService.generateUUIDWithoutHyphens();
        String UUID2 = UUIDSecurityService.generateUUIDWithoutHyphens();
        String UUID3 = UUIDSecurityService.generateUUIDWithoutHyphens();
        return Base64EncodingService.encodeBase64ForURL(UUID1 + UUID2 + UUID3);
    }


    private void updateForgotPasswordCodeModel(OrionForgotPasswordCodesModel model)
    {
        int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.forgot.password.code.expiration.in.minutes", 20);
        model.setExpirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes));
    }


    private OrionForgotPasswordCodesModel buildForgotPasswordCodeModel(String UUIDBase64Encoded)
    {
        int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.forgot.password.code.expiration.in.minutes", 20);
        OrionForgotPasswordCodesModel forgotPasswordCodesModel = OrionForgotPasswordCodesModel.builder()
                        .userID(userID)
                        .forgotPasswordCode(UUIDBase64Encoded)
                        .expirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes))
                        .build();
        return forgotPasswordCodesModel;
    }
}