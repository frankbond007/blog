package com.niit.collab.dao;
import java.util.List;
import com.niit.collab.model.Blog;

public interface BlogDAO {
	public boolean createBlog(Blog blog);
	public Blog getBlog();
	public List<Blog> getBlogs();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(int blogid);
	public boolean deleteBlog(int blogid);
	

}
