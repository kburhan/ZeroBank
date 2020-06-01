package com.zerobank.pages;
import java.util.List;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zero_AccountSummaryPage extends PageBase {
    protected WebDriverWait wait;
    protected WebDriver driver;

    @FindBy(tagName = "h2")
    private static List<WebElement> accountSummaryTypes;
    @FindBy(xpath = "//h2[text()='Credit Accounts'] //following-sibling::div[1]//tr[1]//th")
    private List<WebElement> creditAccountsColumns;



    public List<String> getCreditAccountsColumns() {
        BrowserUtilities.waitForPageToLoad(10);
        return BrowserUtilities.getTextFromWebElements(creditAccountsColumns);
    }
    public List<String> getAccountSummaryTypes() {
        BrowserUtilities.waitForPageToLoad(10);
        return BrowserUtilities.getTextFromWebElements(accountSummaryTypes);
    }
}
