package com.orion.logger;

import com.orion.core.abstraction.OrionService;
import com.orion.logger.data_access.OrionErrorLogsDAO;
import com.orion.logger.data_access.OrionUserAndSystemActionLogsDAO;
import com.orion.logger.data_access.UniqueAPIRequestsDAO;
import com.orion.logger.model.OrionErrorLogModel;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;
import com.orion.logger.model.UniqueAPIRequestModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class LoggingService extends OrionService
{
    public static long getNumberOfActionLogs()
    {

        try
        {
            return OrionUserAndSystemActionLogsDAO.getNumberOfLogs();
        }
        catch(Exception e)
        {
            return -1;
        }

    }


    public static List<OrionUserAndSystemActionLogModel> getActionLogs()
    {

        try
        {
            return OrionUserAndSystemActionLogsDAO.getLogs();
        }
        catch(Exception e)
        {
            return null;
        }

    }


    public static List<OrionUserAndSystemActionLogModel> getActionLogsByOperationID(String operationID)
    {

        try
        {
            return OrionUserAndSystemActionLogsDAO.getLogsByOperationID(operationID);
        }
        catch(Exception e)
        {
            return new ArrayList<OrionUserAndSystemActionLogModel>();
        }

    }


    public static void logAction(String userID, String actionType, String actionDescription, HttpServletRequest request)
    {
        LogBO.builder()
                        .userID(userID)
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .request(request)
                        .build().logActionWithHTTPRequest();
    }


    public static void logAction(String userID, String actionType, String actionDescription)
    {
        LogBO.builder()
                        .userID(userID)
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .build().logActionWithoutHTTPRequest();
    }


    public static void logAction(String actionType, String actionDescription)
    {
        LogBO.builder()
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .build().logActionWithoutUserID();
    }


    public static long getNumberOfErrorLogs()
    {

        try
        {
            return OrionErrorLogsDAO.getNumberOfErrorLogs();
        }
        catch(Exception e)
        {
            return -1;
        }

    }


    public static List<OrionErrorLogModel> getErrorLogs()
    {

        try
        {
            return OrionErrorLogsDAO.getErrorLogs();
        }
        catch(Exception e)
        {
            return new ArrayList<OrionErrorLogModel>();
        }

    }


    public static List<OrionErrorLogModel> getErrorLogsThatHaveNotBeenInvestigated()
    {

        try
        {
            return OrionErrorLogsDAO.getErrorLogsThatHaveNotBeenInvestigated();
        }
        catch(Exception e)
        {
            return new ArrayList<OrionErrorLogModel>();
        }

    }


    public static List<OrionErrorLogModel> getErrorLogsByOperationID(String operationID)
    {

        try
        {
            return OrionErrorLogsDAO.getErrorLogsByOperationID(operationID);
        }
        catch(Exception e)
        {
            return null;
        }

    }


    public static void updateErrorLog(OrionErrorLogModel model)
    {
        OrionErrorLogsDAO.update(model);
    }


    public static void logError(Throwable exception, String IPAddress, String userID, String errorType, String errorMessage, Object... parameters)
    {
        LogBO.builder()
                        .IPAddress(IPAddress)
                        .userID(userID)
                        .errorType(errorType)
                        .errorMessage(errorMessage)
                        .exception(exception)
                        .parameters(parameters)
                        .build()
                        .logErrorWithException();
    }


    public static UniqueAPIRequestModel getUniqueAPIRequestsByID(String requestID)
    {
        return UniqueAPIRequestsDAO.getByID(requestID);
    }


    public static int saveUniqueAPIRequest(UniqueAPIRequestModel model)
    {
        return UniqueAPIRequestsDAO.save(model);
    }


    public static int updateUniqueAPIRequest(UniqueAPIRequestModel model)
    {
        return UniqueAPIRequestsDAO.update(model);
    }


    public static int deleteUniqueAPIRequest(UniqueAPIRequestModel model)
    {
        return UniqueAPIRequestsDAO.delete(model);
    }
}