package com.smartblogger.test;

//import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

public class BlogTest {

//	@Before
	public void setUp() throws Exception {
	}

//	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testQuery() {
		BlogDAO blogDAO = new BlogDAO();
		
		List<Blog> blogList = blogDAO.getBlogsWithUserID(1);
		
		Iterator itr = blogList.iterator();
		
		while (itr.hasNext()) {
			Blog blog = (Blog) itr.next();
			System.out.println(blog.toString());
			System.out.println(blog.getUser().getName());
		}
			
	}
	/**/
	/*
	@Test
	public void testQuery2() {
		BlogDAO blogDAO = new BlogDAO();
		
		Session ses = HibernateUtil.currentSession();
		try {
			String queryString = "from Blog";
			Query query = ses.createQuery(queryString);

			List<Blog> blogList = query.list();
			Iterator itr = blogList.iterator();
			
			while (itr.hasNext()) {
				Blog blog = (Blog) itr.next();
				System.out.println(blog.toString());
			}
		} finally {
			HibernateUtil.closeSession();
		}		

			
	}/**/
	/*
	@Test
	public void testAssociation() {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		User user1 = new User();
		user1.setEmailId("utkakuma@cisco.com");
		user1.setName("utkarsh");
		user1.setPassword("kumar");
		
		Blog blog1 = new Blog();
		blog1.setTitle("Java");
		blog1.setTag("object");
		blog1.setContent("Java is a object oriented language.");
		
		Blog blog2 = new Blog();
		blog2.setTitle("Java2");
		blog2.setTag("object2");
		blog2.setContent("Java2 is a object oriented language.");
		
		user1.addBlog(blog1);
		user1.addBlog(blog2);

		Transaction transaction=session.beginTransaction();
				
		session.save(user1);
		
		
		transaction.commit();
		session.close();
	}
	/**/


}
