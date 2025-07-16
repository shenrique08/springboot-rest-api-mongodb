package org.api.springbootrestapimongodb.service;

import org.api.springbootrestapimongodb.domain.User;
import org.api.springbootrestapimongodb.dto.UserDTO;
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

    public User insert(User obj) {
        if (obj == null)
            throw new IllegalArgumentException("User object cannot be null");
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void update(String id, User userFromRequest) {
        User existingUser = findById(id);
        updateData(existingUser, userFromRequest);
        repo.save(existingUser);
    }

    private void updateData(User existingUser, User userFromRequest) {
        existingUser.setName(userFromRequest.getName());
        existingUser.setEmail(userFromRequest.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
