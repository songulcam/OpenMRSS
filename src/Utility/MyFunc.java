package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Utility.BaseDriver.driver;

public class MyFunc {
    public static void Wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void saveFileToDesktop(File fileInMemory){
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
        fileInMemory = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String desktop=System.getProperty("user.home")+"/Desktop";
        try {
            FileUtils.copyFile(fileInMemory,new File(desktop+"\\screenShot"+localDateTime.format(formater)+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //TODO: Bu class a DOKUNMAYINIZ!
}
