package com.backend.ItemTracker.Tests;

import com.backend.ItemTracker.Mocks.UserMockRepo;
import com.backend.ItemTracker.model.Item;
import com.backend.ItemTracker.model.Role;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    private UserService userService;
    private UserMockRepo mockRepo;

    @BeforeEach
    void setup() throws Exception{
        this.mockRepo = new UserMockRepo();
        PasswordEncoder passwordEncoder = null;
        this.userService = new UserService(mockRepo, passwordEncoder);


        List<User> users = new ArrayList<>();

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("User");

        Item item1 = new Item();
        item1.setId(1);
        item1.setName("sword");
        item1.setDescription("big sword");


        // user 1
        User user1 = new User();
        user1.setId(1);
        user1.setRole(role1);
        user1.setUsername("name1");
        user1.setEmail("email1@email.com");
        user1.setFavorite(item1);

        users.add(user1);


        // user 2
        User user2 = new User();
        user2.setId(2);
        user2.setRole(role1);
        user2.setUsername("name2");
        user2.setEmail("email2@email.com");
        user2.setFavorite(item1);

        users.add(user2);


        // user 3
        User user3 = new User();
        user3.setId(3);
        user3.setRole(role1);
        user3.setUsername("name3");
        user3.setEmail("email3@email.com");
        user3.setFavorite(item1);

        users.add(user3);


        mockRepo.FillDataBase(users);
    }

    @Test
    void findUserByIdTest() {
        long testId = 1;
        User user = userService.FindUserById(testId);

        Assertions.assertEquals("name1",user.getUsername());
        Assertions.assertEquals("email1@email.com",user.getEmail());
        Assertions.assertEquals("User",user.getRole().getName());
        Assertions.assertEquals("sword",user.getFavorite().getName());

    }

    @Test
    void getAllTest() {
        List<User> userList = userService.GetAll();

        Assertions.assertEquals(3,userList.size());
    }

    @Test
    void createUserTest() {
        Role role1 = new Role();
        role1.setId(1);
        String roleName = "User";
        role1.setName(roleName);

        Item item1 = new Item();
        item1.setId(1);
        String itemName = "sword";
        item1.setName(itemName);
        item1.setDescription("big sword");

        User newUser = new User();

        newUser.setId(4);
        newUser.setRole(role1);
        String userName = "test4";
        newUser.setUsername(userName);
        String email = "email4@email.com";
        newUser.setEmail(email);
        newUser.setFavorite(item1);

        userService.Create(newUser);

        User getNewUser = null;
        for (User user : mockRepo.users) {
            if (user.getId() == newUser.getId()) {
                getNewUser = user;
            }
        }
        //User updatedUser = mockRepo.users.get(2);

        Assertions.assertEquals(userName, getNewUser.getUsername());
        Assertions.assertEquals(email, getNewUser.getEmail());
        Assertions.assertEquals(roleName, getNewUser.getRole().getName());
        Assertions.assertEquals(itemName, getNewUser.getFavorite().getName());
    }

    @Test
    void editUserTest() {
        Role role2 = new Role();
        role2.setId(2);
        String roleName = "Admin";
        role2.setName(roleName);

        Item item2 = new Item();
        item2.setId(2);
        String itemName = "shield";
        item2.setName(itemName);
        item2.setDescription("big shield");

        User testUser = new User();

        testUser.setId(2);
        testUser.setRole(role2);
        String userName = "test2";
        testUser.setUsername(userName);
        String email = "test2@email.com";
        testUser.setEmail(email);
        testUser.setFavorite(item2);

        userService.Update(testUser);


        User updatedUser = null;
        for (User user : mockRepo.users) {
            if (user.getId() == testUser.getId()) {
                updatedUser = user;
            }
        }
        //User updatedUser = mockRepo.users.get(2);

        Assertions.assertEquals(userName, updatedUser.getUsername());
        Assertions.assertEquals(email, updatedUser.getEmail());
        Assertions.assertEquals(roleName, updatedUser.getRole().getName());
        Assertions.assertEquals(itemName, updatedUser.getFavorite().getName());
    }

    @Test
    void deleteUserTest() {
        long testId = 1;
        userService.Delete(testId);

        Assertions.assertFalse(mockRepo.users.contains(testId));
    }
}
