package com.orion.data.source.database;

import com.orion.core.abstraction.Orion;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional("PlatformTransactionManager")
public class DatabaseStaticDAO extends Orion
{
    public void runStaticSQL(String SQLCode, JdbcTemplate JDBC)
    {

        try
        {
            JDBC.execute(SQLCode);
        }
        catch(DataAccessException e)
        {
            logError(e.getMessage());
            throw e;
        }

    }
}