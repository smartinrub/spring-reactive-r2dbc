package com.sergiomartinrubio.springreactiver2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringReactiveR2dbcApplication {

    private final HotelRepository hotelRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveR2dbcApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> route() {

        return RouterFunctions
                .route(GET("/hotel"), serverRequest -> ok().body(hotelRepository.findAll(), Hotel.class));
    }

}
