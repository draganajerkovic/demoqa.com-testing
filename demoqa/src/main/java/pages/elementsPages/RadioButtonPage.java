package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends BasePage{


    private By radioButtonMenu=By.id("item-2");
    private By yesRadio=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressiveRadio=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By noRadio=By.id("noRadio");

    private By messageYes=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");
    private By messageImpressive=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");


    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    //metode za klik na radio iz Elements menija
    public void chooseRadioFromMenu(){
        getDriver().findElement(radioButtonMenu).click();
    }

    //metoda za klik na yes button
    public void clickOnYes(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(yesRadio));
        getDriver().findElement(yesRadio).click();
    }

    //metoda za klik na impressive button
    public void clickOnImpressive(){
        getDriver().findElement(impressiveRadio).click();
    }



//asert metode za pojavu teksta nakon checkiranja dugmeta Yes
    public String yesMessage(){
        return getDriver().findElement(messageYes).getText();
    }

    // asert nakon checkiranja dugmeta Impressive
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
