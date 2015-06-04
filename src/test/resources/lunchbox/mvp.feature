Feature: foobar

  Scenario: buy
    Given John Smith is identified
    And he has 1000 on his account
    And ORA is selling at 10 per share
    When he buys 100 shares of ORA
    Then he should get a confirmation of success
    And his account balance should be 0
    And his portfolio should contain 100 shares of ORA

  Scenario: sell
    Given John Smith is identified
    And his portfolio contains 100 shares of ORA
    When he sells 100 shares of ORA
    Then he should get a confirmation of success
    And his portfolio should contain 0 shares of ORA

  Scenario: 2 users
    Given Jane Doe is identified
    Given John Smith's portfolio contains 100 shares of ORA
    Given her portfolio contains 200 shares of ORA
    When she sells 100 shares of ORA
    Then she should get a confirmation of success
    And her portfolio should contain 100 shares of ORA

  Scenario: reject short-sell
    Given Jane Doe is identified
    Given her portfolio contains 0 shares of TNT
    When she sells 100 shares of TNT
    Then she should be rejected
    And her portfolio should contain 0 shares of TNT


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
