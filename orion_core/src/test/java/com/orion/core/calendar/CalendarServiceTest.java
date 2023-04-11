package com.orion.core.calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.InvalidDateTimeException;
import com.orion.core.calendar.time.InvalidTimeException;
import com.orion.core.calendar.time.Time;
import com.orion.core.exception.InvalidArgumentException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// @RunWith(PowerMockRunner.class)
// @RunWith(MockitoJUnitRunner.class)
// @PrepareForTest({CalendarService.class})
@TestInstance(Lifecycle.PER_CLASS)
public class CalendarServiceTest
{
    private ZoneId zone;


    @BeforeAll
    public void setUp() throws Exception
    {
        zone = ZoneId.of("UTC");
        //PowerMockito.mockStatic(CalendarService.class);
    }


    @Test
    public void test_formatDateTimeUnitWith2Characters() throws InvalidArgumentException
    {
        String result = CalendarService.formatDateTimeUnitWith2Characters(8);
        assertThat(result).isEqualTo("08");
        result = CalendarService.formatDateTimeUnitWith2Characters(16);
        assertThat(result).isEqualTo("16");
    }


    @Test
    public void test_convertDateTimeToEpochSeconds() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1970-01-01", "00:00:00");
        long result = CalendarService.convertDateTimeToEpochSeconds(datetime);
        assertThat(result).isEqualTo(0);
        datetime = DateTime.of("1970-01-02", "00:00:01");
        result = CalendarService.convertDateTimeToEpochSeconds(datetime);
        assertThat(result).isEqualTo(86401);
        datetime = DateTime.of("1970-01-02", "00:00:01", ZoneId.of("GMT+1"));
        result = CalendarService.convertDateTimeToEpochSeconds(datetime);
        assertThat(result).isEqualTo(82801);
    }


    @Test
    public void test_convertEpochSecondsToDateTime() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime result = CalendarService.convertEpochSecondsToDateTime(0);
        assertThat(result).isEqualTo(DateTime.of("1970-01-01", "00:00:00"));
        result = CalendarService.convertEpochSecondsToDateTime(86401);
        assertThat(result).isEqualTo(DateTime.of("1970-01-02", "00:00:01"));
    }


    @Test
    public void test_tokeniseDateString() throws InvalidArgumentException, InvalidDateException
    {
        String[] result = CalendarService.tokeniseDateString("01-01-1970");
        String[] expected = new String[]
        {"01", "01", "1970"};
        assertThat(result).isEqualTo(expected);
        result = CalendarService.tokeniseDateString("01/01/1970");
        expected = new String[]
        {"01", "01", "1970"};
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_tokeniseDateString_exception() throws InvalidArgumentException, InvalidDateException
    {
        InvalidDateException exception = Assertions.assertThrows(InvalidDateException.class, () ->
        {
            CalendarService.tokeniseDateString("01.01.1970");
        });
        assertEquals("com.orion.core.calendar.date.InvalidDateException", exception.getClass().getName());
    }


    @Test
    public void test_convertInstantToLocalDate() throws InvalidArgumentException
    {
        LocalDate result = CalendarService.convertInstantToLocalDate(Instant.EPOCH, zone);
        assertThat(result).isEqualTo(LocalDate.EPOCH);
    }


    @Test
    public void test_extractYearFromDateString() throws InvalidArgumentException, InvalidDateException
    {
        int result = CalendarService.extractYearFromDateString("1970-01-01");
        assertThat(result).isEqualTo(1970);
        result = CalendarService.extractYearFromDateString("1970/01/01");
        assertThat(result).isEqualTo(1970);
    }


    @Test
    public void test_getNumberOfMonthDays() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        Date date = Date.of("05-07-2019");
        int result = CalendarService.getNumberOfMonthDays(date);
        assertThat(result).isEqualTo(31);
        DateTime datetime = DateTime.of("05-07-2019", "00:00:00");
        result = CalendarService.getNumberOfMonthDays(datetime);
        assertThat(result).isEqualTo(31);
        result = CalendarService.getNumberOfMonthDays("05/07/2019");
        assertThat(result).isEqualTo(31);
    }


    @Test
    public void test_calculatePersonsAge() throws InvalidDateException
    {
        Date date = Date.of("1986-04-17");
        int result = CalendarService.calculateAgeInYears(date);
        assertThat(result).isGreaterThanOrEqualTo(33);
    }


    @Test
    public void test_calculatePersonsAge2() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00");
        int result = CalendarService.calculateAgeInYears(datetime);
        assertThat(result).isGreaterThanOrEqualTo(33);
    }


    @Test
    public void test_calculatePersonsAge3()
    {
        int result = CalendarService.calculateAgeInYears("1986-04-17");
        assertThat(result).isGreaterThanOrEqualTo(34);
    }


    @Test
    public void test_getDaysAsSeconds()
    {
        int result = CalendarService.getDaysAsSeconds(2);
        assertThat(result).isEqualTo(172800);
    }


    @Test
    public void test_getHoursAsSeconds()
    {
        long result = CalendarService.getHoursAsSeconds(2);
        assertThat(result).isEqualTo(7200);
    }


    @Test
    public void test_getMinutesAsSeconds()
    {
        long result = CalendarService.getMinutesAsSeconds(20);
        assertThat(result).isEqualTo(1200);
    }


    @Test
    public void test_getMillisecondsAsHours()
    {
        double result = CalendarService.getMillisecondsAsHours(9_000_000);
        assertThat(result).isEqualTo(2.5);
    }


    @Test
    public void test_addDaysToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addDaysToDatetime(datetime, 32);
        DateTime expected = DateTime.of("1986-05-19", "00:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addHoursToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addHoursToDatetime(datetime, 32);
        DateTime expected = DateTime.of("1986-04-18", "08:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addMinutesToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addMinutesToDatetime(datetime, 32);
        DateTime expected = DateTime.of("1986-04-17", "00:32:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addSecondsToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addSecondsToDatetime(datetime, 32);
        DateTime expected = DateTime.of("1986-04-17", "00:00:32", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addMillisecondsToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addMillisecondsToDatetime(datetime, 32);
        DateTime expected = DateTime.of("1986-04-17", "00:00:00.32", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addMonthsToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addMonthsToDatetime(datetime, 13);
        DateTime expected = DateTime.of("1987-05-17", "00:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addWeeksToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addWeeksToDatetime(datetime, 3);
        DateTime expected = DateTime.of("1986-05-08", "00:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_addYearsToDatetime() throws InvalidDateException, InvalidTimeException
    {
        DateTime datetime = DateTime.of("1986-04-17", "00:00:00", ZoneId.of("UTC"));
        DateTime result = CalendarService.addYearsToDatetime(datetime, 3);
        DateTime expected = DateTime.of("1989-04-17", "00:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
        datetime = DateTime.of("1987-04-17", "00:00:00", ZoneId.of("UTC"));
        result = CalendarService.addYearsToDatetime(datetime, 4);
        expected = DateTime.of("1991-04-17", "00:00:00", ZoneId.of("UTC"));
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_convertDateObjectToDateTimeObject() throws InvalidDateException, InvalidTimeException
    {
        DateTime result = CalendarService.convertDateObjectToDateTimeObject(Date.of(1970, 1, 1));
        assertThat(result).isEqualTo(DateTime.of("1970-01-01", "00:00:00"));
    }


    @Test
    public void test_convertDateTimeStringToDateTimeObject() throws InvalidArgumentException, InvalidDateException, InvalidTimeException, InvalidDateTimeException
    {
        DateTime result = CalendarService.convertDateTimeStringToDateTimeObject("1986-04-17T00:00:00");
        DateTime expected = DateTime.of("1986-04-17", "00:00:00");
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_convertDateStringToDateObject() throws InvalidArgumentException
    {
        Date result = CalendarService.convertSQLDateStringToDateObject("1986-04-17");
        assertThat(result).isEqualTo(Date.of(1986, 4, 17));
    }


    @Test
    public void test_convertTimeStringToTimeObject() throws InvalidArgumentException, InvalidTimeException
    {
        Time result = CalendarService.convertTimeStringToTimeObject("17:20:02");
        assertThat(result).isEqualTo(Time.of(17, 20, 2));
    }


    @Test
    public void test_convertMillisecondsToTemporalUnit() throws InvalidArgumentException
    {
        long result = CalendarService.convertMillisecondsToTemporalUnit(86401000, ChronoUnit.SECONDS);
        assertThat(result).isEqualTo(86401);
        result = CalendarService.convertMillisecondsToTemporalUnit(31_622_400_000L, ChronoUnit.DAYS);
        assertThat(result).isEqualTo(366);
    }


    @Test
    public void test_convertZonedDateTimeToDate() throws InvalidArgumentException, InvalidDateException
    {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("1970-01-01T17:20:02+01:00[Europe/Paris]");
        Date result = CalendarService.convertZonedDateTimeToDate(zonedDateTime);
        assertThat(result).isEqualTo(Date.of("1970-01-01"));
    }


    @Test
    public void test_convertZonedDatetimeToDatetime() throws InvalidArgumentException
    {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("1970-01-01T17:20:02+01:00[Europe/Paris]");
        DateTime result = CalendarService.convertZonedDatetimeToDatetime(zonedDateTime);
        Date expectedDate = Date.of(1970, 1, 1);
        Time expectedTime = Time.of(17, 20, 2);
        ZoneId expectedZone = ZoneId.of("Europe/Paris");
        assertThat(result).isEqualTo(DateTime.of(expectedDate, expectedTime, expectedZone));
    }


    @Test
    public void test_convertDatetimeToZonedDatetime() throws InvalidArgumentException
    {
        Date date = Date.of(1970, 1, 1);
        Time time = Time.of(17, 20, 2);
        ZoneId zone = ZoneId.of("Europe/Paris");
        DateTime datetime = DateTime.of(date, time, zone);
        ZonedDateTime result = CalendarService.convertDatetimeToZonedDatetime(datetime);
        assertThat(result).isEqualTo(ZonedDateTime.parse("1970-01-01T17:20:02+01:00[Europe/Paris]"));
    }


    @Test
    public void test_convertSQLDateToInternationalFormat() throws InvalidArgumentException
    {
        DateTime result = CalendarService.convertSQLDateStringToDateTimeObject("1970-01-01");
        assertThat(result).isEqualTo(DateTime.of(Date.of(1970, 1, 1)));
    }


    @Test
    public void test_convertDateToLongFormat() throws InvalidDateException
    {
        String result = CalendarService.convertDateToLongFormatYearFirst(DateTokens.builder()
                        .days(17)
                        .month(4)
                        .year(1986)
                        .build());
        String expected = "1986 Apr 17";
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_convertDateToLongFormat2() throws InvalidDateException
    {
        Date date = Date.of("1986-04-17");
        String result = CalendarService.convertDateToLongFormat(date.getAsTokens());
        String expected = "17 Apr 1986";
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_formatDifferenceBetweenTwoDateTimesBasedOnUnits() throws InvalidArgumentException
    {
        Long[] durationAsList = new Long[]
        {0L};
        String result = CalendarService.formatDifferenceBetweenTwoDateTimesBasedOnUnits(durationAsList, "y");
        assertThat(result).isEqualTo("0 years");
        durationAsList = new Long[]
        {1L};
        result = CalendarService.formatDifferenceBetweenTwoDateTimesBasedOnUnits(durationAsList, "y");
        assertThat(result).isEqualTo("1 year");
        durationAsList = new Long[]
        {2L};
        result = CalendarService.formatDifferenceBetweenTwoDateTimesBasedOnUnits(durationAsList, "y");
        assertThat(result).isEqualTo("2 years");
        durationAsList = new Long[]
        {2L, 4L};
        result = CalendarService.formatDifferenceBetweenTwoDateTimesBasedOnUnits(durationAsList, "yM");
        assertThat(result).isEqualTo("2 years and 4 months");
        durationAsList = new Long[]
        {2L, 4L, 1L, 2L, 12L, 56L, 0L};
        result = CalendarService.formatDifferenceBetweenTwoDateTimesBasedOnUnits(durationAsList, "yMWdhms");
        assertThat(result).isEqualTo("2 years, 4 months, 1 week, 2 days, 12 hours, 56 minutes and 0 seconds");
    }


    @Test
    public void test_getDayOfWeekAsIntegerFromDateTime() throws InvalidDateException, InvalidTimeException
    {
        int result = CalendarService.getDayOfWeekAsIntegerFromDateTime(DateTime.of("1986-04-17", "00:00:00"));
        assertThat(result).isEqualTo(4);
    }


    @Test
    public void test_getDayValueFromDateTime() throws InvalidDateException, InvalidTimeException
    {
        int result = CalendarService.getDayValueFromDateTime(DateTime.of("1986-04-17", "00:00:00"));
        assertThat(result).isEqualTo(17);
    }


    @Test
    public void test_getDifferenceAsListBetweenTwoDateTimesBasedOnUnits() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        String units = "y";
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        Long[] result = CalendarService.getDifferenceAsListBetweenTwoDateTimesBasedOnUnits(units, startDateTime, endDateTime);
        Long[] expected = new Long[]
        {1L};
        assertThat(result).isEqualTo(expected);
        units = "yMWdhms";
        startDateTime = DateTime.of("2000-01-01", "00:00:00");
        endDateTime = DateTime.of("2002-09-04", "17:56:04");
        result = CalendarService.getDifferenceAsListBetweenTwoDateTimesBasedOnUnits(units, startDateTime, endDateTime);
        expected = new Long[]
        {2L, 8L, 1L, 0L, 17L, 56L, 4L};
        assertThat(result).isEqualTo(expected);
        units = "mdM";
        startDateTime = DateTime.of("2000-01-01", "00:00:00");
        endDateTime = DateTime.of("2002-09-04", "17:56:04");
        result = CalendarService.getDifferenceAsListBetweenTwoDateTimesBasedOnUnits(units, startDateTime, endDateTime);
        expected = new Long[]
        {32L, 7L, 1076L};
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test_getDifferenceBetweenTwoDateTimesInMilliseconds() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        Long result = CalendarService.getDifferenceBetweenTwoDateTimesInMilliseconds(startDateTime, endDateTime);
        assertThat(result).isEqualTo(31_622_400_000L);
        startDateTime = DateTime.of("2000-01-01", "00:00:00");
        endDateTime = DateTime.of("2002-09-04", "17:56:04");
        result = CalendarService.getDifferenceBetweenTwoDateTimesInMilliseconds(startDateTime, endDateTime);
        assertThat(result).isEqualTo(84_477_364_000L);
        result = CalendarService.getDifferenceBetweenTwoDateTimesInMilliseconds(endDateTime, startDateTime);
        assertThat(result).isEqualTo(-84_477_364_000L);
    }


    @Test
    public void test_getDifferenceBetweenTwoDatesInMilliseconds() throws InvalidArgumentException, InvalidDateException
    {
        Date startDate = Date.of("2000-01-01");
        Date endDate = Date.of("2001-01-01");
        Long result = CalendarService.getDifferenceBetweenTwoDatesInMilliseconds(startDate, endDate);
        assertThat(result).isEqualTo(31_622_400_000L);
        startDate = Date.of("2000-01-01");
        endDate = Date.of("2002-09-04");
        result = CalendarService.getDifferenceBetweenTwoDatesInMilliseconds(startDate, endDate);
        assertThat(result).isEqualTo(84_412_800_000L);
        result = CalendarService.getDifferenceBetweenTwoDatesInMilliseconds(endDate, startDate);
        assertThat(result).isEqualTo(-84_412_800_000L);
    }


    @Test
    public void test_getDifferenceBetweenTwoTimesInMilliseconds() throws InvalidArgumentException, InvalidTimeException
    {
        Time startTime = Time.of("00:00:00");
        Time endTime = Time.of("17:56:04");
        Long result = CalendarService.getDifferenceBetweenTwoTimesInMilliseconds(startTime, endTime);
        assertThat(result).isEqualTo(64_564_000);
        result = CalendarService.getDifferenceBetweenTwoTimesInMilliseconds(endTime, startTime);
        assertThat(result).isEqualTo(-64_564_000);
    }


    @Test
    public void test_isDateWithinRange() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime dateTimeToCheck = DateTime.of("2000-01-07", "00:00:00");
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        boolean result = CalendarService.isDateWithinRange(dateTimeToCheck, startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        dateTimeToCheck = DateTime.of("1999-01-01", "00:00:00");
        result = CalendarService.isDateWithinRange(dateTimeToCheck, startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        dateTimeToCheck = DateTime.of("2002-01-01", "00:00:00");
        result = CalendarService.isDateWithinRange(dateTimeToCheck, startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        dateTimeToCheck = DateTime.of("2000-01-01", "00:00:00");
        result = CalendarService.isDateWithinRange(dateTimeToCheck, startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        dateTimeToCheck = DateTime.of("2001-01-01", "00:00:00");
        result = CalendarService.isDateWithinRange(dateTimeToCheck, startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
    }


    @Test
    public void test_isDateAfterAnother() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        boolean result = CalendarService.isDateAfterAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        startDateTime = DateTime.of("2001-01-01", "00:00:00");
        result = CalendarService.isDateAfterAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        startDateTime = DateTime.of("2002-01-01", "00:00:00");
        result = CalendarService.isDateAfterAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
    }


    @Test
    public void test_isDateAfterOrEqualsAnother() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        boolean result = CalendarService.isDateAfterOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        startDateTime = DateTime.of("2001-01-01", "00:00:00");
        result = CalendarService.isDateAfterOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        startDateTime = DateTime.of("2002-01-01", "00:00:00");
        result = CalendarService.isDateAfterOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
    }


    @Test
    public void test_isDateBeforeAnother() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        boolean result = CalendarService.isDateBeforeAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        startDateTime = DateTime.of("2001-01-01", "00:00:00");
        result = CalendarService.isDateBeforeAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
        startDateTime = DateTime.of("2002-01-01", "00:00:00");
        result = CalendarService.isDateBeforeAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
    }


    @Test
    public void test_isDateBeforeOrEqualsAnother() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime startDateTime = DateTime.of("2000-01-01", "00:00:00");
        DateTime endDateTime = DateTime.of("2001-01-01", "00:00:00");
        boolean result = CalendarService.isDateBeforeOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        startDateTime = DateTime.of("2001-01-01", "00:00:00");
        result = CalendarService.isDateBeforeOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(true);
        startDateTime = DateTime.of("2002-01-01", "00:00:00");
        result = CalendarService.isDateBeforeOrEqualsAnother(startDateTime, endDateTime);
        assertThat(result).isEqualTo(false);
    }


    @Test
    public void test_getPercentageOfMonthFromADateUntilTheEndOfMonth() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime dateTime = DateTime.of("2000-01-01", "00:00:00");
        double result = CalendarService.getPercentageOfMonthFromADateUntilTheEndOfMonth(dateTime);
        assertThat(result).isEqualTo(1.0);
        dateTime = DateTime.of("2000-01-16", "00:00:00");
        result = CalendarService.getPercentageOfMonthFromADateUntilTheEndOfMonth(dateTime);
        assertThat(result).isEqualTo(0.5161290322580645);
        dateTime = DateTime.of("2000-01-31", "00:00:00");
        result = CalendarService.getPercentageOfMonthFromADateUntilTheEndOfMonth(dateTime);
        assertThat(result).isEqualTo(0.03225806451612903);
    }


    @Test
    public void test_sortDateTimes() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime dateTime1 = DateTime.of("2000-01-01", "00:00:00");
        DateTime dateTime2 = DateTime.of("1999-01-01", "00:00:00");
        DateTime dateTime3 = DateTime.of("2001-01-01", "00:00:00");
        List<DateTime> datetimes = Arrays.asList(dateTime1, dateTime2, dateTime3);
        List<DateTime> result = CalendarService.sortDateTimes(datetimes);
        DateTime expectedDateTime1 = DateTime.of("1999-01-01", "00:00:00");
        DateTime expectedDateTime2 = DateTime.of("2000-01-01", "00:00:00");
        DateTime expectedDateTime3 = DateTime.of("2001-01-01", "00:00:00");
        List<DateTime> expectedDatetimes = Arrays.asList(expectedDateTime1, expectedDateTime2, expectedDateTime3);
        assertThat(result).isEqualTo(expectedDatetimes);
        datetimes = Arrays.asList(dateTime3, dateTime1, dateTime2);
        result = CalendarService.sortDateTimes(datetimes);
        assertThat(result).isEqualTo(expectedDatetimes);
        dateTime1 = DateTime.of("2000-01-01", "02:00:00");
        dateTime2 = DateTime.of("2000-01-01", "00:00:00");
        dateTime3 = DateTime.of("2000-01-01", "01:00:00");
        datetimes = Arrays.asList(dateTime1, dateTime2, dateTime3);
        result = CalendarService.sortDateTimes(datetimes);
        expectedDateTime1 = DateTime.of("2000-01-01", "00:00:00");
        expectedDateTime2 = DateTime.of("2000-01-01", "01:00:00");
        expectedDateTime3 = DateTime.of("2000-01-01", "02:00:00");
        expectedDatetimes = Arrays.asList(expectedDateTime1, expectedDateTime2, expectedDateTime3);
        assertThat(result).isEqualTo(expectedDatetimes);
    }


    @Test
    public void test_sortDateTimesInReverse() throws InvalidArgumentException, InvalidDateException, InvalidTimeException
    {
        DateTime dateTime1 = DateTime.of("2000-01-01", "00:00:00");
        DateTime dateTime2 = DateTime.of("1999-01-01", "00:00:00");
        DateTime dateTime3 = DateTime.of("2001-01-01", "00:00:00");
        List<DateTime> datetimes = Arrays.asList(dateTime1, dateTime2, dateTime3);
        List<DateTime> result = CalendarService.sortDateTimesInReverse(datetimes);
        DateTime expectedDateTime1 = DateTime.of("2001-01-01", "00:00:00");
        DateTime expectedDateTime2 = DateTime.of("2000-01-01", "00:00:00");
        DateTime expectedDateTime3 = DateTime.of("1999-01-01", "00:00:00");
        List<DateTime> expectedDatetimes = Arrays.asList(expectedDateTime1, expectedDateTime2, expectedDateTime3);
        assertThat(result).isEqualTo(expectedDatetimes);
        datetimes = Arrays.asList(dateTime3, dateTime1, dateTime2);
        result = CalendarService.sortDateTimesInReverse(datetimes);
        assertThat(result).isEqualTo(expectedDatetimes);
        dateTime1 = DateTime.of("2000-01-01", "02:00:00");
        dateTime2 = DateTime.of("2000-01-01", "00:00:00");
        dateTime3 = DateTime.of("2000-01-01", "01:00:00");
        datetimes = Arrays.asList(dateTime1, dateTime2, dateTime3);
        result = CalendarService.sortDateTimesInReverse(datetimes);
        expectedDateTime1 = DateTime.of("2000-01-01", "02:00:00");
        expectedDateTime2 = DateTime.of("2000-01-01", "01:00:00");
        expectedDateTime3 = DateTime.of("2000-01-01", "00:00:00");
        expectedDatetimes = Arrays.asList(expectedDateTime1, expectedDateTime2, expectedDateTime3);
        assertThat(result).isEqualTo(expectedDatetimes);
    }


    @Test
    public void test_sortDates() throws InvalidArgumentException, InvalidDateException
    {
        Date date1 = Date.of("2000-01-01");
        Date date2 = Date.of("1999-01-01");
        Date date3 = Date.of("2001-01-01");
        List<Date> dates = Arrays.asList(date1, date2, date3);
        List<Date> result = CalendarService.sortDates(dates);
        Date expectedDate1 = Date.of("1999-01-01");
        Date expectedDate2 = Date.of("2000-01-01");
        Date expectedDate3 = Date.of("2001-01-01");
        List<Date> expectedDates = Arrays.asList(expectedDate1, expectedDate2, expectedDate3);
        assertThat(result).isEqualTo(expectedDates);
        dates = Arrays.asList(date3, date1, date2);
        result = CalendarService.sortDates(dates);
        assertThat(result).isEqualTo(expectedDates);
    }


    @Test
    public void test_getDurationInSecondsRoundedUpToTheClosest5MinuteMark()
    {
        long result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 0);
        assertThat(result).isEqualTo(0);
        result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 60);
        assertThat(result).isEqualTo(300);
        result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 299);
        assertThat(result).isEqualTo(300);
        result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 300);
        assertThat(result).isEqualTo(300);
        result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 301);
        assertThat(result).isEqualTo(600);
        result = CalendarService.getDurationInSecondsRoundedUpToTheClosestNMinuteMark(5, 763);
        assertThat(result).isEqualTo(900);
    }
}