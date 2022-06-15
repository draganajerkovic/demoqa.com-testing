package elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends BasePage{

    private By elementsButton=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By radioButtonMenu=By.id("item-2");
    private By yesRadio=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressiveRadio=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By noRadio=By.id("noRadio");

    private By messageYes=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");
    private By messageImpressive=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");


    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    //metode za klik na razlicite opcije

    public void clickElementsButton(){
        getDriver().findElement(elementsButton).click();
    }
    public void chooseRadioFromMenu(){
        getDriver().findElement(radioButtonMenu).click();
    }

    public void clickOnYes(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(yesRadio));
        getDriver().findElement(yesRadio).click();
    }

    public void clickOnImpressive(){
        getDriver().findElement(impressiveRadio).click();
    }

    public void clickOnNo(){
        getDriver().findElement(noRadio).click();
    }

//asert metode za pojavu teksta nakon checkiranja dugmeta
    public String yesMessage(){
        return getDriver().findElement(messageYes).getText();
    }

    public String impressiveMessage(){
        return getDriver().findElement(messageImpressive).getText();
    }

    //asert da NO nije clickable
    public boolean noNotClickable(){
        return getDriver().findElement(noRadio).isEnabled();
    }

    //assert da kad izaberemo yes drugo dugme nije izabrano
    public boolean impressiveNotSelectedWhenClickedOnYes(){
        return getDriver().findElement(impressiveRadio).isSelected();
    }

    //assert da kad izaberemo impressive drugo dugme nije izabrano
    public boolean yesNotSelectedWhenClickedOnImpressive(){
        return getDriver().findElement(yesRadio).isSelected();
    }
}
