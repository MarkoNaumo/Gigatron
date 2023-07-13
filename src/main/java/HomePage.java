import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    @FindBy(css = "#header__center__searchbox .search-container input")
    WebElement searchInput;

    @FindBy(css = "#header__center__searchbox .search-container i")
    WebElement search;

    @FindBy(css = ".mask .form-buttons .secondary")
    WebElement cookies;

    @FindBy(xpath = "//div[@id='ppi-529520']//button//*[name()='svg']")
    WebElement addSamsung;

    @FindBy(css = "#header__center__login__and__cart .icon-number")
    WebElement cartNumber;

    public HomePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void inputSearchSend(String text)
    {
        searchInput.sendKeys(text);
        search.click();
    }

    public void clickCookies()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cookies));
        if(cookies.isDisplayed())
            cookies.click();
    }

    public void clickAddSamsung()
    {
        addSamsung.click();
    }

    public String GetCartNumber()
    {
        if(cartNumber.isDisplayed())
            return cartNumber.getText();

        return null;
    }



}
