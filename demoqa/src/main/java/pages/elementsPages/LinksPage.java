package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage extends BasePage{


    private By links= By.id("item-5");
    private By homeLink=By.id("simpleLink");
    private By created=By.id("created");
    private By apiCall=By.id("linkResponse");

    public LinksPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    public void clickOnLinks(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,150)", "");
        getDriver().findElement(links).click();
    }

    public void clickOnHomeLink(){

        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        getDriver().findElement(homeLink).click();
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
        getDriver().findElement(created).click();
    }

    public String apiCallText(){
        return getDriver().findElement(apiCall).getText();
    }
}
