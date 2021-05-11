Feature: Secure Pay Test

  @sanity
  Scenario: User searches for the SecurePay website on Google and fills Contact Us page form
    Given the user is on google search
    When the user searches "Securepay" on Google
    And the user clicks the link "https://www.securepay.com.au/"
    Then verify the user is on the page displaying "SecurePay | Trusted Online Payment Gateway Provider in Australia | Online payment, merchant and billing solutions"
    And the user navigates to "Contact Us" link
    Then verify the user is on the page displaying "Contact SecurePay and learn about our solutions | Online payment, merchant and billing solutions"
    And the user fills the form with random data