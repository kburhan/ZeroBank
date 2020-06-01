package com.zerobank.pages;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Zero_NewPayeePage extends PageBase {

    @FindBy(linkText = "Add New Payee")
    private WebElement addNewPayee;
    @FindBy(id="np_new_payee_name")
    private  WebElement payeeNameInput;
    @FindBy(id="np_new_payee_address")
    private WebElement payeeAddressInput;
    @FindBy(id="np_new_payee_account")
    private WebElement accountInput;
    @FindBy(id="np_new_payee_details")
    private WebElement payeeDetailsInput;
    @FindBy(id="add_new_payee")
    private WebElement addButton;
    @FindBy(id="alert_content")
    private WebElement succesfullMessage;


    public  void addNewPAyeeClick(){
        BrowserUtilities.wait(5);
        addNewPayee.click();
    }
    public void addNewPayeeInformation(String payeeName, String payeeAddress, String account, String payeeDetails){
        payeeNameInput.sendKeys(payeeName);
        payeeAddressInput.sendKeys(payeeAddress);
        accountInput.sendKeys(account);
        payeeDetailsInput.sendKeys(payeeDetails);
    }
    public void addButtonClick(){
        BrowserUtilities.wait(5);
        addButton.click();
    }
    public String message(){
        BrowserUtilities.wait(5);
        return succesfullMessage.getText();
    }
}