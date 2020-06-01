package com.zerobank.pages;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Zero_PayBills extends PageBase {

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsInput;
    @FindBy(xpath = "//div[@id='alert_content']//span")
    private WebElement succesfullMessage;
    @FindBy(xpath = "//select[@id='sp_payee']//option[2]")
    private WebElement payeeInput;
    @FindBy(xpath = "//select[@id='sp_account']//option[1]")
    private WebElement accountInput;
    @FindBy(id = "sp_amount")
    private WebElement amountInput;
    @FindBy(id="sp_date")
    private WebElement dateInput;
    @FindBy(id = "sp_description")
    private WebElement descriptionInput;
    @FindBy(id = "pay_saved_payees")
    private WebElement payInput;


    public void payBillsNavigate(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        payBillsInput.click();
    }

    public void makePayments(String amount, String date,String description){
        BrowserUtilities.waitForPageToLoad(10);
        payeeInput.click();
        accountInput.click();
        amountInput.sendKeys(amount);
        dateInput.sendKeys(date);
        descriptionInput.sendKeys(description);
        payInput.click();
    }
    public WebElement getSuccesfullMessage(){
        BrowserUtilities.waitForPageToLoad(10);
        return succesfullMessage;
    }
    public void getAlertlMessage(){
        BrowserUtilities.waitForPageToLoad(10);
    }
    public String alertMessage(){
        String message = driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
        return  message;
    }
}