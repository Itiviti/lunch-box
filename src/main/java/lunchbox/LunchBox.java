package lunchbox;

import java.util.HashMap;
import java.util.Map;

public class LunchBox
{
    Map<User, Portfolio> portfolios = new HashMap<>();

    public Portfolio getPortfolio(User user) {
        return portfolios.get(user);
    }

    public void createPortfolio(User user) {
        portfolios.put(user, new Portfolio());
    }
}
