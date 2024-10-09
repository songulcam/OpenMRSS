import Pages.US_403_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_409 extends BaseDriver {
// idlerin locaterı //div[@id='patient-search-results']//td[starts-with(text(),'100')]
    @Test(groups = "Regression Test")
    public void patientMerge(){
        US_403_409_410_POM element = new US_403_409_410_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("loginURL")));
        wait.until(ExpectedConditions.elementToBeClickable(element.username));
        element.username.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(element.password));
        element.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocation = (int) (Math.random() * element.locations.size());
        String keyWordStr = element.locations.get(randomLocation).getText();

        wait.until(ExpectedConditions.elementToBeClickable(element.locations.get(randomLocation)));
        element.locations.get(randomLocation).click();

        wait.until(ExpectedConditions.elementToBeClickable(element.logInBtn));
        element.logInBtn.click();
        Assert.assertTrue(element.logInControl.getText().contains(keyWordStr));

    }
}
