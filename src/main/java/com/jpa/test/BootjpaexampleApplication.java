
package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;


@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user1 = new User();
	
		user1.setName("Mansi Malik");
		user1.setCity("Delhi");
		user1.setStatus("I am java programmer");
		
		
		User user2 = new User();
		user2.setName("Ram");
		user2.setCity("Delhi");
		user2.setStatus("I am python programmer");
		
//Saving single User
		
		System.out.println("\nSaving Single User at a time : ");
		User resultUser1 = userRepository.save(user2);
		System.out.println("Save Use : " + resultUser1);
		System.out.println("Done \n");  
	
//Save Multiple objects	
		System.out.println("Saving multiple user at the same time : ");
		List<User> users2 = List.of(user1,user2);
		Iterable<User> result1 = userRepository.saveAll(users2);
		result1.forEach(user->{System.out.println(user);});  
		System.out.println("Saved\n");
		
		
// Update the user id of 5	
		
	    System.out.println("Update the user id of 8 : ");
	    
		Optional<User> optional = userRepository.findById(8);
		User user = optional.get();
		
		user.setName("Ram singh");
		User result2 = userRepository.save(user);
		System.out.println(result2); 
		System.out.println("Updated\n");
		
//Print the users using iterator method		
		Iterable<User> itr = userRepository.findAll();
		
		System.out.println("Print the users using iterator : ");
		Iterator<User> iterator = itr.iterator(); 
		while(iterator.hasNext()) {
			User user3 = iterator.next();
			System.out.println(user3);
		} 
		System.out.println("Printed\n");
		
		System.out.println("Print the users using for each and override accept method : ");
		itr.forEach((Consumer<? super User>) new Consumer<User>(){
			
			@Override
			public void accept(User t) {
				System.out.println(t);
			}	
		});  
		System.out.println("---Printed---\n");
		
		System.out.println("Print the users using for each : ");
		itr.forEach(user4->{System.out.println(user4);}); 
		System.out.println("Printed using for each\n");
		
		
// Deleting the user element 
		
		System.out.println("Delete single user at a time using deleteById method() id=5 : ");
		userRepository.deleteById(30);
		System.out.println("Deleted single user\n"); 
		
		
		System.out.println("Deleted all user using deleteAll() method : ");
		Iterable<User> allusers = userRepository.findAll();
		allusers.forEach(user5->System.out.println(user5));
		userRepository.deleteAll(allusers);
		System.out.println("Deleted all users \n");  
		
		
		
		
	}

}
