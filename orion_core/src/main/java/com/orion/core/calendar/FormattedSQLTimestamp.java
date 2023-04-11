package com.orion.core.calendar;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.string.StringsService;

public class FormattedSQLTimestamp extends Orion
{
    public static void setupFormattedDateTime(SQLTimestamp timestamp)
    {

        if(!timestamp.getHaveFormattedValuesBeenInitialised())
        {
            timestamp.setHaveFormattedValuesBeenInitialised(true);
            int offsetHours = CalendarService.getDaylightSavingsHoursToAdd();
            DateTime dateTimeAdjustedForDaylightSavings = null;

            if(offsetHours != 0)
            {
                dateTimeAdjustedForDaylightSavings = DateTime.of(CalendarService.addHoursToDatetime(timestamp, offsetHours));
                timestamp.setFormattedDate(dateTimeAdjustedForDaylightSavings.printDateAsIsInInternationalFormat());
                timestamp.setFormattedDateWithSlashes(dateTimeAdjustedForDaylightSavings.printDateAsIsInInternationalFormatWithSlashes());
                timestamp.setFormattedDateWithSlashesYearFirst(dateTimeAdjustedForDaylightSavings.printDateAsIsInInternationalFormatWithSlashesYearFirst());
                timestamp.setFormattedDateWithHyphens(dateTimeAdjustedForDaylightSavings.printDateAsIsInInternationalFormat());
                timestamp.setFormattedDateWithHyphensYearFirst(dateTimeAdjustedForDaylightSavings.printDateAsIsInSQLFormat());
                timestamp.setFormattedDateWithHyphensWithoutYear(dateTimeAdjustedForDaylightSavings.getDate().getDateStringSplitByHyphensWithoutYear());
                timestamp.setFormattedTimeWithoutSeconds(dateTimeAdjustedForDaylightSavings.printTimeAsIsWithoutSeconds());
                timestamp.setFormattedTime(dateTimeAdjustedForDaylightSavings.printTimeAsIs());
            }
            else
            {
                int years = timestamp.getYears();
                StringBuilder sb = new StringBuilder(formatDayWith2Characters(timestamp));
                sb.append("-");
                sb.append(formatMonthWith2Characters(timestamp));
                sb.append("-");
                sb.append(years);
                timestamp.setFormattedDate(sb.toString());
                sb = new StringBuilder();
                sb.append(years);
                sb.append("-");
                sb.append(formatMonthWith2Characters(timestamp));
                sb.append("-");
                sb.append(formatDayWith2Characters(timestamp));
                timestamp.setFormattedDateWithHyphensYearFirst(sb.toString());
                sb = new StringBuilder();
                sb.append(years);
                sb.append("/");
                sb.append(formatMonthWith2Characters(timestamp));
                sb.append("/");
                sb.append(formatDayWith2Characters(timestamp));
                timestamp.setFormattedDateWithSlashesYearFirst(sb.toString());
                sb = new StringBuilder(formatDayWith2Characters(timestamp));
                sb.append("/");
                sb.append(formatMonthWith2Characters(timestamp));
                sb.append("/");
                sb.append(years);
                timestamp.setFormattedDateWithSlashes(sb.toString());
                sb = new StringBuilder(formatHoursString(timestamp));
                sb.append(":");
                sb.append(formatMinutesString(timestamp));
                timestamp.setFormattedTimeWithoutSeconds(sb.toString());
                sb.append(":");
                sb.append(formatSecondsString(timestamp));
                timestamp.setFormattedTime(sb.toString());
                sb = new StringBuilder(formatDayWith2Characters(timestamp));
                sb.append("-");
                sb.append(formatMonthWith2Characters(timestamp));
                sb.append("-");
                sb.append(years);
                timestamp.setFormattedDateWithHyphens(sb.toString());
                sb = new StringBuilder(formatDayWith2Characters(timestamp));
                sb.append("-");
                sb.append(formatMonthWith2Characters(timestamp));
                timestamp.setFormattedDateWithHyphensWithoutYear(sb.toString());
            }

        }

    }


    public static void setupFormattedDateTimeUTC(SQLTimestamp timestamp)
    {

        if(!timestamp.getHaveFormattedValuesBeenInitialised())
        {
            timestamp.setHaveFormattedValuesBeenInitialised(true);
            int years = timestamp.getYears();
            StringBuilder sb = new StringBuilder(formatDayWith2Characters(timestamp));
            sb.append("-");
            sb.append(formatMonthWith2Characters(timestamp));
            sb.append("-");
            sb.append(years);
            timestamp.setFormattedDate(sb.toString());
            sb = new StringBuilder();
            sb.append(years);
            sb.append("-");
            sb.append(formatMonthWith2Characters(timestamp));
            sb.append("-");
            sb.append(formatDayWith2Characters(timestamp));
            timestamp.setFormattedDateWithHyphensYearFirst(sb.toString());
            sb = new StringBuilder();
            sb.append(years);
            sb.append("/");
            sb.append(formatMonthWith2Characters(timestamp));
            sb.append("/");
            sb.append(formatDayWith2Characters(timestamp));
            timestamp.setFormattedDateWithSlashesYearFirst(sb.toString());
            sb = new StringBuilder(formatDayWith2Characters(timestamp));
            sb.append("/");
            sb.append(formatMonthWith2Characters(timestamp));
            sb.append("/");
            sb.append(years);
            timestamp.setFormattedDateWithSlashes(sb.toString());
            sb = new StringBuilder(formatHoursString(timestamp));
            sb.append(":");
            sb.append(formatMinutesString(timestamp));
            timestamp.setFormattedTimeWithoutSeconds(sb.toString());
            sb.append(":");
            sb.append(formatSecondsString(timestamp));
            timestamp.setFormattedTime(sb.toString());
            sb = new StringBuilder(formatDayWith2Characters(timestamp));
            sb.append("-");
            sb.append(formatMonthWith2Characters(timestamp));
            sb.append("-");
            sb.append(years);
            timestamp.setFormattedDateWithHyphens(sb.toString());
            sb = new StringBuilder(formatDayWith2Characters(timestamp));
            sb.append("-");
            sb.append(formatMonthWith2Characters(timestamp));
            timestamp.setFormattedDateWithHyphensWithoutYear(sb.toString());
        }

    }


    @SuppressWarnings("deprecation")
    private static String formatMonthWith2Characters(SQLTimestamp timestamp)
    {
        int monthTemp = timestamp.getMonth() + 1;
        String monthString = Long.toString(monthTemp);

        if(monthTemp < 10)
        {
            return StringsService.prefixString(monthString, "0");
        }
        else
        {
            return monthString;
        }

    }


    @SuppressWarnings("deprecation")
    private static String formatDayWith2Characters(SQLTimestamp timestamp)
    {
        int dayTemp = timestamp.getDate();
        String dayString = Long.toString(dayTemp);

        if(dayTemp < 10)
        {
            return StringsService.prefixString(dayString, "0");
        }
        else
        {
            return dayString;
        }

    }


    @SuppressWarnings("deprecation")
    public static String formatSecondsString(SQLTimestamp timestamp)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(timestamp.getSeconds());
    }


    @SuppressWarnings("deprecation")
    private static String formatHoursString(SQLTimestamp timestamp)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(timestamp.getHours());
    }


    @SuppressWarnings("deprecation")
    private static String formatMinutesString(SQLTimestamp timestamp)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(timestamp.getMinutes());
    }
}