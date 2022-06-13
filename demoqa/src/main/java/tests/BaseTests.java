package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import testPages.TextBoxPage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private TextBoxPage frontPage;

    public TextBoxPage getFrontPage() {
        return frontPage;
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        frontPage=new TextBoxPage(driver, driverWait);

        driver.navigate().to("https://demoqa.com/");
    }


}
