package com.demo.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.documents.Client;
import com.demo.responses.Response;
import com.demo.services.ClientService;

@RestController
@RequestMapping(path = "client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/teste")
    public String test() {

        return "Test!";
    }

    @GetMapping
    public ResponseEntity<Response<List<Client>>> listAll() {
        return ResponseEntity.ok(new Response<List<Client>>(this.clientService.listAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> listById(@PathVariable(name = "id") String id) {
        try {
             Optional<Client> client = clientService.listById(id);
            if (client.isPresent())
                return ResponseEntity.ok(client.get());
            return ResponseEntity.ok("Cliente not found");
        } catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getStackTrace());
        }

    }

    @PostMapping
    public ResponseEntity<Response<Client>> register(@Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Client>(erros));
        }

        return ResponseEntity.ok(new Response<Client>(this.clientService.register(client)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<Client>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Client>(erros));
        }

        client.setId(id);
        return ResponseEntity.ok(new Response<Client>(this.clientService.update(client)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<Integer>> remove(@PathVariable(name = "id") String id) {
        this.clientService.remove(id);
        return ResponseEntity.ok(new Response<Integer>(1));
    }





}
