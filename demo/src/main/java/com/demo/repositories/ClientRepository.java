package com.demo.repositories;

import com.demo.documents.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository <Client, String> {


    void delete(String id);
}
