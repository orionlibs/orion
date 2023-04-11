package com.orion.user_management.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
import com.orion.data.source.security.annotations.DecryptAsData;
import com.orion.data.source.security.annotations.DecryptAsUsername;
import com.orion.data.source.security.annotations.EncryptAsData;
import com.orion.data.source.security.annotations.EncryptAsUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrionUserDetailsModel implements OrionModel
{
    private String userID;
    @EncryptAsData
    @DecryptAsData
    private String firstName;
    @EncryptAsData
    @DecryptAsData
    private String middleName;
    @EncryptAsData
    @DecryptAsData
    private String lastName;
    @EncryptAsUsername
    @DecryptAsUsername
    private String emailAddress;
    private SQLTimestamp birthdate;
    @EncryptAsData
    @DecryptAsData
    private String mobileNumber;
    private String nationalityCountryCodeAlpha2;
    private String nationality;
    @IgnoreForORM
    private Boolean loggedIn;
    @IgnoreForORM
    private Boolean enabled;


    public static OrionUserDetailsModel of()
    {
        return OrionUserDetailsModel.builder().build();
    }


    public static OrionUserDetailsModel of(String userID)
    {
        return OrionUserDetailsModel.builder().userID(userID).build();
    }


    public String getFullName()
    {
        String fullName = "";
        boolean firstNameExists = getFirstName() != null && !getFirstName().isEmpty();
        boolean middleNameExists = getMiddleName() != null && !getMiddleName().isEmpty();
        boolean lastNameExists = getLastName() != null && !getLastName().isEmpty();

        if(firstNameExists && middleNameExists && lastNameExists)
        {
            fullName = getFirstName() + " " + getMiddleName() + " " + getLastName();
        }
        else if(!firstNameExists && middleNameExists && lastNameExists)
        {
            fullName = getMiddleName() + " " + getLastName();
        }
        else if(firstNameExists && !middleNameExists && lastNameExists)
        {
            fullName = getFirstName() + " " + getLastName();
        }
        else if(firstNameExists && middleNameExists && !lastNameExists)
        {
            fullName = getFirstName() + " " + getMiddleName();
        }
        else if(!firstNameExists && !middleNameExists && lastNameExists)
        {
            fullName = getLastName();
        }
        else if(!firstNameExists && middleNameExists && !lastNameExists)
        {
            fullName = getMiddleName();
        }
        else if(firstNameExists && !middleNameExists && !lastNameExists)
        {
            fullName = getFirstName();
        }

        return fullName;
    }


    public void setFullName(String fullName)
    {
        throw new UnsupportedOperationException("Please use OrionUserDetailsModel.getFullName().");
    }


    @Override
    public OrionUserDetailsModel clone()
    {
        return (OrionUserDetailsModel)CloningService.clone(this);
    }


    public OrionUserDetailsModel getCopy()
    {
        return this.clone();
    }
}