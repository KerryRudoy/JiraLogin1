import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CreateIssuePage;
import utils.WebDriverFactory;

public class JiraLogin extends BaseTest {

    @Feature("Login")
    @Test(groups = {"Regression"})
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.loginToJira("webinar5", "webinar5");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
        Assert.assertTrue(1 == 1);
    }

    @Feature("Issue")
    @Test(groups = {"Regression", "SKIP"})
    public void createIssue() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.loginToJira("webinar5", "webinar5");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        CreateIssuePage newIssuePage = new CreateIssuePage();
        newIssuePage.clickCreateNewIssueButton();
        newIssuePage.enterProjectName("QAAUT-8");
        newIssuePage.enterIssueType("Test");
        newIssuePage.enterIssueSummary("Some Summary");
        newIssuePage.enterIssueDescription("Some Desc");
        newIssuePage.clickCreateIssue();

    }

    @Feature("Issue")
    @Test(groups = {"Regression", "SKIP"})
    public void testToBeSkipped() throws InterruptedException {

    }
}


