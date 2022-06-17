package pages.elementsPages;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@Data @AllArgsConstructor
public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public void clickOnElements(){
        getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
    }

}
