package elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicProperties extends BasePage{

    private By elementsButton=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By dynamicElementsMenu=By.id("item-8");

    private By buttonEnableAfter5=By.id("enableAfter");
    private By buttonColorChange=By.id("colorChange");
    private By buttonVisibleAfter5=By.id("visibleAfter");
    public DynamicProperties(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnElements(){
        getDriver().findElement(elementsButton).click();
    }

    public void clickOnDynamicElementsFromMenu(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,450)", "");
        getDriver().findElement(dynamicElementsMenu).click();
    }

    public void clickOnButtonAfter5(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(buttonEnableAfter5));
        getDriver().findElement(buttonEnableAfter5).click();
    }

    public boolean assertClickAfter5(){
        return getDriver().findElement(buttonEnableAfter5).isEnabled();
    }

    // metoda koja potvrdjuje da se menja ime klase kad se promeni boja
    public String buttonChangeColors(){
        getDriverWait().until(ExpectedConditions.attributeContains(buttonColorChange,"class","mt-4 text-danger btn btn-primary"));
        return getDriver().findElement(buttonColorChange).getAttribute("class");
    }

    //metoda za button visible after 5 seconds
    public boolean clickOnButtonAfter5Seconds(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(buttonVisibleAfter5));
        return getDriver().findElement(buttonVisibleAfter5).isDisplayed();
    }
}
