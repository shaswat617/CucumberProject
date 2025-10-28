package StepDefinitions;

import com.pages.LandingPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LandingPageSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private String landingPageActualTitle;


    @Given("User has already login access")
    public void userHasAlreadyLoginAccess(DataTable dataTable) {
        List<Map<String,String>> credentialList = dataTable.asMaps();
        String username = credentialList.get(0).get("username");
        String password = credentialList.get(0).get("password");

        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/");
        loginPage.doLogin(username,password);

    }

    @Given("user is on landing page")
    public void userIsOnLandingPage() {

    }

    @When("user gets the title of the landing page")
    public void userGetsTheTitleOfTheLandingPage() {
        landingPageActualTitle = landingPage.getLandingPageTitle();
        System.out.println("Landing page title is : " + landingPageActualTitle);
    }

    @Then("user gets different tabs")
    public void userGetsDifferentTabs(DataTable expectedTabsList) {
        List<String> actualTabsList = landingPage.getTabsList();
        System.out.println("Expected tabs list is : " + expectedTabsList);
        Assert.assertTrue(expectedTabsList.asList().containsAll(actualTabsList));
    }

    @And("landing page tab count is {int}")
    public void landingPageTabCountIs(Integer expectedTabsCount) {

        Integer actualTabsCount = landingPage.getTabsTotalCount();
        System.out.println("Number of tabs in Landing page : " + expectedTabsCount);
        Assert.assertEquals(actualTabsCount, expectedTabsCount);

    }

    @Then("title of the page should be {string}")
    public void titleOfThePageShouldBe(String expectedLandingPageTitle) {
        Assert.assertEquals(landingPageActualTitle, expectedLandingPageTitle);
    }

}
