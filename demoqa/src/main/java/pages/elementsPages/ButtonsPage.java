package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsPage extends BasePage{


    private By buttonsFromMenu=By.xpath("//*[@id=\"item-4\"]");
    private By doubleClickButton=By.id("doubleClickBtn");
    private By rightClickButton=By.id("rightClickBtn");
    private By clickMeButton=By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");

    //messages after clicking
    private By doubleClickMessage=By.id("doubleClickMessage");
    private By rightClickMessage=By.id("rightClickMessage");
    private By dynamicClickMessage=By.id("dynamicClickMessage");

    private By googleAdd=By.xpath("/html/body/div[2]/div/div/div[2]/div");

    public ButtonsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    Actions a=new Actions(getDriver());



    public void clickButtonsFromMenu(){

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,150)", "");
        getDriver().findElement(buttonsFromMenu).click();

    }
    public void clickDoubleclick(){

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        a.doubleClick(getDriver().findElement(doubleClickButton) ).perform();
    }

    public void clickRightClick(){
//        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        getDriverWait().until(ExpectedConditions.elementToBeClickable(rightClickButton));
        a.contextClick(getDriver().findElement(rightClickButton)).perform();
    }

    public void clickButton(){
//        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
//        getDriverWait().until(ExpectedConditions.textToBe(clickMeButton,"Click Me"));
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
