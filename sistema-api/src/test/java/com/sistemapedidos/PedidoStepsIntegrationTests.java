package com.sistemapedidos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoStepsIntegrationTests {

    private Response response;
    private String orderDescription;
    private Double orderValue;

    @Given("that the customer wants to create a new order with description {string} and value {double}")
    public void that_the_customer_wants_to_create_a_new_order_with_description_and_value(String description, Double value) {
        orderDescription = description;
        orderValue = value;
    }

    @When("they create the order")
    public void they_create_the_order() {
        String requestBody = String.format("""
                {
                    "descricao": "%s",
                    "valor": %.2f
                }
                """, orderDescription, orderValue);

        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/pedidos");
    }

    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        assertEquals(200, response.getStatusCode());
    }
}
