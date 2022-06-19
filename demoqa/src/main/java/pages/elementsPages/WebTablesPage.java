package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTablesPage extends BasePage{


    private By webTablesMenu=By.id("item-3");
    private By addButton=By.id("addNewRecordButton");

    //registration form elements//
    private By firstName=By.id("firstName");
    private By lastName=By.id("lastName");
    private By email=By.id("userEmail");
    private By age=By.id("age");
    private By salary=By.id("salary");
    private By department=By.id("department");

    private By submitButton=By.id("submit");

    private By newTableRow=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div");




    public WebTablesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


// izbor opcije Web tables iz Elements menija
    public void clickOnWebTablesMenu(){
        getDriver().findElement(webTablesMenu).click();
    }

    //klik na Add button
    public void clickOnAddButton(){
        getDriver().findElement(addButton).click();
    }

    // metode za pojedinacno popunjavanje podataka
    public void fillInFirstName(String name){

        getDriver().findElement(this.firstName).sendKeys(name);
    }

    public void fillInLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void fillInEmail(String email){
        getDriver().findElement(this.email).sendKeys(email);
    }

    public void fillInAge(String age){
        getDriver().findElement(this.age).sendKeys(age);
    }

    public void fillInSallary(String salary){
        getDriver().findElement(this.salary).sendKeys(salary);
    }

    public void fillInDepartment(String department){
        getDriver().findElement(this.department).sendKeys(department);
    }


    // metoda za popunjavanje svih podataka zajedno
    public void fillInAll(String firstName, String lastName, String email, String age,String salary, String department){
        fillInFirstName(firstName);
        fillInLastName(lastName);
        fillInEmail(email);
        fillInAge(age);
        fillInSallary(salary);
        fillInDepartment(department);
    }


    //klik na dugme submit
    public void clickSubmit(){
        getDriver().findElement(submitButton).click();
    }

    // asert da postoji novi unos u tabeli sa izabranim podacima
    public String textNewTableRow(){
        return getDriver().findElement(newTableRow).getText();
    }



}
