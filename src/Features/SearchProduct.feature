Feature: Search and place the order for products
  Scenario Outline: Search Experience for product search in both home and Offer page
    Given User in on Green Card Landing page
    When User search with short name <name> and extract actual name of product
    Then User search for same short name in offers page to check if product exist
    Then Verify product name match with landing page and offer page
    Examples:
    |name|
    |Tom |
    |Bee|
