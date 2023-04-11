package com.orion.data.user.address.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrionUserAddressModel implements OrionModel
{
    private String addressID;
    private String userID;
    private String houseNumber;
    private String houseName;
    private String houseAddressLine1;
    private String houseAddressLine2;
    private String city;
    private String county;
    private String postcode;
    private String countryCodeAlpha2;
    private String country;
    private Boolean isPrimaryAddress;
    private String proofOfAddressDocumentURL;
    private SQLTimestamp creationDateTime;
    private Boolean isBillingAddress;
    private Boolean hideFromUserProfile;


    public static OrionUserAddressModel of()
    {
        return OrionUserAddressModel.builder().build();
    }


    public static OrionUserAddressModel of(String addressID)
    {
        return OrionUserAddressModel.builder().addressID(addressID).build();
    }


    public static OrionUserAddressModel ofUserID(String userID)
    {
        return OrionUserAddressModel.builder().userID(userID).build();
    }


    @Override
    public OrionUserAddressModel clone()
    {
        return (OrionUserAddressModel)CloningService.clone(this);
    }


    @Override
    public OrionUserAddressModel getCopy()
    {
        return this.clone();
    }
}