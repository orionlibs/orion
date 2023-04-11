package com.orion.logger.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
import com.orion.data.source.security.annotations.DecodeBase64ForString;
import com.orion.data.source.security.annotations.EncodeBase64ForString;
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
public class OrionErrorLogModel implements OrionModel
{
    @IgnoreForORM
    private long errorLogID;
    private String operationID;
    private String userID;
    private String IPAddress;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String errorMessage;
    private String errorType;
    private String logDate;
    private SQLTimestamp logDateTime;
    private String comment;
    private SQLTimestamp lastUpdateDateTime;
    private Boolean isBeingInvestigated;
    private Boolean hasBeingInvestigated;
    private Boolean isBeingIgnored;


    public static OrionErrorLogModel of()
    {
        return OrionErrorLogModel.builder().build();
    }


    public static OrionErrorLogModel of(String userID)
    {
        return OrionErrorLogModel.builder().userID(userID).build();
    }


    public String getLogDateTimeAsString()
    {
        return getLogDateTime().printInInternationalFormat();
    }


    @Override
    public OrionErrorLogModel clone()
    {
        return (OrionErrorLogModel)CloningService.clone(this);
    }


    @Override
    public OrionErrorLogModel getCopy()
    {
        return this.clone();
    }
}