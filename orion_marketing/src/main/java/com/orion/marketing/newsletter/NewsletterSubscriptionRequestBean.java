package com.orion.marketing.newsletter;

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
public class NewsletterSubscriptionRequestBean implements Cloneable, Serializable, Validator
{
    @NotBlank
    private String emailAddress;


    public static NewsletterSubscriptionRequestBean of()
    {
        return NewsletterSubscriptionRequestBean.builder().build();
    }


    @Override
    public NewsletterSubscriptionRequestBean clone()
    {
        return (NewsletterSubscriptionRequestBean)CloningService.clone(this);
    }


    public NewsletterSubscriptionRequestBean getCopy()
    {
        return this.clone();
    }
}