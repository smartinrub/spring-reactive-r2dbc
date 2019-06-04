package com.sergiomartinrubio.springreactiver2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HotelRepository extends ReactiveCrudRepository<Hotel, Long> { }
