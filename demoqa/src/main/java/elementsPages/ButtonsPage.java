package elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage{

    private By elementsButton=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By buttonsFromMenu=By.xpath("//*[@id=\"item-4\"]");
    private By doubleClickButton=By.id("doubleClickBtn");
    private By rightClickButton=By.id("rightClickBtn");
    private By clickMeButton=By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");

    //messages after clicking
    private By doubleClickMessage=By.id("doubleClickMessage");
    private By rightClickMessage=By.id("rightClickMessage");
    private By dynamicClickMessage=By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    Actions a=new Actions(getDriver());


    public void clickElementsButton(){
        getDriver().findElement(elementsButton).click();
    }

    public void clickButtonsFromMenu(){

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,150)", "");
        getDriver().findElement(buttonsFromMenu).click();

    }
    public void clickDoubleclick(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(doubleClickButton));
        a.doubleClick(getDriver().findElement(doubleClickButton) ).perform();
    }

    public void clickRightClick(){
        a.contextClick(getDriver().findElement(rightClickButton)).perform();
    }

    public void clickButton(){
        a.click(getDriver().findElement(clickMeButton)).perform();
    }


    public void clickAll(){
        clickDoubleclick();
        clickRightClick();
        clickButton();
    }

    public String getMessageAfterDoubleClick(){
        return getDriver().findElement(doubleClickMessage).getText();
    }

    public String getMessageAfterRightClick(){
        return getDriver().findElement(rightClickMessage).getText();
    }

    public String getMessageAfterDynamicClick(){
        return getDriver().findElement(dynamicClickMessage).getText();
    }
}
