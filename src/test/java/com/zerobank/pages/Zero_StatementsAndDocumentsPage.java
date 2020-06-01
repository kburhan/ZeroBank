package com.zerobank.pages;
import java.util.List;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Zero_StatementsAndDocumentsPage extends PageBase {

    @FindBy(linkText = "Online Statements")
    private WebElement onlineStatements;
    @FindBy(xpath = "//ul[@class='nav nav-pills']//li")
    private List<WebElement> displayedYear;


    public void onlineStatementsClick(){
        BrowserUtilities.wait(5);
        onlineStatements.click();
        BrowserUtilities.waitForPageToLoad(10);
    }
    public void selectYear(Integer int1){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+int1+"']"))).click();
    }
    public int numberStatementDisplayed(){
        List<WebElement> TotalRowsList = driver.findElements(By.xpath("//*[@id='os_2009']/table/tbody/tr/td[1]/a"));
        return TotalRowsList.size();
    }
    public List<String > displayedYears(){
        return BrowserUtilities.getTextFromWebElements(displayedYear);
    }

    public void statementClick(String string){
        WebElement element=driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String statementName(String string){
        BrowserUtilities.waitForPageToLoad(5);
        WebElement element=driver.findElement(By.xpath("//a[text()='"+string+"']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public String fileNameAndType(String string){
        WebElement name = driver.findElement(By.xpath("//a[@href='/bank/online-statements-by-name.html?name=8534567-"+string+".pdf']"));
        return name.getText();
    }

}