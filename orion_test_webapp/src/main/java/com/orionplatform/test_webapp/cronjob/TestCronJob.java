package com.orionplatform.test_webapp.cronjob;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import com.orionplatform.core.abstraction.Orion;
import com.orionplatform.core.abstraction.OrionCronJob;

//@Component
//@EnableAsync
public class TestCronJob extends Orion implements OrionCronJob
{
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask()
    {
        System.out.println("fixedRate = 1000 - " + System.currentTimeMillis() / 1000);
    }
    
    
    @Async
    @Scheduled(fixedRate = 1500)
    public void scheduleFixedRateTask2()
    {
        System.out.println("fixedRate = 1500 - " + System.currentTimeMillis() / 1000);
    }
}