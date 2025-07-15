package org.api.springbootrestapimongodb.service;

import org.api.springbootrestapimongodb.domain.User;
import org.api.springbootrestapimongodb.service.exception.ObjectNotFoundException;
import org.api.springbootrestapimongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found with ID: " + id));
    }
}
