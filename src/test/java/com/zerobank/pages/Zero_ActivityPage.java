package com.zerobank.pages;
import java.util.List;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zero_ActivityPage extends PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//select[@id='aa_accountId']//option[1]")
    private WebElement defaultOptionSaving;


    @FindBy(xpath ="//div[@id='all_transactions_for_account']//th" )
    private List<WebElement>accountActivityTabNamesElements;
    @FindBy(xpath = "//select[@id='aa_accountId']//option")
    private List<WebElement> dropDownElements;

    public WebElement setDefaultOptionSaving(){
        BrowserUtilities.wait(5);
        return defaultOptionSaving;
    }
    public List<String> accountActivityTabNames(){
        BrowserUtilities.waitForPageToLoad(5);
        return BrowserUtilities.getTextFromWebElements(accountActivityTabNamesElements);
    }
    public List<String> dropDown(){
        BrowserUtilities.waitForPageToLoad(5);
        return BrowserUtilities.getTextFromWebElements(dropDownElements);
    }
}