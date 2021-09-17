package pages.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ui.Driver;

public class AspirarionPage {
    WebDriver driver;
    public AspirarionPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Spend & Save')][1]" )
    public WebElement spendNsaveLink;

    @FindBy(xpath = "//button[text()='Get Aspiration']")
    public WebElement getAspirationButton;

    @FindBy(xpath = "//button[text()='Get Aspiration Plus']")
    public WebElement getAspirationPlusButton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement inputForEmailOnModalWindow;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement buttonCloseOnAlert;

    @FindBy(xpath = "//div[@class='option selected']//div//following-sibling::p//b")
    public WebElement signSeventyOneFromRadioButtonFromYearly;

    @FindBy(xpath = "//div[@class='option']//p//b")
    public WebElement signSevenNightyNineFromRadioButtonFromMonthly;







}
