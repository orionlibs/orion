package com.orion.user_management.registration;

import com.orion.core.data.validation.Validator;
import com.orion.core.data.validation.annotation.NotBlank;
import com.orion.core.object.CloningService;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// This class does not extend OrionRequest, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionRegistrationRequestBean implements Cloneable, Serializable, Validator
{
    private String firstName;
    private String lastName;
    private String fullName;
    private String mobileNumber;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String birthdate;
    private int securityQuestionID1;
    private int securityQuestionID2;
    private String securityQuestionAnswer1;
    private String securityQuestionAnswer2;


    public static OrionRegistrationRequestBean of()
    {
        return OrionRegistrationRequestBean.builder().build();
    }


    @Override
    public OrionRegistrationRequestBean clone()
    {
        return (OrionRegistrationRequestBean)CloningService.clone(this);
    }


    public OrionRegistrationRequestBean getCopy()
    {
        return this.clone();
    }
}