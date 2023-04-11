package com.orion.core.hexadecimals;

import static org.assertj.core.api.Assertions.assertThat;

import com.orion.core.numerical_base.hexadecimal.HexadecimalService;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class HexadecimalsServiceTest
{
    @Test
    public void test_hexadecimals()
    {
        String result = HexadecimalService.convertToHexadecimalBase("0");
        assertThat(result).isEqualTo("30");
        result = HexadecimalService.convertToHexadecimalBase("a");
        assertThat(result).isEqualTo("61");
    }
}