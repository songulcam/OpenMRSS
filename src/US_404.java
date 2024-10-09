import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class US_404 extends BaseDriver {
    public String patientID;

    @Test
    public void patientRegistration() {
        US_401_404_407_POM locater = new US_401_404_407_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

        wait.until(ExpectedConditions.visibilityOf(locater.userName));
        locater.userName.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.visibilityOf(locater.password));
        locater.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocation = (int) (Math.random() * locater.locations.size());
        String selectLocation = locater.locations.get(randomLocation).getText();

        wait.until(ExpectedConditions.elementToBeClickable(locater.locations.get(randomLocation)));
        locater.locations.get(randomLocation).click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.loginButton));
        locater.loginButton.click();
        Assert.assertTrue(locater.loginControl.getText().contains(selectLocation));

        wait.until(ExpectedConditions.elementToBeClickable(locater.registerButton));
        locater.registerButton.click();
        Assert.assertTrue(locater.nextButton.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(locater.givenButton));
        locater.givenButton.sendKeys(ConfigReader.getProperty("given"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.middleButton));
        locater.middleButton.sendKeys(ConfigReader.getProperty("middle"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.familyNameButton));
        locater.familyNameButton.sendKeys(ConfigReader.getProperty("familyName"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        Select gender = new Select(locater.selectMenu);
        gender.selectByValue("F");

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.birthdateDay));
        locater.birthdateDay.sendKeys(ConfigReader.getProperty("birthday"));

        Select month = new Select(locater.birtdateMonth);
        wait.until(ExpectedConditions.elementToBeClickable(locater.birtdateMonth));
        month.selectByIndex((int) (Math.random() * 11));

        wait.until(ExpectedConditions.elementToBeClickable(locater.birtdateYear));
        locater.birtdateYear.sendKeys(ConfigReader.getProperty("birthYear"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.address));
        locater.address.sendKeys(ConfigReader.getProperty("address"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.city));
        locater.city.sendKeys(ConfigReader.getProperty("city"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.state));
        locater.state.sendKeys(ConfigReader.getProperty("state"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.country));
        locater.country.sendKeys(ConfigReader.getProperty("country"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.postalCode));
        locater.postalCode.sendKeys(ConfigReader.getProperty("postalCode"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        long random = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
        String phoneNumber = String.valueOf(random);
        wait.until(ExpectedConditions.elementToBeClickable(locater.phoneNumber));
        locater.phoneNumber.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        Select relationship = new Select(locater.selectRelatives);
        relationship.selectByIndex((int) (Math.random() * 9));

        wait.until(ExpectedConditions.elementToBeClickable(locater.personName));
        locater.personName.sendKeys(ConfigReader.getProperty("personName"));

        wait.until(ExpectedConditions.elementToBeClickable(locater.nextButton));
        locater.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locater.confirmButton));
        locater.confirmButton.click();

        wait.until(ExpectedConditions.visibilityOf(locater.givenControl));
        Assert.assertTrue(locater.givenControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locater.familyNameControl));
        Assert.assertTrue(locater.familyNameControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locater.IDcontrol));
        patientID=locater.IDcontrol.getText();
        Assert.assertTrue(locater.IDcontrol.isDisplayed());
    }
}
