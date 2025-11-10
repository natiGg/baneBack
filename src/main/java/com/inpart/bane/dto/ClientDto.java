package com.inpart.bane.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private boolean migrated;
}