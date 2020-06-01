package com.zerobank.stepdefinitions;
import java.util.*;
import com.zerobank.pages.Zero_TransactionPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FindTransactionsSD {
    Zero_TransactionPage zeroTransactionPage =new Zero_TransactionPage();
    WebDriverWait wait;
    WebDriver driver;

    @When("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        BrowserUtilities.wait(5);
        zeroTransactionPage.findTransactionClick();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        BrowserUtilities.wait(5);
        zeroTransactionPage.dateSetUp(from,to);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtilities.wait(5);
        zeroTransactionPage.searchClick().click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String start, String end) {
        BrowserUtilities.wait(5);
        List<String> list= zeroTransactionPage.getResultDate();
        for (String str: list){
            Assert.assertTrue((str.compareTo(start) >= 0 && str.compareTo(end) <= 0));
        }

    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> list= zeroTransactionPage.getResultDate();
        List<LocalDate> dateList = new ArrayList<>();

        for(String str: list){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(str, formatter);
            dateList.add(date);
        }
        List<LocalDate> sortedList = new ArrayList<>();
        sortedList.addAll(dateList);
        sortedList.sort(Collections.reverseOrder());
        Assert.assertEquals("Already sorted",dateList,sortedList);
    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        BrowserUtilities.wait(5);
        List<String> list= zeroTransactionPage.getResultDate();
        Assert.assertFalse(list.contains(string));
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtilities.wait(5);

        zeroTransactionPage.descriptionClick(string);
    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtilities.wait(5);

        List<String> list = zeroTransactionPage.descriptionOnlineResult();
        System.out.println("list = " + list);
        for (String each : list) {
            Assert.assertTrue(each.contains(string));
        }
    }
    @When("user selects type {string}")
    public void user_selects_type(String string) {
        BrowserUtilities.wait(5);
        zeroTransactionPage.selectType(string);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtilities.wait(5);
        List<WebElement>list= zeroTransactionPage.getDepositResult();
        for(WebElement each: list){
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtilities.wait(5);
        List<WebElement>list= zeroTransactionPage.getWithdrawalResult();
        for(WebElement each: list){
            Assert.assertTrue(each.isDisplayed());
        }
    }
    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtilities.wait(5);
        List<WebElement> list = zeroTransactionPage.getWithdrawalResult();
        for(WebElement each:list ){
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtilities.wait(5);
        List<WebElement> list = zeroTransactionPage.getDepositResult();
        for(WebElement each:list ){
            Assert.assertTrue(each.isDisplayed());}
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtilities.wait(5);
        List<String> list = zeroTransactionPage.descriptionOnlineResult();
        System.out.println("list = " + list);
        for (String each : list) {
            Assert.assertFalse(each.contains(string));
        }
    }

}