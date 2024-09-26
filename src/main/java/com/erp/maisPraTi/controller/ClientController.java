package com.erp.maisPraTi.controller;

import com.erp.maisPraTi.dto.ClientDto;
import com.erp.maisPraTi.dto.ClientUpdateDto;
import com.erp.maisPraTi.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> insert (@Valid @RequestBody ClientDto clientDto){
        ClientDto newClientDto = clientService.insert(clientDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newClientDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newClientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClientDto>> findById(@PathVariable Long id){
        Optional<ClientDto> clientDto = clientService.findById(id);
        return ResponseEntity.ok().body(clientDto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable){
        Page<ClientDto> clients = clientService.findAll(pageable);
        return ResponseEntity.ok().body(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientUpdateDto clientUpdateDto){
        ClientDto clientUpdatedDto = clientService.update(id, clientUpdateDto);
        return ResponseEntity.ok().body(clientUpdatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
