package elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage extends BasePage{

    private By elementsButton=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By links= By.id("item-5");
    private By homeLink=By.id("simpleLink");
    private By created=By.id("created");
    private By apiCall=By.id("linkResponse");

    public LinksPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void clickOnElements(){
        getDriver().findElement(elementsButton).click();
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
    public String assertNewTabOpen(){
        getDriverWait().until(ExpectedConditions.numberOfWindowsToBe(2));
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/"));
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
