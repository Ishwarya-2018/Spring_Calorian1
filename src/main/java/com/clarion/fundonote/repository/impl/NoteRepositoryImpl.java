package com.clarion.fundonote.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarion.fundonote.model.UserNotes;
import com.clarion.fundonote.repository.NoteRepository;

@Repository
public class NoteRepositoryImpl implements NoteRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public UserNotes saveNote(UserNotes userNote) {
		Session currentSession=entityManager.unwrap(Session.class);
		Long id=(Long) currentSession.save(userNote);
		if(id <=0) {
			return null;
		}
		return userNote;
	}

	@Override
	public void updateNote(UserNotes userNotes) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.update(userNotes);
	}

	@Override
	public void deleteNote(UserNotes userNotes) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.delete(userNotes);
		
		
	}

	@Override
	public List<UserNotes> getAllNotes(Long userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<UserNotes> query=currentSession.createQuery("from UserNotes where user_id="+userId,UserNotes.class);
		List<UserNotes> notesList=query.getResultList();
		return notesList;
	}

	@Override
	public UserNotes findNotesById(Long userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		UserNotes userNote=currentSession.get(UserNotes.class,userId);
		return userNote;
	}

}
