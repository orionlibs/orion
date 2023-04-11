package com.orion.analytics.log.error.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.comparator.SQLTimestampComparator;
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
public class AnalyticsErrorModel implements OrionModel, Comparable<AnalyticsErrorModel>
{
    private Boolean isErrorLog;
    private String operationID;
    private String errorType;
    private String errorMessage;
    private SQLTimestamp logDateTime;
    private String userID;
    private String comment;
    private SQLTimestamp lastUpdateDateTime;
    private Boolean isBeingInvestigated;
    private Boolean hasBeingInvestigated;
    private Boolean isBeingIgnored;
    //action log fields
    private String actorType;
    private String actionType;
    private String IPAddress;
    private String actionDescription;


    public static AnalyticsErrorModel of()
    {
        return AnalyticsErrorModel.builder().build();
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + operationID.hashCode();
        return defaultPrimeNumberForHashing * hash + logDateTime.hashCode();
    }


    @Override
    public boolean equals(Object other)
    {

        if(other instanceof AnalyticsErrorModel)
        {
            AnalyticsErrorModel x = (AnalyticsErrorModel)other;
            return isErrorLog == x.getIsErrorLog()
                            && operationID.equals(x.getOperationID())
                            && errorType.equals(x.getErrorType())
                            && errorMessage.equals(x.getErrorMessage())
                            && logDateTime.equals(x.getLogDateTime())
                            && userID.equals(x.getUserID());
        }
        else
        {
            return false;
        }

    }


    @Override
    public int compareTo(AnalyticsErrorModel other)
    {

        if(other != null)
        {
            return new SQLTimestampComparator().compare(getLogDateTime(), other.getLogDateTime());
        }
        else
        {
            return 1;
        }

    }


    @Override
    public AnalyticsErrorModel clone()
    {
        return (AnalyticsErrorModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsErrorModel getCopy()
    {
        return this.clone();
    }
}