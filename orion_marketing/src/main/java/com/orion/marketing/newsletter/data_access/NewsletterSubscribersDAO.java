package com.orion.marketing.newsletter.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.marketing.model.MarketingDatabaseModel;
import com.orion.marketing.newsletter.model.NewsletterSubscriberModel;
import java.util.Arrays;

public class NewsletterSubscribersDAO extends OrionDAO
{
    public static NewsletterSubscriberModel getByID(long newsletterSubscriberID)
    {
        NewsletterSubscriberModel model = NewsletterSubscriberModel.of(newsletterSubscriberID);
        return (NewsletterSubscriberModel)Database.getOneModel(model,
                        MarketingDatabaseModel.tableNewsletterSubscribers,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.newsletterSubscriberID));
    }


    public static NewsletterSubscriberModel getByEmailAddress(String emailAddress)
    {
        Assert.notEmpty(emailAddress, "The given emailAddress is null/empty.");
        NewsletterSubscriberModel model = NewsletterSubscriberModel.builder()
                        .emailAddress(emailAddress)
                        .build();
        return (NewsletterSubscriberModel)Database.getOneModel(model,
                        MarketingDatabaseModel.tableNewsletterSubscribers,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.emailAddress));
    }


    public static int save(NewsletterSubscriberModel model)
    {
        return Database.saveModel(model,
                        MarketingDatabaseModel.tableNewsletterSubscribers,
                        Database.marketingDatabaseName);
    }


    public static int update(NewsletterSubscriberModel model)
    {
        return Database.updateModel(model,
                        MarketingDatabaseModel.tableNewsletterSubscribers,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.newsletterSubscriberID));
    }


    public static int delete(String emailAddress)
    {
        Assert.notEmpty(emailAddress, "The given emailAddress is null/empty.");
        NewsletterSubscriberModel model = NewsletterSubscriberModel.builder()
                        .emailAddress(emailAddress)
                        .build();
        return Database.deleteModel(model,
                        MarketingDatabaseModel.tableNewsletterSubscribers,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.emailAddress));
    }
}