package com.sergiomartinrubio.springreactiver2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Hotel {

    @Id
    private Long id;

    @NotNull
    private String name;

}