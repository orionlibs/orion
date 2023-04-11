package com.orion.core.operatingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.orion.core.operating_system.OperatingSystemService;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class OperatingSystemServiceTest
{
    @Test
    public void testIsWindowsSystem()
    {
        assertEquals(SystemUtils.IS_OS_WINDOWS, OperatingSystemService.isWindowsSystem());
    }


    @Test
    public void testIsLinuxSystem()
    {
        assertEquals(SystemUtils.IS_OS_LINUX, OperatingSystemService.isLinuxSystem());
    }
}