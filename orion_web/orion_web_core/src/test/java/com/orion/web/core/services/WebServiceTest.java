package com.orion.web.core.services;

// @RunWith(SpringJUnit4ClassRunner.class)
/*
 * @ContextConfiguration(classes = {WebServiceTest.class})
 *
 * @TestInstance(Lifecycle.PER_CLASS)
 */
public class WebServiceTest
{
    /*private MockMvc mockMvc;
    @InjectMocks
    GreetingWebService greetingWebService;


    @BeforeAll
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(greetingWebService).build();
    }


    @Test
    public void testGetGreeting() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Greeting greeting = (Greeting)JSONService.convertJSONToObject(result.getResponse().getContentAsString(), new Greeting());
        assertEquals(HttpServletResponse.SC_OK, result.getResponse().getStatus());
        assertEquals(46, greeting.getId());
        assertEquals("Hello World", greeting.getContent());
    }*/
}