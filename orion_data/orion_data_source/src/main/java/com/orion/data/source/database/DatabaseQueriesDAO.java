package com.orion.data.source.database;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.security.DataSecurityService;
import com.orion.data.source.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseQueriesDAO extends Orion
{
    @SuppressWarnings("unchecked")
    public List<Object> runSQLQuery(String SQLCode, Object modelToUse, Object[] parameters, JdbcTemplate JDBC)
    {

        try
        {

            if(modelToUse.getClass() == Long.class
                            || modelToUse.getClass() == Integer.class
                            || modelToUse.getClass() == Short.class
                            || modelToUse.getClass() == Byte.class
                            || modelToUse.getClass() == Float.class
                            || modelToUse.getClass() == Double.class
                            || modelToUse.getClass() == Boolean.class
                            || modelToUse.getClass() == String.class
                            || modelToUse.getClass() == Character.class)
            {
                return DatabaseQueriesForPrimitivesDAO.queryForPrimitiveType(SQLCode, modelToUse, parameters, JDBC);
            }
            else
            {

                if(parameters != null)
                {
                    List<Object> results = JDBC.query(SQLCode, new OrionBeanPropertyRowMapper<Object>((Class<Object>)modelToUse.getClass()), parameters);
                    return decryptTheResults(results);
                }
                else
                {
                    List<Object> results = JDBC.query(SQLCode, new OrionBeanPropertyRowMapper<Object>((Class<Object>)modelToUse.getClass()));
                    return decryptTheResults(results);
                }

            }

        }
        catch(DataAccessException e)
        {
            logError(e.getMessage());
            throw e;
        }
        catch(Exception e)
        {
            logError(e.getMessage());
            throw e;
        }

    }


    private List<Object> decryptTheResults(List<Object> results)
    {

        if(results != null)
        {
            List<Object> decryptedResults = new ArrayList<>(results.size());

            for(Object result : results)
            {

                try
                {
                    DataSecurityService.decryptObject(result);
                }
                catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
                {
                    //
                }

                decryptedResults.add(result);
            }

            return decryptedResults;
        }
        else
        {
            return null;
        }

    }
}