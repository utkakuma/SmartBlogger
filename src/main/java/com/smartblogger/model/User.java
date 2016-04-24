package com.smartblogger.model;

import java.util.HashSet;
import java.util.Set;

//import org.cisco.blog.persist.Blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class User {
	
	private Integer userId;
	private String name;
	private String emailId;
	private String password;
	private Set<Blog> blogs; 
	
	

	public User(String name, String emailId, String password) {
		
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
public User(Integer id, String name, String emailId, String password) {
		
	this.userId = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	public User() {
		
	}
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId="
				+ emailId + ", password=" + password + "]";
	}
	
}
