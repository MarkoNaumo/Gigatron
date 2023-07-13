import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    HomePage homePage;


    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        homePage = new HomePage(driver);
    }


    @Test
    public void SearchTest()
    {
        homePage.inputSearchSend("samsung");
        homePage.clickCookies();
        homePage.clickAddSamsung();

        Assert.assertEquals(homePage.GetCartNumber(),"1");
    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
