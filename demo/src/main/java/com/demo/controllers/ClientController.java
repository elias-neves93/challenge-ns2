package com.demo.controllers;

import com.demo.documents.Client;
import com.demo.responses.Response;
import com.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Response<Client>> listById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new Response<Client>(this.clientService.listById(id)));
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
