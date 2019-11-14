import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CreateIssuePage;
import utils.WebDriverFactory;

public class JiraLogin extends BaseTest {


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderData(){
        return new Object[][]{
                {"Karina_Soltanovskaya", "Karina"},
                {"Karina", "Karina_Soltanovskaya"},
        };
    }

    @Feature(" Unsuccessful Login Test")
    @Test(groups = {"Regression"},dataProvider="data-provider")
    public void  unsuccessfulLoginTest(String userName,String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.loginToJira(userName, password);
        Assert.assertEquals(loginPage.errorMassage(), "Sorry, your username and password are incorrect - please try again.");
    }

    @Feature("Login")
    @Test(groups = {"Regression"})
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.loginToJira("Karina_Soltanovskaya", "Karina_Soltanovskaya");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

    }

    @Feature("Issue")
    @Test(groups = {"Regression", "SKIP"})
    public void createIssue() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.loginToJira("Karina_Soltanovskaya", "Karina_Soltanovskaya");
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        CreateIssuePage newIssuePage = new CreateIssuePage();
        newIssuePage.clickCreateNewIssueButton();
        newIssuePage.enterProjectName("QAAUT-8");
        newIssuePage.enterIssueType("Test");
        newIssuePage.enterIssueSummary("Some Summary");
        newIssuePage.enterIssueDescription("Some Desc");
        newIssuePage.clickCreateIssue();

    }

}


