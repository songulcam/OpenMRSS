package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_403_409_410_POM {

    public US_403_409_410_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement languageBtn;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement languageEn;

    @FindBy(css = "[class='zak-button']")
    public WebElement demoBtn;

    @FindBy(xpath = "(//div[@class='elementor-button-wrapper'])[4]/a")
    public WebElement OpenMRS2DemoBtn;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//ul[@id='sessionLocation']/li")
    public List<WebElement> locations;

    @FindBy(id = "loginButton")
    public WebElement logInBtn;

    @FindBy(css = "[id='content'] h4")
    public WebElement logInControl;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOutBtn;
}
