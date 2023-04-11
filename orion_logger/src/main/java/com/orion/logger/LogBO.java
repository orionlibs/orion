package com.orion.logger;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.runnable.OrionJobService;
import com.orion.logger.tasks.LogExceptionTask;
import com.orion.logger.tasks.LogUserActionTask;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class LogBO extends Orion
{
    private String userID;
    private String actionType;
    private String actionDescription;
    private HttpServletRequest request;
    private String IPAddress;
    private String errorType;
    private String errorMessage;
    private Throwable exception;
    private Object[] parameters;


    public void logActionWithHTTPRequest()
    {

        try
        {
            SQLTimestamp currentDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            LogUserActionTask logUserActionTask = new LogUserActionTask(userID, actionType, actionDescription, request, currentDateTime);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }

    }


    public void logActionWithoutHTTPRequest()
    {

        try
        {
            SQLTimestamp currentDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            LogUserActionTask logUserActionTask = new LogUserActionTask(userID, actionType, actionDescription, null, currentDateTime);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }

    }


    public void logActionWithoutUserID()
    {

        try
        {
            SQLTimestamp currentDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            LogUserActionTask logUserActionTask = new LogUserActionTask(null, actionType, actionDescription, null, currentDateTime);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }

    }


    public void logErrorWithException()
    {

        try
        {
            SQLTimestamp currentDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            LogExceptionTask logExceptionTask = new LogExceptionTask(currentDateTime, IPAddress, userID, errorType, errorMessage, exception, parameters);
            OrionJobService.runJob(logExceptionTask);
        }
        catch(Exception e)
        {
        }

    }
}