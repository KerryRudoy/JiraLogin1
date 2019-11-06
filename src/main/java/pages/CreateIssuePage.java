package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

    public class CreateIssuePage {

        WebDriver driver;
        Utilities utilities;

        // Create Issue
        private By createIssueButton = By.id("create_link");
        private By projectInput = By.cssSelector("#project-field");
        private By issueTypeInput = By.id("issuetype-field");
        private By summaryInput = By.id("summary");
        private By dataModeSource = By.xpath("//li[@data-mode='source']");
        private By descriptionInput = By.xpath("//textarea[@name='description']");
        private By createButton = By.cssSelector("#create-issue-submit");
        private By issueSuccessfullyCreated = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");


        public CreateIssuePage() {
            this.driver = WebDriverFactory.getDriver();
            utilities = new Utilities(driver);
        }

        public void clickCreateNewIssueButton() {
            utilities.click(createIssueButton, 3, 3);
        }

        public void enterProjectName(String name) {
            utilities.enterText(projectInput, "QAAUTO-8", 3, 3);
        }

        public void enterIssueType(String type) {
            utilities.enterText(issueTypeInput, type, 3, 3);
        }

        public void enterIssueSummary(String text) {
            utilities.enterText(summaryInput, text, 3, 3);
        }

        public void enterIssueDescription(String text) {
            driver.findElement(dataModeSource);
            utilities.enterText(descriptionInput, text, 3, 3);
        }

        public void clickCreateIssue() {
            utilities.click(createButton, 3, 3);
        }

        public boolean issueCreatedPopupIsPresent() {
            return utilities.waitFor(issueSuccessfullyCreated, 3, 3).isDisplayed();
        }

    }
