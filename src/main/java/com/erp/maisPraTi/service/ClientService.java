package com.erp.maisPraTi.service;

import com.erp.maisPraTi.dto.ClientDto;
import com.erp.maisPraTi.dto.ClientUpdateDto;
import com.erp.maisPraTi.model.Client;
import com.erp.maisPraTi.repository.ClientRepository;
import com.erp.maisPraTi.service.exceptions.DatabaseException;
import com.erp.maisPraTi.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.erp.maisPraTi.utils.EntityMapper.convertToDto;
import static com.erp.maisPraTi.utils.EntityMapper.convertToEntity;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client client = new Client();
        client = convertToDto(dto, Client.class);
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        client = clientRepository.save(client);
        return convertToDto(client, ClientDto.class);
    }

    public Optional<ClientDto> findById(Long id) {
        verifyExistsId(id);
        Optional<Client> client = clientRepository.findById(id);
        ClientDto clientDto = convertToDto(client, ClientDto.class);
        return Optional.of(clientDto);
    }

    public Page<ClientDto> findAll(Pageable pageable){
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(c -> convertToDto(c, ClientDto.class));
    }

    @Transactional
    public ClientDto update(Long id, ClientUpdateDto clientUpdateDto){
        verifyExistsId(id);
        Client client = clientRepository.getReferenceById(id);
        convertToEntity(clientUpdateDto, client);
        client.setUpdatedAt(LocalDateTime.now());
        client = clientRepository.save(client);
        return convertToDto(client, ClientDto.class);
    }

    @Transactional
    public void delete(Long id){
        verifyExistsId(id);
        try{
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não foi possível excluir este cliente pois o mesmo está vinculado à alguma venda.");
        }
    }

    private void verifyExistsId(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        }
    }
}
