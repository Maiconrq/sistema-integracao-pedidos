# language: en
# src/test/resources/com/sistemapedidos/pedido.feature

Feature: Order Management
  In order to manage orders
  As a system user
  I want to be able to create and view orders

  Scenario: Customer creates a new order
    Given that the customer wants to create a new order with description "Test Order" and value 100.0
    When they create the order
    Then the order is successfully created
