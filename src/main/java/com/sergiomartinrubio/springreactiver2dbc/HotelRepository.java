package com.sergiomartinrubio.springreactiver2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HotelRepository extends ReactiveCrudRepository<Hotel, Long> {

    // TODO: Create service with transactional support. @see https://spring.io/blog/2019/05/16/reactive-transactions-with-spring
}
