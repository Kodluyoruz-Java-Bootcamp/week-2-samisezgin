package clonemedium.services;

import java.util.List;

import clonemedium.dao.BlogDao;
import clonemedium.model.Blog;
import clonemedium.model.BlogStatus;
import clonemedium.model.Tag;

public class BlogService
{
	private BlogDao blogDao = new BlogDao();

	public Blog createBlog(Blog blog)
	{
		blogDao.createBlog(blog);
		return blog;
	}
	
	

	public boolean removeBlog(Blog blog)
	{
		return blogDao.removeBlog(blog);
	}

	public List<Blog> getAll()
	{
		return blogDao.getAll();
	}
	
	public void printAllBlogs()
	{
		blogDao.getAll().forEach(blog->System.out.println("Username: " + blog.getUser().getUserName() + "\tBlog Title: " + blog.getTitle()));
	}

	public void addBlogToTag(Blog blog, Tag tag)
	{
		blogDao.addBlogToTag(blog, tag);
	}

	public void removeBlogFromTag(Blog blog, Tag tag)
	{
		blogDao.removeBlogFromTag(blog, tag);
	}

	public void publishBlog(Blog blog)
	{
		blogDao.setBlogStatus(blog, BlogStatus.PUBLISHED);
	}

	public void deleteBlog(Blog blog)
	{
		blogDao.setBlogStatus(blog, BlogStatus.DELETED);
	}

	public void draftBlog(Blog blog)
	{
		blogDao.setBlogStatus(blog, BlogStatus.DRAFT);
	}

}
