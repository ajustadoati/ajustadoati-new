package com.ajustadoati.apigateway.controllers;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"system-info-service=http://localhost:${wiremock.server.port}", "eureka.client.enabled=false"})
@AutoConfigureWireMock(port = 0)
public class RouteControllerTests {

    @Autowired
    private WebTestClient webClient;
    //TODO
    //@Test
    public void whenCallServiceThroughGateway_thenAllConfiguredFiltersGetExecuted() {
        stubFor(WireMock.get(urlEqualTo("/suite/category-service/v0/category"))
                .willReturn(aResponse()
                        .withBody("2.0.20")
                        .withHeader("Content-Type", "application/text")));


        webClient
                .get().uri("/suite/category-service/v0/category")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("2.0.20");

    }
}
