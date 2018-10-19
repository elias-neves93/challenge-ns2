package com.demo.services;

import com.demo.documents.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> listAll();

    Optional<Client> listById(String id);

    Client register(Client client);

    Client update(Client client);

    void remove(String id);

}
