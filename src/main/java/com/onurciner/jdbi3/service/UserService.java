package com.onurciner.jdbi3.service;

import com.onurciner.jdbi3.model.User;
import com.onurciner.jdbi3.repository.UserRepository;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(Jdbi jdbi) {
        this.repository = jdbi.onDemand(UserRepository.class);
    }

    public User create(User user) {
        return getOne(repository.insert(user));
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getOne(long id) {
        return repository.findById(id);
    }

    public int deleteById(long id) {
        return repository.deleteById(id);
    }
}