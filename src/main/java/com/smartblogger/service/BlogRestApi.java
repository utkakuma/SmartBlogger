package com.smartblogger.service;

	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;


	@Path("/blogs")
	public class BlogRestApi {
		private Integer   	    blogid;
		private String 	    title;
		private String      content;
		private Timestamp 	postdate;
		private String      username;
		private Integer         userId;
		
		
		public BlogRestApi(Integer blogid, String title, String content) {
			this.blogid = blogid;
			this.title = title;
			this.content = content;
		}

		public BlogRestApi(String title, String content) {
			this.title = title;
			this.content = content;
		}
		public BlogRestApi(Integer blogid, String title, 
				     String content, Timestamp postdate,
				     String username, Integer userId ) {
			this.blogid    = blogid; 
			this.title         = title; 
			this.content          = content; 
			this.postdate    = postdate; 
			this.username      = username; 
			this.userId        = userId;
		}

		
		public  BlogRestApi() {
			
		}
		
		
		public Integer getblogid() {
			return this.blogid;
		}
		public void setblogid(Integer id){
			this.blogid = id;
		}
		
		
		public String getTitle () {
			return this.title;
		}
		
		public void setTitle (String title) {
			this.title = title;
		}
		
		public String getcontent () {
			return this.content;
		}
		
		public void setcontent (String content) {
			this.content = content;
		}
		
		public String getUsername () {
			return this.username;
		}
		
		public void getUsername (String username) {
			this.username = username;
		}
		
		
		public Integer getUserId () {
			return this.userId;
		}
		
		public void setUserId (Integer userId) {
			this.userId = userId;
		}
		
		
		
		public void setpostdate (Timestamp postdate) {
			this.postdate = postdate;
		}
		
		public Timestamp getpostdate () {
			return this.postdate;
		}
		
		public List<BlogRestApi> BlogGetAll() throws Exception {
			BlogService blogService  = new BlogService() ;
			List<BlogRestApi> list = new ArrayList<BlogRestApi>();
			List<Blog> blog = blogService.getAll();
			for (Blog b : blog) {
				BlogRestApi up = new BlogRestApi(b.getBlogId(), 
						                         b.getTitle(), 
						                         b.getContent(),
						                         b.getPostDate(),
						                         b.getUser() == null ? "anonymous":b.getUser().getName(), 
						                        b.getUser() == null ? 0: b.getUser().getUserId());
				list.add(up);
			}
			return list;
		}
		
		@GET
		@Path("/{param}")
		@Produces(MediaType.APPLICATION_JSON)
		public BlogRestApi getBlogById(@PathParam("param") Integer param) throws Exception {
			BlogService blogService = new BlogService();
			Blog blog = blogService.getById(param);
			BlogRestApi  blogRA = null;
			
			if (blog != null)
			 blogRA= new BlogRestApi(blog.getBlogId(), 
					 blog.getTitle(), 
					 blog.getContent(), 
					 blog.getPostDate(), 
					                         
					 blog.getUser() == null ? "anonymous": blog.getUser().getName(), 
							 blog.getUser() == null ? 0:blog.getUser().getUserId() );
			return blogRA;
		}

		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<BlogRestApi> BlogGet() throws Exception {
			BlogRestApi  blogRA = new BlogRestApi();
			return  blogRA.BlogGetAll();
		}
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void BlogUpdate(BlogRestApi blogApi) throws Exception {
			UserService userService = new UserService();
			User user = userService.getById(1);
			System.out.println(user.toString());
			System.out.println(blogApi.toString());
			Blog blog = new Blog(title,content, user);
			BlogService blogService  = new BlogService() ;
			blogService.update(blog);
		} 

		
		public void blogCreate() throws Exception {
			UserService userService = new UserService();
			User user = userService.getById(1);
			Blog blog = new Blog(this.title ,this.content, user);
			BlogService blogService  = new BlogService() ;
			System.out.println(user.toString());
			System.out.println(blog.toString());
			blogService.create(blog);
			System.out.println("Done");
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void AddBlog(BlogRestApi blogApi) throws Exception {
			blogApi.blogCreate();
		}
		
		@DELETE
		public void blogDelete(String id) throws Exception {
			BlogService blogService  = new BlogService() ;
			blogService.delete(id);
		}
	}

