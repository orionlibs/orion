package com.orion.user_management.security_question.model;

import com.orion.core.abstraction.OrionModel;
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
public class OrionUserSecurityQuestionModel implements OrionModel
{
    private String userID;
    private int securityQuestionID1;
    private String securityQuestionAnswer1;
    private int securityQuestionID2;
    private String securityQuestionAnswer2;


    public static OrionUserSecurityQuestionModel of()
    {
        return OrionUserSecurityQuestionModel.builder().build();
    }


    public static OrionUserSecurityQuestionModel of(String userID)
    {
        return OrionUserSecurityQuestionModel.builder().userID(userID).build();
    }


    @Override
    public OrionUserSecurityQuestionModel clone()
    {
        return (OrionUserSecurityQuestionModel)CloningService.clone(this);
    }


    @Override
    public OrionUserSecurityQuestionModel getCopy()
    {
        return this.clone();
    }
}