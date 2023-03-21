package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.DetailDocumentationPage;
import page.HomePage;

public class HomeSteps {

    private final HomePage homePage;
    private final DetailDocumentationPage detailDocumentationPage;

    public HomeSteps(TestContext testContext) {
        homePage = new HomePage(testContext);
        detailDocumentationPage = new DetailDocumentationPage(testContext);
    }

    @Given("the user is already on the Microcks page")
    public void theUserIsAlreadyOnTheLoginPage() {
        Assert.assertTrue(homePage.isUserAlreadyOnTheHomePage());
    }

    @When("the user search {string} in the documentation")
    public void theUserSearchInTheDocumentation(String keyword) {
        homePage.searchDocumentation(keyword);
    }

    @And("the user click {string} documentation on the list")
    public void theUserClickDocumentationOnTheList(String documentationTitle) {
        homePage.clickDocumentationListBasedOnTitle(documentationTitle);
    }

    @Then("the user should navigate to the {string} documentation page")
    public void theUserShouldNavigateToTheCorrectDocumentationPage(String documentationTitle) {
        Assert.assertEquals(documentationTitle, detailDocumentationPage.getHeaderDocumentTitle());
    }

    @And("the URL should be correct")
    public void theURLShouldBeCorrect() {
        Assert.assertEquals(homePage.getWebDriver().getCurrentUrl(), "https://microcks.io/documentation/guides/nats-support/");
    }
}
