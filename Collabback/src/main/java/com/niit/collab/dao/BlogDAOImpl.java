package com.niit.collab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collab.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean createBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("A problem has occured:"+e);
			return false;
		}
		
	}

	@Override
	public Blog getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listBlog=query.list();
		session.close();
		return listBlog;
		
	}

	
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
		 blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean editBlog(int blogid) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteBlog(int blogid) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
