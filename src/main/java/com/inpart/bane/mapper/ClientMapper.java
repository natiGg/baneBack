package com.inpart.bane.mapper;


import com.inpart.bane.dto.ClientDto;
import com.inpart.bane.model.Client;

public class ClientMapper {

    public static ClientDto toDto(Client client) {
        return new ClientDto(client.getId(), client.getName(), client.isMigrated());
    }
}
