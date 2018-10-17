package com.demo.services;

import com.demo.documents.Client;

import java.util.List;

public interface ClientService {

    List<Client> listAll();

    Client listById(String id);

    Client register(Client client);

    Client update(Client client);

    void remove(String id);

}
