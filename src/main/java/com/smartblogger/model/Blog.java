package com.smartblogger.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Blog {
	
	private Integer blogId;
	private String title;
	private String content;
	private String tag;
	private Timestamp postDate;
	
	private User user;
	
	public Blog() {
		
	}
	public Blog(String title, String text, User user) {
		this.title = title;
		this.content  = text;
		this.user  = user;
		this.postDate  = new Timestamp(System.currentTimeMillis());
		this.tag = "tag";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Timestamp getPostDate() {
		return postDate;
	}
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", content="
				+ content + ", tag=" + tag + ", postDate=" + postDate
				+ ", user=" + user + "]";
	}
}
