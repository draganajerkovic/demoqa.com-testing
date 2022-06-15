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
    public void allCheckBoxTest(){
        getCheckBoxPage().completeClicks();
        Assert.assertEquals(getCheckBoxPage().messageAfterClicking(),"You have selected :\n"+"home\n" +
                "desktop\n"+"notes\n"+"commands\n"+"documents\n"+"workspace\n"+"react\n"+"angular\n"+"veu\n" +
                "office\n"+"public\n"+"private\n"+"classified\n"+"general\n"+"downloads\n"+"wordFile\n"+"excelFile");
    }

    @Test
    public void oneCheckBoxTest(){
        getCheckBoxPage().clickElementsButton();
        getCheckBoxPage().clickOnCheckBoxMenu();
        getCheckBoxPage().clickOnPlus();
        getCheckBoxPage().clickOnCommands();
        Assert.assertEquals(getCheckBoxPage().messageAfterClicking(),"You have selected :\n" + "commands");
    }

    @Test(priority = 3)
    public void radioButtonTest(){
        getRadioButtonPage().clickElementsButton();
        getRadioButtonPage().chooseRadioFromMenu();
        getRadioButtonPage().clickOnYes();
        Assert.assertEquals(getRadioButtonPage().yesMessage(), "You have selected Yes");
        Assert.assertFalse(getRadioButtonPage().impressiveNotSelectedWhenClickedOnYes());
        getRadioButtonPage().clickOnImpressive();
        Assert.assertEquals(getRadioButtonPage().impressiveMessage(),"You have selected Impressive");
        Assert.assertFalse(getRadioButtonPage().yesNotSelectedWhenClickedOnImpressive());
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

    @Test(priority = 6)
    public void linksNewTabTest(){
        getLinksPage().clickOnElements();
        getLinksPage().clickOnLinks();
        getLinksPage().clickOnHomeLink();
        Assert.assertEquals(getLinksPage().assertNewTabOpen(),"https://demoqa.com/");
    }


    @Test(priority = 7)
    public void linksApiTest(){
        getLinksPage().clickOnElements();
        getLinksPage().clickOnLinks();
        getLinksPage().clickOnCreate();
        Assert.assertEquals(getLinksPage().apiCallText(),"Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 8)
    public void validLinkTest(){
        getBrokenLinksImages().clickOnElements();
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickValidLink();
        Assert.assertEquals(getBrokenLinksImages().getUrl(),"https://demoqa.com/");
    }


    @Test(priority = 9)
    public void brokenLinkTest(){
        getBrokenLinksImages().clickOnElements();
        getBrokenLinksImages().clickOnBrokenLinksImages();
        getBrokenLinksImages().clickBrokenLink();
        Assert.assertEquals(getBrokenLinksImages().textAfterBrokenClick(),"Status Codes\n" +
                "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here");
    }
//test za download

//    @Test(priority = 10)
//        public void downloadTest(){
//
//        }

    @Test(priority = 11)
    public void uploadTest(){
        getUploadAndDownload().clickOnElements();
        getUploadAndDownload().clickOnUploadDOwnloadFromMenu();
        getUploadAndDownload().clickOnUpload();
        Assert.assertEquals(getUploadAndDownload().getTextAfterUpload(),"C:\\fakepath\\sampleFile.jpeg");
    }

    @Test(priority = 12)
    public void buttonEnabledAfter5Seconds(){
        getDynamicProperties().clickOnElements();
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        getDynamicProperties().clickOnButtonAfter5();
        Assert.assertTrue(getDynamicProperties().assertClickAfter5());
    }

    @Test(priority = 13)
    public void buttonChangedColor(){
        getDynamicProperties().clickOnElements();
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertEquals(getDynamicProperties().buttonChangeColors(),"mt-4 text-danger btn btn-primary");
    }

    @Test(priority = 14)
    public void buttonVisibleAfter5Seconds(){
        getDynamicProperties().clickOnElements();
        getDynamicProperties().clickOnDynamicElementsFromMenu();
        Assert.assertTrue(getDynamicProperties().clickOnButtonAfter5Seconds());
    }
}


