package com.sergiomartinrubio.springreactiver2dbc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void saveAll() {
        StepVerifier
                .create(hotelRepository.deleteAll())
                .verifyComplete();

        StepVerifier
                .create(hotelRepository.saveAll(Flux.just(new Hotel(2L, "hotel test 1"), new Hotel(3L, "hotel test 2"))))
                .expectNextCount(2)
                .verifyComplete();

//        StepVerifier
//                .create(hotelRepository.findAll())
//                .expectNextCount(2)
//                .verifyComplete();

        StepVerifier
                .create(hotelRepository.saveAll(Flux.just(new Hotel(null, null))))
                .expectError(IllegalStateException.class)
                .verify();

        StepVerifier
                .create(hotelRepository.saveAll(Flux.just(new Hotel(2L, "hotel test 3"))))
                .expectError(RuntimeException.class)
                .verify();
//
//        StepVerifier
//                .create(hotelRepository.findAll())
//                .expectNextCount(2)
//                .verifyComplete();
    }

}