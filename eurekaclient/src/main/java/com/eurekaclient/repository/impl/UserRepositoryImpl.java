package com.eurekaclient.repository.impl;

import com.eurekaclient.entity.User;
import com.eurekaclient.repository.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static Map<Long, User> userMap;
	static {
		userMap = new HashMap<>();
		userMap.put(1L, new User(1L, "user1", 22));
		userMap.put(2L, new User(2L, "user2", 23));
		userMap.put(3L, new User(3L, "user3", 24));
	}

	@Override
	public Collection<User> findAll() {
		return userMap.values();
	}

	@Override
	public User findById(long id) {
		return userMap.get(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		userMap.put(user.getId(), user);
	}

	@Override
	public void deleteById(long id) {
		userMap.remove(id);
	}
}
