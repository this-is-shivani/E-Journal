package com.ecowishlist.eJournal.repository;

import com.ecowishlist.eJournal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    public User findByUsername(String username);
}
