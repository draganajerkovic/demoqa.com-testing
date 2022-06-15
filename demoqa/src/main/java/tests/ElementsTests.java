package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends BaseTests{
    @Test(priority = 1)
    public void textBoxTest(){
        getTextBoxPage().getToForm();
        getTextBoxPage().allData("Marko","bla@gmail.com","Morocco","Seychelles");
        getTextBoxPage().clickSubmit();
        Assert.assertTrue(getTextBoxPage().allSummary());
    }

    @Test(priority = 2)
    public void checkBoxTest(){
        getCheckBoxPage().completeClicks();
        Assert.assertEquals(getCheckBoxPage().messageAfterClicking(),"You have selected :\n"+"home\n" +
                "desktop\n"+"notes\n"+"commands\n"+"documents\n"+"workspace\n"+"react\n"+"angular\n"+"veu\n" +
                "office\n"+"public\n"+"private\n"+"classified\n"+"general\n"+"downloads\n"+"wordFile\n"+"excelFile");
    }

    @Test(priority = 3)
    public void radioButtonTest(){
        getRadioButtonPage().clickElementsButton();
        getRadioButtonPage().chooseRadioFromMenu();
        getRadioButtonPage().clickOnYes();
        Assert.assertEquals(getRadioButtonPage().yesMessage(), "You have selected Yes");
        getRadioButtonPage().clickOnImpressive();
        Assert.assertEquals(getRadioButtonPage().impressiveMessage(),"You have selected Impressive");
        Assert.assertFalse(getRadioButtonPage().noNotClickable());
    }

    @Test(priority = 4)
    public void webTablesTest(){
        getWebTablesPage().clickElementsButton();
        getWebTablesPage().clickOnWebTablesMenu();
        getWebTablesPage().clickOnAddButton();
        getWebTablesPage().fillInAll("David","Budd","db@gmail.com","35","10000","security");
        getWebTablesPage().clickSubmit();
        Assert.assertEquals(getWebTablesPage().textNewTableRow(),"David\n"+"Budd\n"+"35\n"+"db@gmail.com\n"+"10000\n"+"security");
    }

    @Test(priority = 5)
    public void buttonsTest(){
        getButtonsPage().clickElementsButton();
        getButtonsPage().clickButtonsFromMenu();
        getButtonsPage().clickAll();
        Assert.assertEquals(getButtonsPage().getMessageAfterDoubleClick(),"You have done a double click");
        Assert.assertEquals(getButtonsPage().getMessageAfterRightClick(),"You have done a right click");
        Assert.assertEquals(getButtonsPage().getMessageAfterDynamicClick(),"You have done a dynamic click");
    }
}
