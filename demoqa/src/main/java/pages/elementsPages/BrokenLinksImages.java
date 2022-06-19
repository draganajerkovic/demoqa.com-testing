package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrokenLinksImages extends BasePage {


    private By brknLnkImg=By.xpath("//*[@id=\"item-6\"]");
    private By validLink = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a[1]");
    private By brokenLink = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a[2]");

    private By textBroken=By.xpath("//*[@id=\"content\"]/div");

    public BrokenLinksImages(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    //metoda za klik na opciju iz menija Broken links-Images
    public void clickOnBrokenLinksImages(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,250)", "");
        getDriver().findElement(brknLnkImg).click();
    }

    //klik na validan link
    public void clickValidLink(){
        getDriver().findElement(validLink).click();
    }

    //klik na broken link
    public void clickBrokenLink(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        getDriver().findElement(brokenLink).click();
    }

    //assertacija url validnog linka
    public String getUrl(){
        return getDriver().getCurrentUrl();
    }

    //tekst koji se pojavi na stranici kad se otvori broken link
    public String textAfterBrokenClick(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        return getDriver().findElement(textBroken).getText();
    }
}
