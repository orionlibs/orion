package com.orion.data.source.database;

import com.orion.core.abstraction.Orion;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseQueriesForPrimitivesDAO extends Orion
{
    @SuppressWarnings("unchecked")
    public static List<Object> queryForPrimitiveType(String SQLCode, Object modelToUse, Object[] parameters, JdbcTemplate JDBC) throws DataAccessException
    {

        try
        {

            if(parameters != null)
            {
                return (List<Object>)JDBC.queryForList(SQLCode, modelToUse.getClass(), parameters);
            }
            else
            {
                return (List<Object>)JDBC.queryForList(SQLCode, modelToUse.getClass());
            }

        }
        catch(EmptyResultDataAccessException e)
        {
            return null;
        }

    }
}