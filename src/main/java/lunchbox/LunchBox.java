package lunchbox;

import java.util.HashMap;
import java.util.Map;

public class LunchBox
{
    private Map<UserId, Portfolio> portfolios = new HashMap<>();
    private Map<UserId, CashAccount> cashAccounts = new HashMap<>();

    public Portfolio getPortfolio(UserId userId)
    {
        return portfolios.get(userId);
    }

    public CashAccount getCashAccount(UserId userId)
    {
        return cashAccounts.get(userId);
    }

    public UserId createUser(String userName)
    {
        UserId userId = new UserId(userName);
        portfolios.put(userId, new Portfolio());
        cashAccounts.put(userId, new CashAccount());
        return userId;
    }
}
