Feature: foobar

  Scenario: foobar
    Given John Smith is identified
    And he has 1000 on his account
    And ORA is selling at 10 per share
    When he buys 100 shares of ORA
    Then he should get a confirmation of success
    And his account balance should be 0
    And portfolio should contain 100 shares of ORA

  Scenario: foobar2
    Given John Smith is identified
    And portfolio contains 100 shares of ORA
    When he sells 100 shares of ORA
    Then he should get a confirmation of success
    And portfolio should contain 0 shares of ORA

#    Given an identified user
#    When the user looks at the global game ranking
#    Then he sees his own ranking & perf (+/- 1)
#    And he sees the top 3 perf & ranking
#
#    Given John Smith is identified
#    When he requests his portfolio
#    Then he sees the shares he owns
#
#    Given an identified user
#    And his balance is 1000 cash
#    When the user requests his balance
#    Then he gets 1000 cash
