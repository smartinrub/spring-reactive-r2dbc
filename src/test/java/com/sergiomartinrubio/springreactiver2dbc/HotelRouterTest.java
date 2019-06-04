package com.sergiomartinrubio.springreactiver2dbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest
@RunWith(SpringRunner.class)
public class HotelRouterTest {

    @MockBean
    private HotelRepository hotelRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getAllHotelsShouldReturnAStreamOfHotels() {

        when(hotelRepository.findAll()).thenReturn(Flux.just(new Hotel(1L, "Malaga Palacios")));

        webTestClient
                .get().uri("/hotels")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                    .jsonPath("@.[0].id").isEqualTo("1")
                    .jsonPath("@.[0].name").isEqualTo("Malaga Palacios");
    }
}
