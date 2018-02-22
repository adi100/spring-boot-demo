package com.example.demo.dao.mongo;

import com.example.demo.model.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
}
