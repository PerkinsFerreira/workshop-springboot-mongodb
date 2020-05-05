package com.perkins.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.perkins.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
