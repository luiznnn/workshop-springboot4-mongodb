package com.luiz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.luiz.workshopmongo.domain.User;

@Service
public class UserService {

    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findAll() {
        return mongoTemplate.findAll(User.class, "user");
    }

    
}
