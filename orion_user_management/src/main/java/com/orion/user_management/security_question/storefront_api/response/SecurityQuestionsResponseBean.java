package com.orion.user_management.security_question.storefront_api.response;

import com.orion.core.abstraction.OrionResponse;
import com.orion.user_management.security_question.model.OrionSecurityQuestionModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class SecurityQuestionsResponseBean extends OrionResponse
{
    private List<OrionSecurityQuestionModel> securityQuestions;


    public static SecurityQuestionsResponseBean of()
    {
        return SecurityQuestionsResponseBean.builder().build();
    }
}