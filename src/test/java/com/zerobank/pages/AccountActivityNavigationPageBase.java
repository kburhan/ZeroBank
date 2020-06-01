package com.zerobank.pages;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountActivityNavigationPageBase extends PageBase {
    protected WebDriver driver;

    @FindBy(xpath = "(//a[text()='Savings'])[1]")
    private WebElement savings;
    @FindBy(linkText = "Account Activity")
    private WebElement accountActivity;


    public void clickTo(String tab){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        String tabNameXpath="//a[text()='"+tab+"']";
        Driver.getDriver().findElement(By.xpath(tabNameXpath)).click();
    }
    public WebElement savingClicked(){
        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.visibilityOf(savings));
        return savings;
    }
    public WebElement clickLink(String link){
        String xpath="//option[text()='"+link+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


}