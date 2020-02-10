package com.clarion.fundonote.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarion.fundonote.model.UserDetails;
import com.clarion.fundonote.repository.UserRepository;
@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public UserDetails findByEmail(String email) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<UserDetails> query=currentSession.createQuery("from UserDetails where Email='"+email+"'",UserDetails.class);
		List<UserDetails> userList=query.getResultList();
		UserDetails user=userList.get(0);
		return user;
		}

	@Override
	public UserDetails saveUser(UserDetails userDetails) {
		Session currentSession=entityManager.unwrap(Session.class);
		Long userId=(Long) currentSession.save(userDetails);
		if(userId <= 0) {
			return null;
		}
		return userDetails;
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.update(userDetails);
		return userDetails;
				
	}

	@Override
	public UserDetails deleteUser(UserDetails userDetails) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.delete(userDetails);
		return userDetails;
	}

	@Override
	public List<UserDetails> getUserList() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<UserDetails> query=currentSession.createQuery("from UserDetails",UserDetails.class);
		List<UserDetails> userList=query.getResultList();
		return userList;
	}

	@Override
	public UserDetails findUserById(Long userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		UserDetails userDetails=currentSession.get(UserDetails.class, userId);
		return userDetails;
	}
	
	
	
	

}
