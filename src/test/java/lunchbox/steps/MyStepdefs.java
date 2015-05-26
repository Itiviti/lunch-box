package lunchbox.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lunchbox.Authentication;
import lunchbox.CashAccount;
import lunchbox.LunchBox;
import lunchbox.Portfolio;
import lunchbox.Side;
import lunchbox.Symbol;
import lunchbox.Transaction;
import lunchbox.User;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import javax.money.NumberValue;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MyStepdefs
{
    public static final String SUCCESS = "Success";
    CashAccount cashAccount = null;
    User identifiedUser;
    LunchBox lunchbox = new LunchBox();
    private String result;

    @Given("^(.+) is identified$")
    public void user_is_identified(String user) throws Throwable
    {
        identifiedUser = new User(user);
        lunchbox.createPortfolio(identifiedUser);
    }

    @Given("^s?he has (\\d+) on (?:his|her) account$")
    public void has_cash_on_account(int amount) throws Throwable
    {
        cashAccount = new CashAccount();
    }

    @And("^(\\w+) is selling at (\\d+) per share$")
    public void instrument_is_selling_at_amount_per_share(String instrument, int price) throws Throwable
    {

    }

    @When("^s?he buys (\\d+) shares of (\\w+)$")
    public void buys_shares_of_instrument(int quantity, String instrument) throws Throwable
    {
        getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(instrument), Side.BUY));
        result = SUCCESS;
    }

    @Then("^s?he should get a confirmation of success$")
    public void gets_a_confirmation_of_success() throws Throwable
    {
        assertThat(result).isEqualTo(SUCCESS);
    }

    @And("^h(?:is|er) account balance should be (\\d+)$")
    public void his_account_balance_is(int amount) throws Throwable
    {
        assertThat(cashAccount.getBalance().getNumber().numberValue(Integer.class)).isEqualTo(amount);
    }

    @And("^h(?:is|er) portfolio should contain (\\d+) shares? of (\\w+)$")
    public void portfolio_should_contain_shares(int quantity, String symbol) throws Throwable
    {
        assertThat(getIdentifiedUserPortfolio().getPosition(new Symbol(symbol)).getQuantity()).isEqualTo(quantity);
    }

    @And("^h(?:is|er) portfolio contains (\\d+) shares of (\\w+)$")
    public void portfolio_contains_shares(int quantity, String symbol) throws Throwable
    {
        getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(symbol), Side.BUY));
    }

    @When("^s?he sells (\\d+) shares of (\\w+)$")
    public void he_sells_shares(int quantity, String symbol) throws Throwable
    {
        getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(symbol), Side.SELL));
        result = SUCCESS;
    }

    private Portfolio getIdentifiedUserPortfolio()
    {
        return lunchbox.getPortfolio(identifiedUser);
    }


    @Given("^(.+)'s portfolio contains (\\d+) shares of (\\w+)$")
    public void user_s_portfolio_contains_shares(String user, int quantity, String symbol) throws Throwable
    {
        User u = new User(user);
        lunchbox.createPortfolio(u);
        lunchbox.getPortfolio(u).addTransaction(new Transaction(quantity, new Symbol(symbol), Side.BUY));
    }
}
