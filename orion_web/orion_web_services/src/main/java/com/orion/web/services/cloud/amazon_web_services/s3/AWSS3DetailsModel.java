package com.orion.web.services.cloud.amazon_web_services.s3;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import java.util.List;
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
public class AWSS3DetailsModel implements OrionModel
{
    private int numberOfBuckets;
    private List<AWSS3BucketDetailsModel> buckets;


    public static AWSS3DetailsModel of()
    {
        return AWSS3DetailsModel.builder().build();
    }


    @Override
    public AWSS3DetailsModel clone()
    {
        return (AWSS3DetailsModel)CloningService.clone(this);
    }


    @Override
    public AWSS3DetailsModel getCopy()
    {
        return this.clone();
    }
}