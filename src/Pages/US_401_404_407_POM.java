package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_401_404_407_POM {

    public US_401_404_407_POM(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath="//span[text()='tr']")
    public WebElement languageButton;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement languageEnglish;

    @FindBy(css = "[class='zak-button']")
    public WebElement demoButton;

    @FindBy(xpath = "//*[.='Explore OpenMRS 2']")
    public WebElement exploreOpenMrs2;

    @FindBy(xpath = "//*[.='Enter the OpenMRS 2 Demo']")
    public WebElement enterOpenMrs2;

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="loginButton")
    public WebElement loginButton;

    @FindBy(id = "error-message")
    public WebElement errorMessage;

    @FindBy(id = "sessionLocationError")
    public WebElement locationError;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loginControl;

}
