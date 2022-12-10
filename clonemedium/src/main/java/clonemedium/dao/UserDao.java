package clonemedium.dao;

import java.util.ArrayList;
import java.util.List;

import clonemedium.model.Blog;
import clonemedium.model.BlogStatus;
import clonemedium.model.Tag;
import clonemedium.model.User;

public class UserDao
{
	private static List<User> userList = new ArrayList<User>();

	private TagDao tagDao = new TagDao();

	private BlogDao blogDao = new BlogDao();

	public User createUser(User user)
	{
		userList.add(user);
		return user;
	}

	public List<User> getAll()
	{
		return userList;
	}

	public void followUser(User src, User dst)
	{
		if (!userList.contains(src))
		{
			System.out.println("Source user not found!");
			return;
		}
		if (!userList.contains(dst))
		{
			System.out.println("Destination user not found!");
			return;
		}
		src.getFollowedUsers().add(dst);
		dst.getFollowerUsers().add(src);
	}

	public void unFollowUser(User src, User dst)
	{
		if (!userList.contains(src))
		{
			System.out.println("Source user not found!");
			return;
		}
		if (!userList.contains(dst))
		{
			System.out.println("Destination user not found!");
			return;
		}
		src.getFollowedUsers().remove(dst);
		dst.getFollowerUsers().remove(src);
	}

	public void followTag(User user, Tag tag)
	{
		if (!userList.contains(user))
		{
			System.out.println("User not found!");
			return;
		}
		if (!tagDao.getAll().contains(tag))
		{
			System.out.println("Tag not found!");
			return;
		}
		user.getFollowedTags().add(tag);

	}

	public void unFollowTag(User user, Tag tag)
	{
		if (!userList.contains(user))
		{
			System.out.println("User not found!");
			return;
		}
		if (!tagDao.getAll().contains(tag))
		{
			System.out.println("Tag not found!");
			return;
		}
		user.getFollowedTags().remove(tag);
	}

	public void writeDraft(User user, Blog blog, String ans)
	{
		if (!userList.contains(user))
		{
			System.out.println("User not found!");
			return;
		}
		if (!blogDao.getAll().contains(blog))
		{
			System.out.println("Blog not found!");
			return;
		}
		if (ans.equalsIgnoreCase("y"))
		{
			blog.setBlogStatus(BlogStatus.PUBLISHED);
			System.out.println(blog.getTitle()+" is now published.");
		}
		user.getBlogs().add(blog);
	}

	public void deleteBlog(User user, Blog blog)
	{
		if (!userList.contains(user))
		{
			System.out.println("User not found!");
			return;
		}
		if (!blogDao.getAll().contains(blog))
		{
			System.out.println("Blog not found!");
			return;
		}
		user.getBlogs().remove(blog);
		
	}

}
