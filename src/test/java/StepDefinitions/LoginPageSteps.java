package StepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.util.Asserts;
import org.junit.Assert;

public class LoginPageSteps {

    private static String actualTitle;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get("url");
    }


    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("user enters username {string}")
    public void userEntersUsername(String string) {
        loginPage.enterUsername(string);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String string) {
        loginPage.enterPassword(string);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("user gets the title of the web page")
    public void userGetsTheTitleOfTheWebPage() {
        actualTitle = loginPage.getLoginPageTitle();
        System.out.println("Login page title is : " + actualTitle);
    }

    @Then("forgot your password link should be displayed")
    public void forgotYourPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
    }
}
