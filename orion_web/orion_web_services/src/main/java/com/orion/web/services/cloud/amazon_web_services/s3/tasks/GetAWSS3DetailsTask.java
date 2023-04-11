package com.orion.web.services.cloud.amazon_web_services.s3.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.time.Time;
import com.orion.web.services.cloud.amazon_web_services.s3.AWSS3BucketDetailsModel;
import com.orion.web.services.cloud.amazon_web_services.s3.AWSS3DetailsModel;
import java.util.ArrayList;
import java.util.List;

public class GetAWSS3DetailsTask extends Orion
{
    public static AWSS3DetailsModel run(ClientConfiguration clientConfiguration)
    {
        Regions clientRegion = Regions.EU_WEST_2;
        AmazonS3 client = AmazonS3ClientBuilder.standard()
                        .withRegion(clientRegion)
                        .withCredentials(new ProfileCredentialsProvider())
                        .withClientConfiguration(clientConfiguration)
                        .build();
        AWSS3DetailsModel allDetailsModel = new AWSS3DetailsModel();
        List<Bucket> buckets = client.listBuckets();
        allDetailsModel.setNumberOfBuckets(buckets.size());
        List<AWSS3BucketDetailsModel> bucketsDetails = new ArrayList<>();

        for(Bucket bucket : buckets)
        {
            ListObjectsV2Result bucketFiles = client.listObjectsV2(bucket.getName());
            java.util.Date bucketCreationDateTime = bucket.getCreationDate();
            Date date = Date.of(bucketCreationDateTime.getYear() + 1900, bucketCreationDateTime.getMonth() + 1, bucketCreationDateTime.getDate());
            Time time = Time.of(bucketCreationDateTime.getHours(), bucketCreationDateTime.getMinutes(), bucketCreationDateTime.getSeconds());
            DateTime bucketCreationDateTimeTemp = DateTime.of(date, time);
            AWSS3BucketDetailsModel model = AWSS3BucketDetailsModel.builder()
                            .name(bucket.getName())
                            .numberOfFilesInBucket(bucketFiles.getKeyCount())
                            .creationDateTime(bucketCreationDateTimeTemp)
                            .build();
            bucketsDetails.add(model);
        }

        allDetailsModel.setBuckets(bucketsDetails);
        client.shutdown();
        return allDetailsModel;
    }
}