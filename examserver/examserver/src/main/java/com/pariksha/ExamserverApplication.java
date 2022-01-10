package com.pariksha;

import com.pariksha.helper.UserFoundException;
import com.pariksha.model.Role;
import com.pariksha.model.User;
import com.pariksha.model.UserRole;
import com.pariksha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//
//
		try {
			System.out.println("run code");
			User user = new User();
			user.setUsername("jayantk.237");
			user.setEmail("jayantk237@gmail.com");
			user.setFirstName("Jayant");
			user.setLastName("Kumar");
			user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
			user.setPhone("9971452");
			user.setProfile("abc.jpg");


			Role role1 = new Role();
			role1.setRoleId(22L);
			role1.setRoleName("Admin");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);
			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);


			System.out.println(user1.getUsername());

		}
		catch (UserFoundException e)
		{
e.printStackTrace();
		}
		}
}
