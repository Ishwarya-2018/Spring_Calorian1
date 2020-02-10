package com.clarion.fundonote.repository;

import java.util.List;

import com.clarion.fundonote.model.UserNotes;

public interface NoteRepository {
	
	UserNotes saveNote(UserNotes userNote);
	
	void updateNote(UserNotes userNotes);
	
	void deleteNote(UserNotes userNotes);
	
	List<UserNotes> getAllNotes(Long userId);
	
	UserNotes findNotesById(Long userId);
	
}


