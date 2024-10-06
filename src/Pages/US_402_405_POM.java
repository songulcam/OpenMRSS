package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_402_405_POM extends BaseDriver {

    public US_402_405_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement languageButton;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement selectEnglish;

    @FindBy(partialLinkText = "Demo")
    public WebElement demoButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;

    @FindBy(xpath = "(//div[@class='elementor-button-wrapper'])[4]/a")
    public WebElement enterOpenMRSDemo;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement logInButton;

    @FindBy(id = "error-message")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loginControl;

    @FindBy(linkText = "My Account")
    public WebElement accountLink;
}
