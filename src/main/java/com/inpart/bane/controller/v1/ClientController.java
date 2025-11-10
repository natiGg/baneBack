package com.inpart.bane.controller.v1;

import com.inpart.bane.mapper.ClientMapper;
import com.inpart.bane.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("/legacy/clients")
    public ResponseEntity<?> getLegacyClients() {
        var dtos = service.getLegacyClients()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/new/clients")
    public ResponseEntity<?> getNewClients() {
        var dtos = service.getNewClients()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/migrate/{id}")
    public ResponseEntity<?> migrate(@PathVariable Long id) {
        try {
            service.migrateClient(id);
            return ResponseEntity.ok("Migrated client " + id + " successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}