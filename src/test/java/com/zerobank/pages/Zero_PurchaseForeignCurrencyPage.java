package com.zerobank.pages;
import java.util.List;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Zero_PurchaseForeignCurrencyPage extends PageBase{

    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement purchaseForeign;
    @FindBy(id="pc_currency")
    private WebElement currency;
    @FindBy(id="pc_calculate_costs")
    private WebElement calculateButton;

    public void purchaseForeignClick(){
        BrowserUtilities.wait(5);
        purchaseForeign.click();
    }
    public List<String> setCurrency(){
        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.visibilityOf(currency));
        Select select=new Select(currency);
        List<WebElement>list=select.getOptions();
        return BrowserUtilities.getTextFromWebElements(list);
    }
    public void calculateClick(){
        BrowserUtilities.wait(5);
        calculateButton.click();
    }
    public String alert(){
        return driver.switchTo().alert().getText();
    }
}