package com.orion.logger.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.exception.ExceptionService;
import com.orion.core.runnable.OrionJob;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.data_access.OrionErrorLogsDAO;
import com.orion.logger.model.OrionErrorLogModel;

public class LogExceptionTask extends Orion implements OrionJob
{
    private SQLTimestamp currentDateTime;
    private String IPAddress;
    private String userID;
    private String errorType;
    private String errorMessage;
    private Throwable exception;
    private Object[] parameters;


    public LogExceptionTask(SQLTimestamp currentDateTime, String IPAddress, String userID, String errorType, String errorMessage, Throwable exception, Object... parameters)
    {
        this.currentDateTime = currentDateTime;
        this.IPAddress = IPAddress;
        this.userID = userID;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.exception = exception;
        this.parameters = parameters;
    }


    public void run()
    {
        boolean logToTomcat = ConfigurationService.getBooleanProp("error.logging.to.tomcat.enable");
        boolean logToDatabase = ConfigurationService.getBooleanProp("error.logging.to.database.enable");

        if(logToTomcat || logToDatabase)
        {
            String errorMessageTemp = "";

            if(parameters != null && parameters.length > 0)
            {
                errorMessageTemp += String.format(errorMessage, parameters);
            }
            else
            {
                errorMessageTemp += errorMessage;
            }

            if(exception != null)
            {
                errorMessageTemp += ExceptionService.getAllErrorMessagesFromTheHierarchy(exception);
            }

            if(logToTomcat)
            {
                logError(errorMessageTemp);
            }

            if(logToDatabase)
            {
                OrionErrorLogModel model = OrionErrorLogModel.builder()
                                .operationID(Thread.currentThread().getName())
                                .userID(userID)
                                .IPAddress(IPAddress)
                                .errorMessage(errorMessageTemp)
                                .errorType(errorType)
                                .logDate(currentDateTime.toLocalDateTime().toLocalDate().toString())
                                .logDateTime(currentDateTime)
                                .comment("")
                                .lastUpdateDateTime(currentDateTime)
                                .isBeingInvestigated(false)
                                .hasBeingInvestigated(false)
                                .isBeingIgnored(false)
                                .build();
                OrionErrorLogsDAO.save(model);
            }

        }

    }
}