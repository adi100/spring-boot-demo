package com.example.demo.dao.mongo;

import com.example.demo.model.mongo.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser,Integer> {
}
