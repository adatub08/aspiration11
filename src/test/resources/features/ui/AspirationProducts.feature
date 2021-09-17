@AspirationProductsVerification
  Feature: Aspiration products verification

    Scenario: card product verification

      Given The user is on "https://aspiration.com/" homepage
      When user clicks "SPEND & SAVE" button
      Then verify "Aspiration" and "Aspiration Plus" products are displayed on the page
      And user clicks "get Aspiration"
      Then input field for email address is displayed
      And user clicks "get Aspiration Plus"
      Then monthly and early plans are displayed
      And verify that yearly radio option is "71.88 $ paid once yearly"
      And verify that monthly radio button is "7.99 $ paid monthly"


