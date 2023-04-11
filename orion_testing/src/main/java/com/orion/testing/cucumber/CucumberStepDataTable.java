package com.orion.testing.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.MessageFormat;
import java.util.Map;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class CucumberStepDataTable
{
    @NonNull
    private Map<String, String> row;


    public CucumberStepDataTable(Map<String, String> row)
    {
        this.row = row;
    }


    public String getCellValue(String columnName)
    {
        String value = row.get(columnName);
        assertFalse(StringUtils.isBlank(value), MessageFormat.format("empty '{0}' cell in table is not supported", columnName));
        return value;
    }


    public String getCellValueForKey(String key)
    {
        return row.get(key);
    }


    public String getCellValueForKeyOrDefault(String key, String defaultValueIfEmpty)
    {
        String value = getCellValueForKey(key);
        return StringUtils.isBlank(value) ? defaultValueIfEmpty : value;
    }


    public String getCellValueOrDefault(String columnName, String defaultValueIfEmpty)
    {
        return StringUtils.isBlank(row.get(columnName)) ? defaultValueIfEmpty : row.get(columnName);
    }
}
