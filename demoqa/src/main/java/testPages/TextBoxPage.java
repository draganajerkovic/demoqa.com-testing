package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class TextBoxPage extends  BasePage{
    private By elementsButton=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By textBoxMenu=By.id("item-0");

    private By firstName=By.id("userName");
    private By email=By.id("userEmail");

    private By currentAddress=By.id("currentAddress");

    private By permanentAddress=By.id("permanentAddress");
    private By submitButton=By.id("submit");

    //elementi za proveru posle submit button click

    private By sumarryName=By.id("name");
    private By summaryEmail=By.id("email");

    private By summaryCAddress=By.id("currentAddress");


    public TextBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickElementsButton(){
        getDriver().findElement(elementsButton).click();
    }

    public void clickTextBoxFromMenu(){
        getDriver().findElement(textBoxMenu).click();
    }

    public void getToForm(){
        clickElementsButton();
        clickTextBoxFromMenu();
    }

    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterEmail(String email){
        getDriver().findElement(this.email).sendKeys(email);
    }

    public void enterCurrentAddress(String address){
        getDriver().findElement(this.currentAddress).sendKeys(address);
    }

    public void enterPermanentAddress(String permanentAddress){
        getDriver().findElement(this.permanentAddress).sendKeys(permanentAddress);
    }

    public void clickSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,350)", "");
        getDriver().findElement(submitButton).click();
    }


    // metode za ispitivanje da li se unet tekst iz svih polja pojavljuje nakon submit button click
    public boolean nameSummary(){
        return getDriver().findElement(By.id("output")).getText().contains(getDriver().findElement(firstName).getText());
    }

    public boolean emailSummary(){
        return getDriver().findElement(By.id("output")).getText().contains(getDriver().findElement(email).getText());
    }

    public boolean currentAddressSummary(){
        return getDriver().findElement(By.id("output")).getText().contains(getDriver().findElement(currentAddress).getText());
    }

    public boolean permanentAddressSummary(){
        return getDriver().findElement(By.id("output")).getText().contains(getDriver().findElement(permanentAddress).getText());
    }

    public boolean allSummary(){
        if(nameSummary() && emailSummary() && currentAddressSummary() && permanentAddressSummary()) {
            return true;
        }
        return false;
    }
}
