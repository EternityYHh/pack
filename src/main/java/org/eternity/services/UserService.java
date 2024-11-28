package org.eternity.services;

import jakarta.transaction.Transactional;
import org.eternity.models.User;
import org.eternity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
