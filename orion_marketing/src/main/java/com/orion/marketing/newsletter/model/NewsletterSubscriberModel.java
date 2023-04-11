package com.orion.marketing.newsletter.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.security.annotations.DecryptAsUsername;
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
public class NewsletterSubscriberModel implements OrionModel
{
    private long newsletterSubscriberID;
    @EncryptAsUsername
    @DecryptAsUsername
    private String emailAddress;


    public static NewsletterSubscriberModel of()
    {
        return NewsletterSubscriberModel.builder().build();
    }


    public static NewsletterSubscriberModel of(long newsletterSubscriberID)
    {
        return NewsletterSubscriberModel.builder().newsletterSubscriberID(newsletterSubscriberID).build();
    }


    @Override
    public NewsletterSubscriberModel clone()
    {
        return (NewsletterSubscriberModel)CloningService.clone(this);
    }


    @Override
    public NewsletterSubscriberModel getCopy()
    {
        return this.clone();
    }
}