package com.inpart.bane.services;


import com.inpart.bane.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final List<Client> legacyClients = new ArrayList<>();
    private final List<Client> newClients = new ArrayList<>();

    public ClientService() {
        legacyClients.add(new Client(1L, "John Doe", false));
        legacyClients.add(new Client(2L, "Alice Smith", false));
        legacyClients.add(new Client(3L, "Michael Johnson", false));
    }

    public List<Client> getLegacyClients() {
        return legacyClients;
    }

    public List<Client> getNewClients() {
        return newClients;
    }

    public void migrateClient(Long id) {

        Client client = legacyClients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (client.isMigrated()) {
            throw new RuntimeException("Client is already migrated");
        }

        // Mark as migrated and move to new list
        client.setMigrated(true);
        newClients.add(client);

        // ✅ Required console log
        System.out.println("Migrated client " + id + " successfully");
    }
}