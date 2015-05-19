package lunchbox.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lunchbox.Authentication;
import lunchbox.CashAccount;
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
    Map<String, Integer> portfolio;
    private String result;

    @Given("^(.+) is identified$")
    public void user_is_identified(String user) throws Throwable
    {
        portfolio = new HashMap<>();
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
        portfolio.put(instrument, quantity);
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

    @And("^portfolio should contain (\\d+) shares? of (\\w+)$")
    public void portfolio_should_contain_shares(int quantity, String symbol) throws Throwable
    {
        assertThat(portfolio.get(symbol)).isEqualTo(quantity);
    }

    @And("^portfolio contains (\\d+) shares of (\\w+)$")
    public void portfolio_contains_shares(int quantity, String instrument) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^s?he sells (\\d+) shares of (\\w+)$")
    public void he_sells_shares_of_ORA(int quantity, String instrument) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
