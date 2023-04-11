package com.orion.math.number.average;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class AverageServiceTest
{
    @Test
    public void testGetArithmeticAverage1()
    {
        List<ANumber> numbers = Arrays.asList(ANumber.of(1), ANumber.of(2), ANumber.of(3), ANumber.of(4));
        ANumber result = AverageService.getArithmeticAverage(numbers);
        assertTrue(ANumber.of(2.5).equal(result));
    }


    @Test
    public void testGetArithmeticAverage2()
    {
        List<ANumber> numbers = Arrays.asList(Constants.E.getValue(), ANumber.of(2), ANumber.of(3));
        ANumber result = AverageService.getArithmeticAverage(numbers);
        assertTrue(ANumber.of(
                        "2.5727606094863484117867624904508874992524156978999865249889892092413588767845158648571273928417221424758221306440010199739391378655430145243001114317535318769127107762093144969210779432935843984170063371912780626435673846963833116280558364149204868893607549333894924706179141151474790358463592483306898505675872795354204437948610002506816446088534325355790377335697762363758145823490768989924031033805642789396751717028858212573704174632614750189845655902617")
                        .equal(result));
    }
}