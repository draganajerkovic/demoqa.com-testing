package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTests{
    @Test(priority = 1)
    public void testTextBox(){
        getFrontPage().getToForm();
        getFrontPage().enterFirstName("Marko");
        getFrontPage().enterEmail("bla@gmail.com");
        getFrontPage().enterCurrentAddress("Morocco");
        getFrontPage().enterPermanentAddress("Seychelles");
        getFrontPage().clickSubmit();
        Assert.assertTrue(getFrontPage().allSummary());
    }
}
