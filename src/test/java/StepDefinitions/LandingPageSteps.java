package StepDefinitions;

import com.pages.LandingPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LandingPageSteps {

    private LandingPage landingPage;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());



    @Given("User has already login access")
    public void userHasAlreadyLoginAccess(DataTable dataTable) {
        List<Map<String,String>> credentialList = dataTable.asMaps();
        String username = credentialList.get(0).get("username");
        String password = credentialList.get(0).get("password");

        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/login");
        landingPage = loginPage.doLogin(username,password);

    }

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        String title = landingPage.getLandingPageTitle();
        System.out.println("Landing page title : " + title);
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



}
