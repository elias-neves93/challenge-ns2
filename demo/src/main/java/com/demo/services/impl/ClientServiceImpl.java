package com.demo.services.impl;

import com.demo.documents.Client;
import com.demo.repositories.ClientRepository;
import com.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
	private ClientRepository clientRespository;

	@Override
	public List<Client> listAll() {
		return this.clientRespository.findAll();
	}

    @Override
    public Optional<Client> listById(String id) {
        return clientRespository.findById(id);
    }

	@Override
	public Client register(Client client) {
		return this.clientRespository.save(client);
	}

	@Override
	public Client update(Client client) {
		return this.clientRespository.save(client);
	}

	@Override
	public void remove(String id) {
		this.clientRespository.deleteById(id);
	}

}