package com.ecowishlist.eJournal.service;

import com.ecowishlist.eJournal.entity.User;
import com.ecowishlist.eJournal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public void saveUser(User user)
    {
        repo.save(user);
    }

    public Optional<User> getUserById(ObjectId id)
    {
        return repo.findById(id);
    }

    public void deleteUserById(ObjectId id)
    {
        repo.deleteById(id);
    }
    
    public List<User> getAllUsers()
    {
        return repo.findAll();
    }

    public void updateUserPassword(User user) {
        User userInDB = repo.findByUsername(user.getUsername());
        if(userInDB!=null) {
            userInDB.setPassword(user.getPassword());
            repo.save(userInDB);
        }
    }
}
