import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_407 extends BaseDriver {

    @Test
    public void patientDeletion() {
        US_401_404_407_POM locater = new US_401_404_407_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.userName));
        locater.userName.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.password));
        locater.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocations = (int) (Math.random() * locater.locations.size());
        String location = locater.locations.get(randomLocations).getText();

        wait.until(ExpectedConditions.elementToBeClickable(locater.locations.get(randomLocations)));
        locater.locations.get(randomLocations).click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.loginButton));
        locater.loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(locater.loginControl));
        Assert.assertTrue(locater.loginControl.getText().contains(location));

        wait.until(ExpectedConditions.visibilityOf(locater.adminControl));
        Assert.assertTrue(locater.adminControl.getText().contains("admin"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.findPatientButton));
        locater.findPatientButton.click();

        wait.until(ExpectedConditions.visibilityOf(locater.findPatientPageControl));
        Assert.assertTrue(locater.findPatientPageControl.getText().contains("Find Patient"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.searchBox));
        locater.searchBox.sendKeys(ConfigReader.getProperty("usernameSecond"));

        wait.until(ExpectedConditions.visibilityOf(locater.patientInformation));
        locater.patientInformation.click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.deletePatient));
        locater.deletePatient.click();

        wait.until(ExpectedConditions.visibilityOf(locater.deleteWindowControl));
        Assert.assertTrue(locater.deleteWindowControl.getText().contains("Delete Patient"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.reasonBox));
        locater.reasonBox.sendKeys(ConfigReader.getProperty("sampleReason"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.buttonConfirm));
        locater.buttonConfirm.click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.searchBox));
        locater.searchBox.sendKeys(ConfigReader.getProperty("usernameSecond"));

        wait.until(ExpectedConditions.visibilityOf(locater.noPatientsFound));
        Assert.assertTrue(locater.noPatientsFound.getText().contains("No matching"));
    }
}
