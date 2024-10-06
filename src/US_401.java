import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401 extends BaseDriver {

    @Test(dataProvider = "userData")
    public void checkingLoginErrorsSystem(String username, String password, boolean expectedResult) {

        US_401_404_407_POM locater = new US_401_404_407_POM();
        boolean isEnglishSelected = false;

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.elementToBeClickable(locater.languageButton));

        while (!isEnglishSelected) {
            MyFunc.jsClick(locater.languageButton);
            wait.until(ExpectedConditions.visibilityOf(locater.languageEnglish));
            MyFunc.jsClick(locater.languageEnglish);
            isEnglishSelected = checkEnglish();
            MyFunc.Wait(2);
        }

        wait.until(ExpectedConditions.elementToBeClickable(locater.demoButton));
        locater.demoButton.click();

        MyFunc.scrollElement(locater.exploreOpenMrs2);
        wait.until(ExpectedConditions.visibilityOf(locater.exploreOpenMrs2));
        locater.exploreOpenMrs2.click();
        wait.until(ExpectedConditions.elementToBeClickable(locater.enterOpenMrs2));
        locater.enterOpenMrs2.click();

        wait.until(ExpectedConditions.visibilityOf(locater.userName));
        locater.userName.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(locater.password));
        locater.password.sendKeys(password);

        locater.loginButton.click();
        MyFunc.Wait(1);

        if (!expectedResult) {
            Assert.assertTrue(locater.locationError.getText().contains("You must choose "));
        } else {
            Assert.assertTrue(locater.loginControl.getText().contains("Logged in as Super User "));
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
                {"admin", "Admin123", true},
        };
        return userPassword;
    }

    private boolean checkEnglish() {
        US_401_404_407_POM locater = new US_401_404_407_POM();
        try {
            WebElement demoEnglishText = wait.until(ExpectedConditions.visibilityOf(locater.demoButton));
            String text = demoEnglishText.getText().trim();
            return text.contains("Demo");
        } catch (TimeoutException e) {
            return false;
        }
    }
}