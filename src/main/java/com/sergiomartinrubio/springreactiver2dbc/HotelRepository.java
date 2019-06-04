package com.sergiomartinrubio.springreactiver2dbc;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HotelRepository extends R2dbcRepository<Hotel, String> { }
