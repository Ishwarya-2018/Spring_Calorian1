package com.clarion.fundonote.service;
import java.util.List;

import com.clarion.fundonote.dto.UserNoteDTO;
import com.clarion.fundonote.model.UserNotes;

public interface NoteService {
	UserNotes createNote(UserNoteDTO userNoteDto, String token);

	UserNotes deleteNote(Long noteId, String token);

	UserNotes updateNotes(UserNotes updateNoteDto, String token);

	List<UserNotes> getNotes(String token);
	
	List<UserNotes> getNotesForUser(String email, String token);


}
