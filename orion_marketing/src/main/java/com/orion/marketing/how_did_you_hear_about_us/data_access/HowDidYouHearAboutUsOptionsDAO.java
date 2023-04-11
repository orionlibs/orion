package com.orion.marketing.how_did_you_hear_about_us.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.marketing.how_did_you_hear_about_us.model.HowDidYouHearAboutUsOptionModel;
import com.orion.marketing.model.MarketingDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowDidYouHearAboutUsOptionsDAO extends OrionDAO
{
    public static List<HowDidYouHearAboutUsOptionModel> getOptions()
    {
        List<HowDidYouHearAboutUsOptionModel> options = new ArrayList<>();
        List<Object> temp = Database.getAllRows(HowDidYouHearAboutUsOptionModel.of(),
                        MarketingDatabaseModel.tableHowDidYouHearAboutUsOptions,
                        Database.marketingDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(option -> options.add((HowDidYouHearAboutUsOptionModel)option));
        }

        return options;
    }


    public static HowDidYouHearAboutUsOptionModel getByID(int howDidYouHearAboutUsOptionID)
    {
        HowDidYouHearAboutUsOptionModel model = HowDidYouHearAboutUsOptionModel.of(howDidYouHearAboutUsOptionID);
        return (HowDidYouHearAboutUsOptionModel)Database.getOneModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUsOptions,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.howDidYouHearAboutUsOptionID));
    }


    public static HowDidYouHearAboutUsOptionModel getByName(String howDidYouHearAboutUsOption)
    {
        Assert.notEmpty(howDidYouHearAboutUsOption, "The given howDidYouHearAboutUsOption is null/empty.");
        HowDidYouHearAboutUsOptionModel model = HowDidYouHearAboutUsOptionModel.builder()
                        .howDidYouHearAboutUsOption(howDidYouHearAboutUsOption)
                        .build();
        return (HowDidYouHearAboutUsOptionModel)Database.getOneModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUsOptions,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.howDidYouHearAboutUsOption));
    }


    public static int save(HowDidYouHearAboutUsOptionModel model)
    {
        return Database.saveModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUsOptions,
                        Database.marketingDatabaseName);
    }


    public static int update(HowDidYouHearAboutUsOptionModel model)
    {
        return Database.updateModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUsOptions,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.howDidYouHearAboutUsOptionID));
    }
}