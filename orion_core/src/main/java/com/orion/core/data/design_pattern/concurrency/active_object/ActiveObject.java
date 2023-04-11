package com.orion.core.data.design_pattern.concurrency.active_object;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ActiveObject
{
    private static final Logger logger = LoggerFactory.getLogger(ActiveObject.class.getName());
    protected BlockingQueue<Runnable> requests;
    private String nameOfObject;
    //thread of execution
    private Thread thread;
    //status of the thread of execution
    private int status;


    protected ActiveObject(String nameOfObject)
    {
        this.nameOfObject = nameOfObject;
        this.status = 0;
        this.requests = new LinkedBlockingQueue<>();
        thread = new Thread(() ->
        {
            boolean infinite = true;

            while(infinite)
            {

                try
                {
                    requests.take().run();
                }
                catch(InterruptedException e)
                {

                    if(this.status != 0)
                    {
                        logger.error("Thread was interrupted. --> {}", e.getMessage());
                    }

                    infinite = false;
                    Thread.currentThread().interrupt();
                }

            }

        });
        thread.start();
    }


    /**
     * does something
     * @throws InterruptedException due to firing a new Runnable.
     */
    /*public void doSomeWork() throws InterruptedException
    {
        requests.put(() ->
        {
            logger.info("{} is doing some work!", getNameOfObject());
        });
    }*/
    public String getNameOfObject()
    {
        return this.nameOfObject;
    }


    public void killThread(int status)
    {
        this.status = status;
        this.thread.interrupt();
    }


    public int getStatus()
    {
        return this.status;
    }
}
