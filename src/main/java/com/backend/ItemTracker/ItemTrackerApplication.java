package com.backend.ItemTracker;

import com.backend.ItemTracker.model.Role;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.service.RoleService;
import com.backend.ItemTracker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ItemTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemTrackerApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			//Role role = roleService.Create(new Role(id, "ROLE_USER", null));
			User user = new User("John Travolta", "john", "1234");
			userService.Create(user);

			User admin = new User("Admin", "admimail@mail.com", "1234");
			userService.Create(admin);
		};
	}*/

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
