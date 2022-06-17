package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends BaseTests{
    @Test(priority = 1)
    public void textBoxTest(){
        getTextBoxPage().clickTextBoxFromMenu();
        getTextBoxPage().allData("Marko","bla@gmail.com","Morocco","Seychelles");
        getTextBoxPage().clickSubmit();
        Assert.assertTrue(getTextBoxPage().allSummary());
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
    public void webTablesTest(){
        getWebTablesPage().clickOnWebTablesMenu();
        getWebTablesPage().clickOnAddButton();
        getWebTablesPage().fillInAll("David","Budd","db@gmail.com","35","10000","security");
        getWebTablesPage().clickSubmit();
        Assert.assertEquals(getWebTablesPage().textNewTableRow(),"David\n"+"Budd\n"+"35\n"+"db@gmail.com\n"+"10000\n"+"security");
    }

    @Test(priority = 9)
    public void buttonsDoubleClickTest(){
        getButtonsPage().clickButtonsFromMenu();
        getButtonsPage().clickDoubleclick();
        Assert.assertEquals(getButtonsPage().getMessageAfterDoubleClick(),"You have done a double click");
    }

    @Test(priority = 10)
    public void buttonsRightClickTest(){
        getButtonsPage().clickButtonsFromMenu();
        getButtonsPage().clickRightClick();
        Assert.assertEquals(getButtonsPage().getMessageAfterRightClick(),"You have done a right click");
    }

    @Test(priority = 11)
    public void buttonsRegularClickTest(){
        getButtonsPage().clickButtonsFromMenu();
        getButtonsPage().clickButton();
        Assert.assertEquals(getButtonsPage().getMessageAfterDynamicClick(),"You have done a dynamic click");
    }



    @Test(priority = 12)
    public void linksNewTabTest(){

        getLinksPage().clickOnLinks();
        getLinksPage().clickOnHomeLink();
        Assert.assertEquals(getLinksPage().assertNewTabOpen(),"https://demoqa.com/");
    }


    @Test(priority = 13)
    public void linksApiTest(){
        getLinksPage().clickOnLinks();
        getLinksPage().clickOnCreate();
        Assert.assertEquals(getLinksPage().apiCallText(),"Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 14)
    public void validLinkTest(){
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickValidLink();
        Assert.assertEquals(getBrokenLinksImages().getUrl(),"https://demoqa.com/");
    }


    @Test(priority = 15)
    public void brokenLinkTest(){
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickBrokenLink();
        Assert.assertEquals(getBrokenLinksImages().textAfterBrokenClick(),"Status Codes\n" +
                "This page returned a 500 status code.\n" + "\n" +
                "For a definition and common list of HTTP status codes, go here");
    }
//test za download

//    @Test(priority = 16)
//        public void downloadTest(){
//
//        }

    @Test(priority = 17)
    public void uploadTest(){
        getUploadAndDownload().clickOnUploadDOwnloadFromMenu();
        getUploadAndDownload().clickOnUpload();
        Assert.assertEquals(getUploadAndDownload().getTextAfterUpload(),"C:\\fakepath\\sampleFile.jpeg");
    }

    @Test(priority = 18)
    public void buttonEnabledAfter5Seconds(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        getDynamicProperties().clickOnButtonAfter5();
        Assert.assertTrue(getDynamicProperties().assertClickAfter5());
    }

    @Test(priority = 19)
    public void buttonChangedColor(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertEquals(getDynamicProperties().buttonChangeColors(),"mt-4 text-danger btn btn-primary");
    }

    @Test(priority = 20)
    public void buttonVisibleAfter5Seconds(){
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertTrue(getDynamicProperties().clickOnButtonAfter5Seconds());
    }
}


