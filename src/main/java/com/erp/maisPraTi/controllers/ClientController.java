package com.erp.maisPraTi.controllers;

import com.erp.maisPraTi.dtos.ClientDto;
import com.erp.maisPraTi.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

}
