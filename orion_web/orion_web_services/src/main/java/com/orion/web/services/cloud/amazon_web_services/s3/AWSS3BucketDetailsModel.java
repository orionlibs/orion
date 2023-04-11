package com.orion.web.services.cloud.amazon_web_services.s3;

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
public class AWSS3BucketDetailsModel implements OrionModel
{
    private int numberOfFilesInBucket;
    private String name;
    private DateTime creationDateTime;


    public static AWSS3BucketDetailsModel of()
    {
        return AWSS3BucketDetailsModel.builder().build();
    }


    @Override
    public AWSS3BucketDetailsModel clone()
    {
        return (AWSS3BucketDetailsModel)CloningService.clone(this);
    }


    @Override
    public AWSS3BucketDetailsModel getCopy()
    {
        return this.clone();
    }
}