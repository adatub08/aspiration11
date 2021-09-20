package runners.api;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/default-cucumber-reports",
                "json:target/cucumber.json"},
        features = {
                "src/test/resources/features/api/starwarspeople.feature"
        },
        glue = {"Steps"},
        tags = {
                "@SwapiPeopleFeature"
        },
        dryRun = false
)
public class StarWarsPeopleTest {
}
