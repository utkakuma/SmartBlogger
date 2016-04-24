package com.smartblogger.service;

import java.util.List;

import com.smartblogger.dao.BlogDAO;
import com.smartblogger.model.Blog;

public class BlogService {
	private static BlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	public void create(Blog blog) throws Exception {
		blogDAO.openCurrentSessionwithTransaction();
		try {
			blogDAO.create(blog);
		} catch (Exception e) {
			blogDAO.closeCurrentSessionOnException();
			throw e;
		} 
		blogDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Blog blog) throws Exception {
		blogDAO.openCurrentSessionwithTransaction();
		try {
			blogDAO.update(blog);
		} catch (Exception e) {
			blogDAO.closeCurrentSessionOnException();
			throw e;
		} 
		blogDAO.closeCurrentSessionwithTransaction();
	}
	
	public Blog getById(String id) {
		blogDAO.openCurrentSession();
		Blog Blog = blogDAO.getById(id);
		blogDAO.closeCurrentSession();
		return Blog;
	}

	public Blog getById(Integer id) {
		blogDAO.openCurrentSession();
		Blog Blog = blogDAO.getById(id);
		blogDAO.closeCurrentSession();
		return Blog;
	}
	
	public void delete(String id) throws Exception {
		blogDAO.openCurrentSessionwithTransaction();
		Blog Blog = blogDAO.getById(id);
		try {
			blogDAO.delete(Blog);
		} catch (Exception e) {
			blogDAO.closeCurrentSessionOnException();
			throw e;
		} 		
		blogDAO.closeCurrentSessionwithTransaction();
	}

	public List<Blog> getAll() {
		blogDAO.openCurrentSession();
		List<Blog> Blog = blogDAO.getAll();
		blogDAO.closeCurrentSession();
		return Blog;
	}
	
	public void deleteAll() throws Exception {
		blogDAO.openCurrentSessionwithTransaction();
		try {
			blogDAO.deleteAll();
		} catch (Exception e) {
			blogDAO.closeCurrentSessionOnException();
			throw e;
		}
		blogDAO.closeCurrentSessionwithTransaction();
	}

	public BlogDAO BlogDAO() {
		return blogDAO;
	}
}

