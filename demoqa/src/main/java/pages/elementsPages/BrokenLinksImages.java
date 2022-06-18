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



    public void clickOnBrokenLinksImages(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,250)", "");
        getDriver().findElement(brknLnkImg).click();
    }
    public void clickValidLink(){
        getDriver().findElement(validLink).click();
    }

    public void clickBrokenLink(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        getDriver().findElement(brokenLink).click();
    }

    public String getUrl(){
        return getDriver().getCurrentUrl();
    }

    public String textAfterBrokenClick(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        return getDriver().findElement(textBroken).getText();
    }
}
