
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class JiraLogin {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kary\\JiraLogin1\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() {
        this.driver.get("https://jira.hillel.it/login.jsp");
        driver.findElement(By.xpath("//input[@name='os_username']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='os_password']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }
    @Test
    public void createIssue() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        driver.findElement(By.xpath("//input[@name='os_username']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='os_password']")).sendKeys("Karina_Soltanovskaya");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        driver.findElement(By.id("create_link")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("project-field"));
        driver.findElement(By.id("issuetype-field"));
        driver.findElement(By.id("summary")).sendKeys("This is test");
        driver.findElement(By.xpath("//li[@data-mode='source']"));
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is test");
        driver.findElement(By.cssSelector("#create-issue-submit")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='issue-created-key issue-link']")).isDisplayed());

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
