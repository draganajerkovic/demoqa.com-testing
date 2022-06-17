package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage extends BasePage{

    private By checkBoxMenu=By.id("item-1");
    private By checkBox=By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    private By textResult=By.id("result");


    private By plus=By.xpath("//*[@id=\"tree-node\"]/div/button[1]");
    private By commands=By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label");

    public CheckBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    //metoda za klik opcije iz menija


    public void clickOnCheckBoxMenu(){
        getDriver().findElement(checkBoxMenu).click();
    }


    //metoda za klik na check box
    public void clickOnCheckBoxButton(){

       getDriverWait().until(ExpectedConditions.elementToBeClickable(checkBox));
        getDriver().findElement(checkBox).click();
    }


    //objedinjene metode
    public void completeClicks(){
//        clickElementsButton();
        clickOnCheckBoxMenu();
        clickOnCheckBoxButton();
    }

    //tekst koji se pojavi nakon klika na checkbox
    public String messageAfterClicking(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(textResult));
        return getDriver().findElement(textResult).getText();
    }


    //metode za izbor samo jedne opcije
    public void clickOnPlus(){
        getDriver().findElement(plus).click();
    }

    public void clickOnCommands(){
        getDriver().findElement(commands).click();
    }


}
