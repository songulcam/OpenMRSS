import Pages.US_402_405_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_405 extends BaseDriver {

    @Test()
    public void myAccount() {
        US_402_405_POM element = new US_402_405_POM();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        do {
            if (!element.languageButton.getText().contains("EN")) {
                wait.until(ExpectedConditions.elementToBeClickable(element.languageButton));
                element.languageButton.click();

                wait.until(ExpectedConditions.visibilityOf(element.selectEnglish));
                MyFunc.jsClick(element.selectEnglish);
            }

        } while (!element.languageButton.getText().contains("EN"));

        wait.until(ExpectedConditions.elementToBeClickable(element.demoButton));
        element.demoButton.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL2")));
        MyFunc.scrollElement(element.enterOpenMRSDemo);
        wait.until(ExpectedConditions.visibilityOf(element.enterOpenMRSDemo));
        element.enterOpenMRSDemo.click();

        if (element.loginText.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(element.username));
            element.username.sendKeys(ConfigReader.getProperty("username2"));

            wait.until(ExpectedConditions.visibilityOf(element.password));
            element.password.sendKeys(ConfigReader.getProperty("password2"));

            element.lacationList.get(randomLacation()).click();

            wait.until(ExpectedConditions.elementToBeClickable(element.logInButton));
            element.logInButton.click();
        }

    }

    public static int randomLacation() {
        US_402_405_POM element = new US_402_405_POM();
        return (int) (Math.random() * element.lacationList.size());
    }
}
