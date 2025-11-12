package StepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private static String actualTitle;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/login");
    }


    @Then("title of the page should be {string}")
    public void titleOfThePageShouldBe(String expectedTitle) {
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

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        actualTitle = loginPage.getLoginPageTitle();
        System.out.println("Login page title is : " + actualTitle);
    }

    @Then("forgot your password link should be displayed")
    public void forgotYourPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
    }
}
