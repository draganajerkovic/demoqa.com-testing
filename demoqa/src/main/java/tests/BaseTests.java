package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ElementsPages.*;

import java.time.Duration;
@Getter
public class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private TextBoxPage textBoxPage;
    private CheckBoxPage checkBoxPage;
    private RadioButtonPage radioButtonPage;
    private WebTablesPage webTablesPage;
    private ButtonsPage buttonsPage;

//    public TextBoxPage getFrontPage() {
//        return frontPage;
//    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));


        textBoxPage=new TextBoxPage(driver, driverWait);
        checkBoxPage=new CheckBoxPage(driver, driverWait);
        radioButtonPage=new RadioButtonPage(driver, driverWait);
        webTablesPage=new WebTablesPage(driver,driverWait);
        buttonsPage=new ButtonsPage(driver, driverWait);

    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://demoqa.com/");
//        driver.navigate().refresh();
    }


}
