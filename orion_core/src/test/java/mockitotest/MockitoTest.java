package mockitotest;

import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
// @RunWith(PowerMockRunner.class)
public class MockitoTest
{
    //@Mock
    //DatabaseDAO databaseDAO;
    //@Rule
    //public MockitoRule mockitoRule = MockitoJUnit.rule();
    //@PrepareForTest({DatabaseDAO.class})
    @Test
    public void testInstantiateClass()
    {
        /*
         * PowerMockito.mockStatic(DatabaseDAO.class);
         * when(DatabaseDAO.setupConnection()).thenReturn(databaseDAO);
         * OrionAuthorityModel orionAuthorityModel = new OrionAuthorityModel();
         * orionAuthorityModel.setUsername("MyUsername");
         * when(OrionAuthoritiesDAO.getAuthority("MyUsername")).thenReturn(
         * orionAuthorityModel); //databaseDAO.setDataSource(dataSource);
         * //databaseDAO.setJDBC(JDBC); assertEquals("MyUsername",
         * OrionAuthoritiesDAO.getAuthority("MyUsername").getUsername());
         */
    }
}