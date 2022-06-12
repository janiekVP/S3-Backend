package com.backend.ItemTracker.service;

import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) new User("foo", "foo",
                new ArrayList<>());
    }

    public List<User> GetAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User FindUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User Create(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User Update(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void Delete(Long id) {
        userRepository.deleteById(id);
    }
}
