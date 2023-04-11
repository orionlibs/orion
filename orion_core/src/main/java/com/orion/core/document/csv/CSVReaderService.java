package com.orion.core.document.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.orion.core.abstraction.OrionService;
import com.orion.core.file_system.file.FileService;
import com.orion.core.utility.OrionUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class CSVReaderService extends OrionService
{
    private Reader reader;
    private CSVReader csvReader;
    private String fullFilePathAndName;
    private String fileContent;


    public CSVReaderService()
    {
    }


    public CSVReaderService(String fullFilePathAndName) throws IOException
    {
        this.fullFilePathAndName = fullFilePathAndName;
        this.reader = new FileReader(fullFilePathAndName);
        this.csvReader = new CSVReader(reader);
    }


    public CSVReaderService(InputStream inputStream) throws IOException
    {
        this.fileContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        this.reader = new StringReader(fileContent);
        this.csvReader = new CSVReader(reader);
    }


    public void closeCSVFile()
    {
        OrionUtils.closeResource(this.reader);
    }


    public String getCSVAsString() throws FileNotFoundException, IOException
    {
        return FileService.convertFileToString(fullFilePathAndName);
    }


    public List<String[]> getCSVRows() throws IOException, CsvException
    {
        List<String[]> rows = csvReader.readAll();
        closeCSVFile();
        return rows;
    }


    public List<String[]> getCSVRowsExceptForHeader() throws IOException, CsvException
    {
        List<String[]> rows = csvReader.readAll();
        closeCSVFile();
        return rows.subList(1, rows.size());
    }


    public List<String> getCSVColumn(int columnIndex) throws IOException, CsvException
    {
        List<String[]> rows = csvReader.readAll();
        closeCSVFile();
        List<String> column = new ArrayList<>();
        rows.forEach(row -> column.add(row[columnIndex]));
        return column;
    }


    public List<String> getCSVColumnExceptForHeader(int columnIndex) throws IOException, CsvException
    {
        List<String[]> rows = csvReader.readAll();
        closeCSVFile();
        List<String> column = new ArrayList<>();
        rows.forEach(row -> column.add(row[columnIndex]));
        return column.subList(1, rows.size());
    }
}