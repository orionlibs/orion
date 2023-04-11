package com.orion.marketing.newsletter;

import com.orion.core.abstraction.OrionService;
import com.orion.marketing.newsletter.data_access.NewsletterSubscribersDAO;
import com.orion.marketing.newsletter.model.NewsletterSubscriberModel;

public class NewsletterService extends OrionService
{
    public static void subscribe(String emailAddress)
    {

        if(NewsletterSubscribersDAO.getByEmailAddress(emailAddress) == null)
        {
            NewsletterSubscribersDAO.save(NewsletterSubscriberModel.builder()
                            .emailAddress(emailAddress)
                            .build());
        }

    }


    public static void unsubscribe(String emailAddress)
    {
        NewsletterSubscribersDAO.delete(emailAddress);
    }


    public static boolean isSubscribed(String emailAddress)
    {
        return NewsletterSubscribersDAO.getByEmailAddress(emailAddress) != null;
    }
}