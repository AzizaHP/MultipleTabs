Feature: Open 2 ecommerce website on each tabs

  Scenario: User open first ecommerce website then open second ecommerce website
    Given User open Tokopedia
    When User searchh "iPhone 15 Pro"
    And User sort ascending the price in tokopedia
    And Display the output from tokopedia in terminal
    And User move new tab open ebay
    And User search "iPhone 15 Pro"
    And User sort ascending the price in ebay
    And Display the output from ebay in terminal