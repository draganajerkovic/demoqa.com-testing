package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class UploadAndDownload extends BasePage{


    private By uploadDownloadFromMenu=By.id("item-7");
    private By downloadButton=By.id("downloadButton");
    private By uploadButtton=By.id("uploadFile");
    private By textUpload=By.id("uploadedFilePath");

    File img=new File("sampleFile.jpeg");

    public void clickOnUpload(){
        getDriver().findElement(uploadButtton).sendKeys(img.getAbsolutePath());
    }

    public UploadAndDownload(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void clickOnUploadDOwnloadFromMenu(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,250)", "");
        getDriver().findElement(uploadDownloadFromMenu).click();
    }

    public String getTextAfterUpload(){
       return getDriver().findElement(textUpload).getText();
    }
}
