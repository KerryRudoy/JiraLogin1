
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JiraLogin extends BaseTest {



    @Test
    public void loginTest() {
        this.driver.get("https://jira.hillel.it/login.jsp");
        driver.findElement(By.xpath("//input[@name='os_username']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='os_password']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }


    @Test
    public void createIssue() {
        this.driver.get("https://jira.hillel.it/login.jsp");
        driver.findElement(By.xpath("//input[@name='os_username']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='os_password']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        driver.findElement(By.id("create_link")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("project-field")));
        driver.findElement(By.id("issuetype-field"));
        driver.findElement(By.id("summary")).sendKeys("This is test");
        driver.findElement(By.xpath("//li[@data-mode='source']"));
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is test");
        driver.findElement(By.cssSelector("#create-issue-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='issue-created-key issue-link']")).isDisplayed());

    }


}
