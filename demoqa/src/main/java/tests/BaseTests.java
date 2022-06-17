package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.elementsPages.*;

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
    private LinksPage linksPage;
    private BrokenLinksImages brokenLinksImages;
    private UploadAndDownload uploadAndDownload;
    private DynamicProperties dynamicProperties;
    private BasePage basePage;



    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        textBoxPage=new TextBoxPage(driver, driverWait);
        checkBoxPage=new CheckBoxPage(driver, driverWait);
        radioButtonPage=new RadioButtonPage(driver, driverWait);
        webTablesPage=new WebTablesPage(driver,driverWait);
        buttonsPage=new ButtonsPage(driver, driverWait);
        linksPage=new LinksPage(driver, driverWait);
        brokenLinksImages=new BrokenLinksImages(driver, driverWait);
        uploadAndDownload=new UploadAndDownload(driver,driverWait);
        dynamicProperties=new DynamicProperties(driver,driverWait);

        basePage=new BasePage(driver,driverWait);

    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://demoqa.com/");
        basePage.clickOnElements();
    }


}
