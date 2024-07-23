package com.example.nohitakids.service;

import com.example.nohitakids.dto.http.response.AllBuysResponseDto;
import com.example.nohitakids.model.repository.ClientRepository;
import com.example.nohitakids.model.entity.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client getById(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    //TODO: Refactor
    public Optional<Client> getByName(String name) {
        return clientRepository.findByName(name);
    }

    public Client getByDni(Integer dni) {
        return clientRepository.findByDni(dni).orElseThrow();
    }

    public List<AllBuysResponseDto> getAllByBuyOrderByBuyAsc() {
        //Busco quantities de la DB
        List<Integer> quantitiesOrderByBuyAsc = clientRepository.getAllQuantitiesOrderByBuyAsc();

        //Instancio el objeto que tengo que retornar (es una lista)
        List<AllBuysResponseDto> allBuysResponseDtos = new ArrayList<>();

        //Instancio el objeto que tengo que meter en la lista
        AllBuysResponseDto dto = new AllBuysResponseDto();

        //Le pongo los quantities de la DB al dto
        dto.setQuantities(quantitiesOrderByBuyAsc);

        //Meto el DTO adentro de la lista que tengo que retornar
        allBuysResponseDtos.add(dto);

        //Retorno la lista
        return allBuysResponseDtos;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    public void deleteByDni(Integer dni) {
        clientRepository.deleteByDni(dni);
    }

}
