package com.orion.data.user.address.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class AddressDatabaseModel
{
    public static final String tableUserAddresses = "." + "user_addresses";
    public static final String addressID = "addressID";
    public static final String userID = "userID";
    public static final String houseNumber = "houseNumber";
    public static final String houseName = "houseName";
    public static final String houseAddressLine1 = "houseAddressLine1";
    public static final String houseAddressLine2 = "houseAddressLine2";
    public static final String city = "city";
    public static final String county = "county";
    public static final String postcode = "postcode";
    public static final String countryCodeAlpha2 = "countryCodeAlpha2";
    public static final String country = "country";
    public static final String isPrimaryAddress = "isPrimaryAddress";
    public static final String proofOfAddressDocumentURL = "proofOfAddressDocumentURL";
    public static final String creationDateTime = "creationDateTime";
    public static final String isBillingAddress = "isBillingAddress";
    public static final String hideFromUserProfile = "hideFromUserProfile";
}