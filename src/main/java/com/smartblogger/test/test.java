package com.smartblogger.test;
import java.util.List;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;
import com.smartblogger.service.BlogService;
import com.smartblogger.service.UserService;




public class test 
{
    public static void main( String[] args )
    {
		UserService userService = new UserService();
		User user1 = new User("user1",  "user1@gmail.com", "password1");
		User user2 = new User("user2", "user2@gmail.com", "password2");
		User user3 = new User("user3","user3@gmail.com", "password3");
		try {
			userService.deleteAll();
		} catch (Exception e) {
		}
		
		try {
			userService.create(user1);
		} catch (Exception e) {
		}
		
		try {
			userService.create(user2);
		} catch (Exception e) {
		}
		
		try {
			userService.create(user3);
		} catch (Exception e) {
		}
		
		
		List<User> userl = userService.getAll();
		for (User b : userl) {
			System.out.println("-" + b.toString());
		}
		System.out.println("-----------------"  + " Deleting User2 "+"------------------");

		User userToDel = userService.getByUsername("user2");
		try {
			userService.delete( Integer.toString(userToDel.getUserId()));
		} catch (Exception e) {
		
		}
		
		List<User> userl2 = userService.getAll();
		for (User b : userl2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("-----------------"  + " Password Verification "+"------------------");
		
		//user 2 is deleted 
		System.out.println("----user2 is deleted and password verification should fail");
		if (userService.isValidPassword("user2", "password2")) {
			System.out.println("password for user2 matched");
		} else {
			System.out.println("password for user2 did not match");
		}
		
		System.out.println("----Password verification should pass");
		if (userService.isValidPassword("user3", "password3")) {
			System.out.println("password for user3 matched");
		} else {
			System.out.println("password for user3 did not match");
		}

		System.out.println("-----Invalid password Password verification should fail");
		if (userService.isValidPassword("user3", "password5")) {
			System.out.println("password for user3 matched");
		} else {
			System.out.println("password for user3 did not match");
		}		
		System.out.println("-----------------"  + " Blogs "+"------------------");

		BlogService qService = new BlogService();
		
		try {
			qService.deleteAll();
		} catch (Exception e) {
		
		}
		
		Blog Blog = new Blog("What is java ?", "I am unable to understand the difference between so many java machines", user1);
		try {
			qService.create(Blog);
		} catch (Exception e) {
		
		}
		
		Blog Blog2 = new Blog("What is jvm ?", "I am unable to understand the difference between so many java machines", user2);
		try {
			qService.create(Blog2);
		} catch (Exception e) {
			System.out.println("-----------Unale to createb ");
		}
		
		Blog2.setUser(user1);
		try {
			qService.create(Blog2);
		} catch (Exception e) {
			System.out.println("-----------Unale to createb ");
		}
		
		List<Blog> ql = qService.getAll();
		for (Blog b : ql) {
			System.out.println("-" + b.toString());
		}

}
}