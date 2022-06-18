package pages.elementsPages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends  BasePage{

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



    public void clickTextBoxFromMenu(){
        getDriver().findElement(textBoxMenu).click();
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


    public void allData(String name, String email, String cAddress, String pAddress){
        enterFirstName(name);
        enterEmail(email);
        enterCurrentAddress(cAddress);
        enterPermanentAddress(pAddress);
        clickSubmit();
    }

    // metode za ispitivanje da li se unet tekst iz svih polja pojavljuje nakon submit button click
    public String nameSummary(){
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[1]")).getText();
    }

    public String emailSummary(){
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[2]")).getText();
    }

    public String currentAddressSummary(){
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
    }

    public String permanentAddressSummary(){
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")).getText();
    }


}
