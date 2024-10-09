import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401 extends BaseDriver {

    @Test(dataProvider = "userData")
    public void checkingLoginErrorsSystem(String username, String password, boolean expectedResult) {
        US_401_404_407_POM locator = new US_401_404_407_POM();

        do {
            if (!locator.languageButton.getText().contains("EN")) {
                wait.until(ExpectedConditions.elementToBeClickable(locator.languageButton));
                locator.languageButton.click();

                wait.until(ExpectedConditions.visibilityOf(locator.languageEnglish));
                MyFunc.jsClick(locator.languageEnglish);
            }
        } while (!locator.languageButton.getText().contains("EN"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.demoButton));
        locator.demoButton.click();

        MyFunc.scrollElement(locator.exploreOpenMrs2);
        wait.until(ExpectedConditions.visibilityOf(locator.exploreOpenMrs2));
        locator.exploreOpenMrs2.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.enterOpenMrs2));
        locator.enterOpenMrs2.click();

        wait.until(ExpectedConditions.visibilityOf(locator.userName));
        locator.userName.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(locator.password));
        locator.password.sendKeys(password);

        if (expectedResult) {
            wait.until(ExpectedConditions.elementToBeClickable(locator.inpatientWard));
            locator.inpatientWard.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(locator.loginButton));
        locator.loginButton.click();

        if (!expectedResult) {
            Assert.assertTrue(locator.locationError.getText().contains("You must choose "));
        } else {
            Assert.assertTrue(locator.errorMessage.getText().contains("Please try again."));
        }

        if (!expectedResult){
            driver.get(ConfigReader.getProperty("URL"));
        }
    }

    @DataProvider
    public Object[][] userData() {
        Object[][] userPassword = {
                {"Ümmühan", "123457a", false},
                {"Merve", "12dd7a", false},
                {"Sefa", "1vvv57a", false},
                {"Kerim", "1xxx7a", false},
                {"Songül", "1abc7a", false},
                {"admin", "Admin12", true},
        };
        return userPassword;
    }
}