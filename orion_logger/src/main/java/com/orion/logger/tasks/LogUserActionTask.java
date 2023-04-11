package com.orion.logger.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.runnable.OrionJob;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.logger.data_access.OrionUserAndSystemActionLogsDAO;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;
import javax.servlet.http.HttpServletRequest;

public class LogUserActionTask extends Orion implements OrionJob
{
    private String userID;
    private String actionType;
    private String actionDescription;
    private HttpServletRequest request;
    private SQLTimestamp currentDateTime;


    public LogUserActionTask(String userID, String actionType, String actionDescription, HttpServletRequest request, SQLTimestamp currentDateTime)
    {
        this.userID = userID;
        this.actionType = actionType;
        this.actionDescription = actionDescription;
        this.request = request;
        this.currentDateTime = currentDateTime;
    }


    public void run()
    {
        boolean logToTomcat = ConfigurationService.getBooleanProp("action.logging.to.tomcat.enable");
        boolean logToDatabase = ConfigurationService.getBooleanProp("action.logging.to.database.enable");

        if(logToTomcat || logToDatabase)
        {

            if(logToTomcat)
            {
                log("userID = " + userID + " -- ActionType = " + actionType + " -- " + actionDescription);
            }

            if(logToDatabase)
            {
                OrionUserAndSystemActionLogModel model = OrionUserAndSystemActionLogModel.builder()
                                .operationID(Thread.currentThread().getName())
                                .userID(userID)
                                .actorType("USER")
                                .actionType(actionType)
                                .IPAddress((request != null) ? request.getRemoteAddr() : "")
                                .logDate(currentDateTime.toLocalDateTime().toLocalDate().toString())
                                .logDateTime(currentDateTime)
                                .actionDescription(actionDescription)
                                .build();
                OrionUserAndSystemActionLogsDAO.saveLog(model);
            }

        }

    }
}