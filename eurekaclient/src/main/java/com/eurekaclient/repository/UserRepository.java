package com.eurekaclient.repository;

import com.eurekaclient.entity.User;
import java.util.Collection;

public interface UserRepository {
	public Collection<User> findAll();

	public User findById(long id);

	public void saveOrUpdate(User user);

	public void deleteById(long id);
}