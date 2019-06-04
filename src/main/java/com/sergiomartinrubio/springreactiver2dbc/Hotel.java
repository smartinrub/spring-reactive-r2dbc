package com.sergiomartinrubio.springreactiver2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Hotel {
    private final int id;
    private final String name;
}