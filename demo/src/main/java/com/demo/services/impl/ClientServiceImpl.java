package com.demo.services.impl;

import com.demo.documents.Client;
import com.demo.repositories.ClientRepository;
import com.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


	@Autowired
	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> listAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client listById(String id) {
		return null;
	}

	/*
	@Override
	public Client listById(String id) {
		return this.clientRepository.findOne(Client id);
	}*/

	@Override
	public Client register(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public void remove(String id) {
		this.clientRepository.delete(id);
	}
}