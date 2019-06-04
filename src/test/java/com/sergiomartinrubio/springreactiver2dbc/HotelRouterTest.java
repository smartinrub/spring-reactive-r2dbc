package com.sergiomartinrubio.springreactiver2dbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@RunWith(SpringRunner.class)
public class HotelRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getAllHotelsShouldReturnAStreamOfHotels() {
        webTestClient
                .get().uri("/hotels")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8);
    }
}
