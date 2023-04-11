package com.orion.glue.data_user.address;

import static org.junit.Assert.assertTrue;

import com.orion.data.user.address.UserAddressService;
import com.orion.data.user.address.model.OrionUserAddressModel;
import com.orion.testing.cucumber.CucumberService;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class UserAddressServiceSteps
{
    private final CucumberStepsWorld stepsWorld;
    private OrionUserAddressModel address;


    public UserAddressServiceSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @Given("^user address$")
    public void givenUserAddress(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);
        String houseAddressLine1 = null;
        String postcode = null;
        String city = null;
        //stepsWorld.resetForNewScenarioRun();

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "field-names");
            String value = CucumberService.getCellValue(row, "values");

            if("houseAddressLine1".equals(key))
            {
                houseAddressLine1 = value;
            }

            if("postcode".equals(key))
            {
                postcode = value;
            }

            if("city".equals(key))
            {
                city = value;
            }

        }

        address = OrionUserAddressModel.builder()
                        .houseAddressLine1(houseAddressLine1)
                        .postcode(postcode)
                        .city(city)
                        .build();
    }


    @Then("^is user address valid$")
    public void thenIsUserAddressValid()
    {
        assertTrue(UserAddressService.isValidAddress(address));
    }


    @Then("^is user address invalid$")
    public void thenIsUserAddressInvalid()
    {
        assertTrue(UserAddressService.isInvalidAddress(address));
    }
    /*@Then("^number of user addresses for userID \"(.*)\" is (\\d+)$")
    public void thenNumberOfUserAddressesForUserIDIs(String userID, long expectedNumberOfAddresses)
    {
        Mockito.mockStatic(UserAddressService.class);
        when(UserAddressService.getNumberOfUserAddressesbyUserID("")).thenReturn(expectedNumberOfAddresses);
        assertEquals(expectedNumberOfAddresses, UserAddressService.getNumberOfUserAddressesbyUserID(""));
    }*/
}