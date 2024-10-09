import Pages.US_403_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_410 extends BaseDriver {

    @Test
    public void Test1() {
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

        wait.until(ExpectedConditions.elementToBeClickable(element.appointmentSchedulingBtn));
        element.appointmentSchedulingBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.manageAppointmentsBtn));
        element.manageAppointmentsBtn.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("manageAppointmentsURL")));
        element.searchById.sendKeys("100JK4"); // burası dinamik bir şekilde gelen 409 ve ya 404 den alınacak ID eklenecek

        wait.until(ExpectedConditions.visibilityOf(element.patientSearchResult));
        element.patientSearchResult.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("appointmentRequestsURL")));
        Assert.assertTrue(element.timeZoneWarning.getText().contains("Your computer is not set to the right time zone"));
    }
}
