package com.orion.user_management.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class UserManagementDatabaseModel
{
    public static final String tableAuthorities = "." + "authorities";
    public static final String authority = "authority";
    public static final String isTestUser = "isTestUser";
    public static final String isDriver = "isDriver";
    public static final String isDeleted = "isDeleted";
    public static final String isDeactivated = "isDeactivated";
    public static final String newUsername = "newUsername";
    public static final String tableUsers = "." + "users";
    public static final String userID = "userID";
    public static final String username = "username";
    public static final String password = "password";
    public static final String mustChangePassword = "mustChangePassword";
    public static final String needsReauthentication = "needsReauthentication";
    public static final String pendingEmailAddressValidation = "pendingEmailAddressValidation";
    public static final String enabled = "enabled";
    public static final String acceptedTermsAndConditionsAndPrivacyNotice = "acceptedTermsAndConditionsAndPrivacyNotice";
    public static final String loggedIn = "loggedIn";
    public static final String lastLogInDateTime = "lastLogInDateTime";
    public static final String registrationDate = "registrationDate";
    public static final String registrationDateTime = "registrationDateTime";
    public static final String lastAccountUpdateDateTime = "lastAccountUpdateDateTime";
    public static final String numberOfAccountLockdowns = "numberOfAccountLockdowns";
    public static final String timezone = "timezone";
    public static final String tableUserDetails = "." + "user_details";
    public static final String firstName = "firstName";
    public static final String middleName = "middleName";
    public static final String lastName = "lastName";
    public static final String emailAddress = "emailAddress";
    public static final String birthdate = "birthdate";
    public static final String mobileNumber = "mobileNumber";
    public static final String nationalityCountryCodeAlpha2 = "nationalityCountryCodeAlpha2";
    public static final String nationality = "nationality";
    public static final String tableUserSettings = "." + "user_settings";
    public static final String avatarURL = "avatarURL";
    public static final String selectedTheme = "selectedTheme";
    public static final String receiveSpecialOffersByEmail = "receiveSpecialOffersByEmail";
    public static final String receiveSpecialOffersBySMS = "receiveSpecialOffersBySMS";
}