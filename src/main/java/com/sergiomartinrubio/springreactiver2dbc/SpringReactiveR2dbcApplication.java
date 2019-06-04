package com.sergiomartinrubio.springreactiver2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@EnableR2dbcRepositories
@RequiredArgsConstructor
public class SpringReactiveR2dbcApplication {

    private final HotelRepository hotelRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveR2dbcApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(GET("/hotels"), serverRequest -> ok().body(hotelRepository.findAll(), Hotel.class));
    }

    @Repository
    interface HotelRepository extends R2dbcRepository<Hotel, String> { }

    @Data
    @AllArgsConstructor
    static class Hotel {
        private final int id;
        private final String name;
    }
}
