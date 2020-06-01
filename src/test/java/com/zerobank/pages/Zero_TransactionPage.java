package com.zerobank.pages;
import java.util.*;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Zero_TransactionPage extends PageBase{

    protected WebDriver driver;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransaction;
    @FindBy(id="aa_fromDate")
    private WebElement dateFrom;
    @FindBy(id="aa_toDate")
    private WebElement dateTo;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement search;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[1]")
    private List<WebElement> resultDate;
    @FindBy(name="description")
    private WebElement description;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[2]")
    private  List<WebElement> descriptionOnline;
    @FindBy(xpath = "//select[@id='aa_type']//option")
    private List<WebElement> dropDown;
    @FindBy(id="aa_type")
    private WebElement type;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[3]")
    private List<WebElement> depositResult;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[4]")
    private List<WebElement> withdrawalResult;



    public  void findTransactionClick(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(findTransaction)).click();
    }
    public  void dateSetUp(String from, String to){
        BrowserUtilities.waitForPageToLoad(10);
        dateFrom.clear();
        wait.until(ExpectedConditions.visibilityOf(dateFrom)).click();
        dateFrom.sendKeys(from);
        dateTo.clear();
        wait.until(ExpectedConditions.visibilityOf(dateTo)).click();
        dateTo.sendKeys(to);
    }
    public WebElement searchClick(){
        BrowserUtilities.waitForPageToLoad(10);
        return search;
    }
    public List<String> getResultDate (){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='filtered_transactions_for_account']//tbody//td[1])[1]")));
        BrowserUtilities.wait(4);
        return BrowserUtilities.getTextFromWebElements(resultDate);
    }
    public void descriptionClick(String str){
        BrowserUtilities.wait(5);
        description.click();
        description.clear();
        description.sendKeys(str);
    }
    public List<String> descriptionOnlineResult (){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        return BrowserUtilities.getTextFromWebElements(descriptionOnline);
    }
    public WebElement depositDisplayed(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        return description;
    }
    public List<WebElement> dropDownDisplayed(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        return dropDown;
    }
    public void selectType(String string){
        BrowserUtilities.wait(5);
        Select select = new Select(type);
        searchClick();
    }
    public List<WebElement> getDepositResult(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        return depositResult;
    }
    public List<WebElement> getWithdrawalResult(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        return withdrawalResult;
    }



}