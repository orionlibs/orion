package com.orion;

import com.orion.core.CoreCucumberTest;
import com.orion.data_user.DataUserCucumberTest;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;
// import org.junit.runner.RunWith;
// import org.junit.runners.Suite;
import org.junit.platform.suite.api.Suite;

// @RunWith(Suite.class)
/*
 * @SelectPackages( {"com.onelivery.api", "com.orion"})
 */
// @IncludeTags("production")
@Suite
@IncludeEngines(
{"junit-jupiter", "cucumber"})
@SelectClasses(
{CoreCucumberTest.class, DataUserCucumberTest.class})
public class OrionTestSuite
{
}