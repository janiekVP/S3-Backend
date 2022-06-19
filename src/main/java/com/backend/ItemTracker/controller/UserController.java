package com.backend.ItemTracker.controller;

import com.backend.ItemTracker.model.Role;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.repository.UserRepository;
import com.backend.ItemTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.GetAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        User user = userService.FindUserById(id);
        return ResponseEntity.ok(user);
        //return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
        Role userRole = new Role();
        userRole.setId(1);
        user.setRole(userRole);

        User savedUser = userService.Create(user);
        return ResponseEntity.created(new URI("/users/" + savedUser.getId())).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        User currentUser = userService.FindUserById(id);//.orElseThrow(RuntimeException::new);
        currentUser.setUserName(user.getUserName());
        currentUser.setEmail(user.getEmail());
        currentUser.setFavorite(user.getFavorite());

        User updatedUser = userService.Update(currentUser);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.Delete(id);
        return ResponseEntity.ok().build();
    }
}
