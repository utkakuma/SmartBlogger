package com.smartblogger.service;

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
	
	import com.smartblogger.model.User;


	@Path("/users")
	public class UserRestAPi {
		protected int userId;

		protected String name;
		protected String email;
	
		protected String password;
		
		public UserRestAPi (int userId,  String name, String email) {
		
			this.name = name;
			this.email = email;
			this.userId = userId;
		}
		
		public UserRestAPi (  String name, String email, String password) {

			this.name = name;
			this.email = email;
			this.password = password;
		}

		public UserRestAPi (int userId,  String name, String email, String password) {
			
			this.name = name;
			this.email = email;
			this.userId = userId;
			this.password = password;
		}
		public UserRestAPi ( ) {

		}
		
		public int getUserId() {
			return this.userId;
		}
		
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public String getName() {
			return this.name;
		}
		
		
		public String getEmail() {
			return this.email;
		}
		
		public String getPassword() {
			return this.password;
		}
		
		public void setPassword(String password) {
			this.password =  password;
		}

		public void userWrite() throws Exception {
			User user = new User(name,email, password);
			UserService userService  = new UserService() ;
			userService.create(user);
		}
		
		public UserRestAPi checkloginuser() throws Exception {
			
			User user = null;
			UserRestAPi userRestAPi = null;
			
			UserService userService  = new UserService() ;
				user = userService.getByLoginInfo(email, password);
				if(user != null) {
				userRestAPi = new UserRestAPi (user.getUserId(), user.getName(),  user.getEmailId());
				}
			return userRestAPi;
				
		}
		
		public List<UserRestAPi> userReadAll() throws Exception {
			UserService userService  = new UserService() ;
			List<UserRestAPi> list = new ArrayList<UserRestAPi>();
			List<User> user = userService.getAll();
			for (User b : user) {
				UserRestAPi up = new UserRestAPi(b.getUserId(), b.getName(),  b.getEmailId(), b.getPassword());
				list.add(up);
			}
			return list;
		}
		
		@GET
		@Path("/{param}")
		@Produces(MediaType.APPLICATION_JSON)
		public UserRestAPi userGet(@PathParam("param") Integer param) throws Exception {
			String username=null;
			Integer id = 1;
			User user = null;
			UserRestAPi userRestAPi;
			
			UserService userService  = new UserService() ;
			try{
				if (param > 0) {
					id = param;
				}
			} catch (Exception e) {
				username = null;
			}
			
			if (username == null) {
				user = userService.getById(id);
				userRestAPi = new UserRestAPi (user.getUserId(), user.getName(),  user.getEmailId());
			} else {
				user = userService.getByUsername(username);
				userRestAPi = new UserRestAPi (user.getUserId(), user.getName(),  user.getEmailId());
			}
			return userRestAPi;
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void UserCreate(UserRestAPi user) throws Exception {
			user.userWrite();
		}
		
		@POST
		@Path("/{param}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public UserRestAPi getLoginUser(UserRestAPi user, @PathParam("param") String param) throws Exception {
			return user.checkloginuser();
			}
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void UserUpdate(UserRestAPi user) throws Exception {
			user.userWrite();
		} 
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<UserRestAPi> ueseGet() throws Exception {
			UserRestAPi  a = new UserRestAPi();
			return a.userReadAll();
		}
		
		@DELETE
		@Path("/{param}")
		public void DeleteUser(@PathParam("param") String param) throws Exception {
			String username=null;
			String id = null;
			User user = null;
			
			UserService userService  = new UserService() ;
			try{
				if (Integer.parseInt(param) > 0) {
					id = param;
				}
			} catch (Exception e) {
				username = param;
			}
			
			if (username == null) {
				userService.delete(id);
			} else {
				user = userService.getByUsername(username);
				userService.delete(String.valueOf(user.getUserId())) ;
			}
		}
	
}
