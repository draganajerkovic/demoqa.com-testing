package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends BaseTests{
    @Test(priority = 1)
    public void textBoxTest(){
        getTextBoxPage().clickTextBoxFromMenu();
        getTextBoxPage().allData("Marko","bla@gmail.com","Morocco","Seychelles");
        getTextBoxPage().clickSubmit();
        Assert.assertEquals(getTextBoxPage().nameSummary(),"Name:Marko");
        Assert.assertEquals(getTextBoxPage().emailSummary(),"Email:bla@gmail.com");
        Assert.assertEquals(getTextBoxPage().currentAddressSummary(),"Current Address :Morocco");
        Assert.assertEquals(getTextBoxPage().permanentAddressSummary(),"Permananet Address :Seychelles");
    }

    @Test(priority = 2)
    public void allCheckBoxTest(){
        getCheckBoxPage().completeClicks();
        Assert.assertEquals(getCheckBoxPage().messageAfterClicking(),"You have selected :\n"+"home\n" +
                "desktop\n"+"notes\n"+"commands\n"+"documents\n"+"workspace\n"+"react\n"+"angular\n"+"veu\n" +
                "office\n"+"public\n"+"private\n"+"classified\n"+"general\n"+"downloads\n"+"wordFile\n"+"excelFile");
    }

    @Test(priority = 3)
    public void oneCheckBoxTest(){
        getCheckBoxPage().clickOnCheckBoxMenu();
        getCheckBoxPage().clickOnPlus();
        getCheckBoxPage().clickOnCommands();
        Assert.assertEquals(getCheckBoxPage().messageAfterClicking(),"You have selected :\n" + "commands");
    }

    @Test(priority = 4)
    public void radioButtonTest(){
        getRadioButtonPage().chooseRadioFromMenu();
        getRadioButtonPage().clickOnYes();
        Assert.assertEquals(getRadioButtonPage().yesMessage(), "You have selected Yes");
        Assert.assertFalse(getRadioButtonPage().impressiveNotSelectedWhenClickedOnYes());
        getRadioButtonPage().clickOnImpressive();
        Assert.assertEquals(getRadioButtonPage().impressiveMessage(),"You have selected Impressive");
        Assert.assertFalse(getRadioButtonPage().yesNotSelectedWhenClickedOnImpressive());
        Assert.assertFalse(getRadioButtonPage().noNotClickable());
    }

    @Test(priority = 5)
    public void addToWebTablesTest(){
        getWebTablesPage().clickOnWebTablesMenu();
        getWebTablesPage().clickOnAddButton();
        getWebTablesPage().fillInAll("David","Budd","db@gmail.com","35","10000","security");
        getWebTablesPage().clickSubmit();
        Assert.assertEquals(getWebTablesPage().textNewTableRow(),"David\n"+"Budd\n"+"35\n"+"db@gmail.com\n"+"10000\n"+"security");
    }



    @Test(priority = 6)
    public void allButtonsTest(){
            getButtonsPage().clickButtonsFromMenu();
            getButtonsPage().clickAll();
            Assert.assertEquals(getButtonsPage().getMessageAfterDoubleClick(),"You have done a double click");
            Assert.assertEquals(getButtonsPage().getMessageAfterRightClick(),"You have done a right click");
            Assert.assertEquals(getButtonsPage().getMessageAfterDynamicClick(),"You have done a dynamic click");
    }



    @Test(priority = 7)
    public void linksNewTabTest(){

        getLinksPage().clickOnLinks();
        getLinksPage().clickOnHomeLink();
        Assert.assertEquals(getLinksPage().assertNewTabOpen(),getLinksPage().website);
    }


    @Test(priority = 8)
    public void linksApiTest(){
        getLinksPage().clickOnLinks();
        getLinksPage().clickOnCreate();
        Assert.assertEquals(getLinksPage().apiCallText(),"Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 9)
    public void validLinkTest(){
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickValidLink();
        Assert.assertEquals(getBrokenLinksImages().getUrl(),getLinksPage().website);
    }


    @Test(priority = 10)
    public void brokenLinkTest(){
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickBrokenLink();
        Assert.assertEquals(getBrokenLinksImages().textAfterBrokenClick(),"Status Codes\n" +
                "This page returned a 500 status code.\n" + "\n" +
                "For a definition and common list of HTTP status codes, go here");
    }



    @Test(priority = 11)
    public void uploadTest(){
        getUploadAndDownload().clickOnUploadDownloadFromMenu();
        getUploadAndDownload().clickOnUpload();
        Assert.assertEquals(getUploadAndDownload().getTextAfterUpload(),"C:\\fakepath\\sampleFile.jpeg");
    }

    @Test(priority = 12)
    public void firstButtonEnabledAfter5Seconds(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        getDynamicProperties().clickOnButtonAfter5();
        Assert.assertTrue(getDynamicProperties().assertClickAfter5());
    }

    @Test(priority = 13)
    public void secondButtonChangedColor(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertEquals(getDynamicProperties().buttonChangeColors(),"mt-4 text-danger btn btn-primary");
    }

    @Test(priority = 14)
    public void thridButtonVisibleAfter5Seconds(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertTrue(getDynamicProperties().clickOnButtonAfter5Seconds());
    }


    @Test(priority = 15)
    public void firstButtonDisabledRightAway(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertFalse(getDynamicProperties().assertClickAfter5());
    }

    @Test(priority = 16)
    public void secondButtonDoesNotChangeColorRightAway(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertEquals(getDynamicProperties().buttonDoesNotChangeColor(),"mt-4 btn btn-primary");
    }
}


