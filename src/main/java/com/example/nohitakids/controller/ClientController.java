package com.example.nohitakids.controller;

import com.example.nohitakids.dto.http.response.AllBuysResponseDto;
import com.example.nohitakids.model.entity.Client;
import com.example.nohitakids.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Retorna todos los datos de la tabla.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll() {
        return clientService.findAll();
    }

    //Retorna los datos del cliente según su id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable("id") Integer id) {
        return clientService.getById(id);
    }

    //Return customer data based on their ID number
    @GetMapping("/query")
    @ResponseStatus(HttpStatus.OK)
    public Client findByParams(@RequestParam("dni") Integer dni) {
        return clientService.getByDni(dni);
    }

    @GetMapping("/all-buy")
    @ResponseStatus(HttpStatus.OK)
    public List<AllBuysResponseDto> getAllByBuys() {
        return clientService.getAllByBuyOrderByBuyAsc();
    }

    //Crea y guarda un nuevo cliente en la BD
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    //Elimina los clientes según su id correspondiente
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
        public void deleteById(@PathVariable("id") Integer id) {
        clientService.deleteById(id);
    }

}
