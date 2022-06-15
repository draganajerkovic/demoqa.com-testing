package elementsPages;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@Data @AllArgsConstructor
public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;


}
