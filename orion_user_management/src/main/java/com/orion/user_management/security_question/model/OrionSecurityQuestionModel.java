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
public class OrionSecurityQuestionModel implements OrionModel
{
    private int securityQuestionID;
    private String securityQuestion;


    public static OrionSecurityQuestionModel of()
    {
        return OrionSecurityQuestionModel.builder().build();
    }


    public static OrionSecurityQuestionModel of(int securityQuestionID)
    {
        return OrionSecurityQuestionModel.builder().securityQuestionID(securityQuestionID).build();
    }


    @Override
    public OrionSecurityQuestionModel clone()
    {
        return (OrionSecurityQuestionModel)CloningService.clone(this);
    }


    @Override
    public OrionSecurityQuestionModel getCopy()
    {
        return this.clone();
    }
}