package com.orion.analytics.users.authentications;

// @RunWith(PowerMockRunner.class)
// @RunWith(MockitoJUnitRunner.class)
// @Tag("fast")
/*
 * @PrepareForTest( {UserGeneralAnalyticsService.class})
 */
// @TestInstance(Lifecycle.PER_CLASS)
public class UserAuthenticationAnalyticsServiceTest
{
    //private MockedStatic<UserGeneralAnalyticsService> userGeneralAnalyticsService;
    /*@BeforeAll
    public void setUp() throws Exception
    {
        mockStatic(UserGeneralAnalyticsService.class);
        //userGeneralAnalyticsService = Mockito.mockStatic(UserGeneralAnalyticsService.class);
        when(UserGeneralAnalyticsService.getNumberOfRegisteredUsers()).thenReturn(10L);
    }


    @Test
    public void test_getPercentageOfLoggedInUsersOfAllUsers() throws DataAccessException, Exception
    {
        when(UserGeneralAnalyticsService.getNumberOfLoggedInUsers()).thenReturn(6L);
        BigDecimal result = UserAuthenticationAnalyticsService.getPercentageOfLoggedInUsersOfAllUsers();
        BigDecimal expected = new BigDecimal(60.0);
        assertThat(result.doubleValue()).isEqualTo(expected.doubleValue());
    }


    @Test
    public void test_getPercentageOfLoggedOutUsersOfAllUsers() throws DataAccessException, Exception
    {
        when(UserGeneralAnalyticsService.getNumberOfLoggedOutUsers()).thenReturn(6L);
        BigDecimal result = UserAuthenticationAnalyticsService.getPercentageOfLoggedOutUsersOfAllUsers();
        BigDecimal expected = new BigDecimal(60.0);
        assertThat(result.doubleValue()).isEqualTo(expected.doubleValue());
    }*/
}