package Steps.api.starwarpeople;

import Steps.api.common.CommonData;
import api.pojos.SWPeople;
import api.pojos.SWPerson;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import utilities.helper.api.ObjectConverter;
import utilities.ui.ConfigsReader;

import java.util.Arrays;
import java.util.List;

public class StarWarsPeopleSteps {
    private static final Logger LOGGER = LogManager.getLogger(StarWarsPeopleSteps.class);

    private CommonData commonData;
    private SWPeople peopleObject;

    public StarWarsPeopleSteps(CommonData commonData) {
        this.commonData = commonData;
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = ConfigsReader.getProperty("apiBaseUrl");
    }

    @When("^all people are requested$")
    public void all_people_are_requested() throws Throwable {
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);

        LOGGER.info("GET " + ConfigsReader.getProperty("apiBaseUrl") + "/people");
        commonData.response = requestSpec.get("/people");
    }

    @Then("^total (\\d+) peoples are returned$")
    public void total_peoples_are_returned(int totalAmount) throws Throwable {
        peopleObject = ObjectConverter.convertJsonObjectToJavaObject(commonData.response.getBody().asString(), SWPeople.class);

        MatcherAssert.assertThat(peopleObject.getCount(), Matchers.is(totalAmount));


    }

    @Then("^total number of people where height is greater than (\\d+) equals to (\\d+)$")
    public void total_number_of_people_where_height_is_greater_than_equals_to(int w200height, int actual10height) throws Throwable {
        int result = 0;
        for (int i = 0; i < peopleObject.getResults().size(); i++) {
            if (Integer.parseInt(peopleObject.getResults().get(i).getHeight()) > w200height) {
                result++;
            }
        }
        MatcherAssert.assertThat(result, Matchers.is(actual10height));
    }

    @And("^\"([^\"]*)\" are returned$")
    public void are_returned(String individuals) throws Throwable {

        List<String> people = Arrays.asList("Luke Skywalker", "C-3PO", "R2-D2", "Darth Vader", "Leia Organa", "Owen Lars", "Beru Whitesun lars", "R5-D4", "Biggs Darklighter", "Obi-Wan Kenobi");


        for (int i = 0; i < people.size(); i++) {

            MatcherAssert.assertThat(peopleObject.getResults().get(i).getName(), Matchers.is(people.get(i)));
        }
    }
}




