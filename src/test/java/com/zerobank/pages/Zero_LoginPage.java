package com.zerobank.pages;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Zero_LoginPage extends PageBase{

    @FindBy(id = "signin_button")
    private WebElement signingButton;

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(name = "submit")
    private WebElement submit;

    @FindBy(xpath="//div[@class='alert alert-error']")
    private WebElement warningMessage;

    @FindBy(linkText = "Forgot your password ?")
    private WebElement forgotPassword;

    public String getWarningMessage(){
        BrowserUtilities.waitForPageToLoad(5);
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        BrowserUtilities.wait(2);
        return warningMessage.getText().trim();

    }

    public void login(String usernameValue, String passwordValue){
        wait.until(ExpectedConditions.visibilityOf(signingButton)).click();
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue,Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.wait(2);
    }

    public void login(){
        wait.until(ExpectedConditions.visibilityOf(signingButton)).click();
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.waitForPageToLoad(2);
    }
    public  void navigate_to_tabName(String str){
        String xpath="//ul[@class='nav nav-tabs']//a[text()= '"+str+"']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.wait(2);
    }

}