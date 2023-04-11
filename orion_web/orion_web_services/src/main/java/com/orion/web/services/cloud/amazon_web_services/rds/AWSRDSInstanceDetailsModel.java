package com.orion.web.services.cloud.amazon_web_services.rds;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.datetime.DateTime;
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
public class AWSRDSInstanceDetailsModel implements OrionModel
{
    private int storageCapacityInGigaBytes;
    private String availabilityZone;
    private String DBInstanceServerType;
    private String DBInstanceID;
    private String DBInstanceStatus;
    private String connectionURL;
    private String databaseEngineName;
    private String databaseEngineVersion;
    private DateTime databaseCreationDateTime;


    public static AWSRDSInstanceDetailsModel of()
    {
        return AWSRDSInstanceDetailsModel.builder().build();
    }


    @Override
    public AWSRDSInstanceDetailsModel clone()
    {
        return (AWSRDSInstanceDetailsModel)CloningService.clone(this);
    }


    @Override
    public AWSRDSInstanceDetailsModel getCopy()
    {
        return this.clone();
    }
}