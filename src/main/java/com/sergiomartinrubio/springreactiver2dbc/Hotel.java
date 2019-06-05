package com.sergiomartinrubio.springreactiver2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Hotel {

    @Id
    private Long id;
    private String name;
}