package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinksPage extends BasePage{

    public String website="https://demoqa.com/";

    private By links= By.id("item-5");
    private By homeLink=By.id("simpleLink");
    private By created=By.id("created");
    private By apiCall=By.id("linkResponse");

    public LinksPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


// metoda za klik na links iz Elements opcije
    public void clickOnLinks(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,150)", "");
        getDriver().findElement(links).click();
    }


    // metoda za klik na Home link
    public void clickOnHomeLink(){

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().findElement(homeLink).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    //ispitivanje da li je novi tab odvojen
    public String assertNewTabOpen() {
        String currentWindow = getDriver().getWindowHandle();
        getDriverWait().until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!currentWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);

            }
        }
        return getDriver().getCurrentUrl();
    }

    //ispitivanje da li linkovi salju api call
    public void clickOnCreate(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        getDriver().findElement(created).click();
        getDriverWait().until(ExpectedConditions.textToBe(apiCall,"Link has responded with staus 201 and status text Created"));
    }

    // text koji se pojavi nakon poslatog api call
    public String apiCallText(){
        return getDriver().findElement(apiCall).getText();
    }
}
