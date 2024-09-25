package com.erp.maisPraTi.services;

import com.erp.maisPraTi.dtos.ClientDto;
import com.erp.maisPraTi.entities.Client;
import com.erp.maisPraTi.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.erp.maisPraTi.utils.EntityMapper.convertToDto;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client client = new Client();
        client = convertToDto(dto, Client.class);
        client = clientRepository.save(client);
        return convertToDto(client, ClientDto.class);
    }
}
