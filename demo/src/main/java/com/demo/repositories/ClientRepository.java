package com.demo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.documents.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository <Client, String> {

}
