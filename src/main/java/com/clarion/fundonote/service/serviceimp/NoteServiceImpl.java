package com.clarion.fundonote.service.serviceimp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarion.fundonote.dto.UserNoteDTO;
import com.clarion.fundonote.model.UserDetails;
import com.clarion.fundonote.model.UserNotes;
import com.clarion.fundonote.repository.NoteRepository;
import com.clarion.fundonote.repository.UserRepository;
import com.clarion.fundonote.service.NoteService;
import com.clarion.fundonote.utils.JwtUtility;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NoteRepository noteRepository;

	@Autowired
	private ModelMapper modelMapper;

	public UserNotes createNote(UserNoteDTO userNoteDto, String token) {
		Long userId = JwtUtility.validateToken(token);
		UserNotes notes = null;
		if (userId != null) {
			UserDetails userDetails = userRepository.findUserById(userId);
			if (userDetails!=null)
				notes = modelMapper.map(userNoteDto, UserNotes.class);
			notes.setCreatedDateTime(LocalDateTime.now());
			notes.setUpdatedDateTime(LocalDateTime.now());
		    noteRepository.saveNote(notes);
			return notes;
		}
		return notes;
	}

	@Override
	public UserNotes deleteNote(Long noteId, String token) {
		Long userId = JwtUtility.validateToken(token);
		UserDetails userDetails = userRepository.findUserById(userId);
		UserNotes notes = null;
		if (userDetails!=null && noteId != null) {
			UserNotes userNotes=noteRepository.findNotesById(noteId);
		    noteRepository.deleteNote(userNotes);
		}
		return notes;
	}

	@Override
	public UserNotes updateNotes(UserNotes updateNoteDto, String token) {
		Long userId = JwtUtility.validateToken(token);
		UserDetails userDetails = userRepository.findUserById(userId);
		UserNotes note = null;
		if (userDetails!=null)
			note = noteRepository.findNotesById(updateNoteDto.getId());
		note.setNoteTitle(updateNoteDto.getNoteTitle());
		note.setDescription(updateNoteDto.getDescription());
		note.setUpdatedDateTime(LocalDateTime.now());
		noteRepository.saveNote(note);
		return note;
	}

	@Override
	public List<UserNotes> getNotes(String token) {
		Long userId = JwtUtility.validateToken(token);
		UserDetails userDetails = userRepository.findUserById(userId);
		List<UserNotes> notes = null;
		if (userDetails!=null) {
			notes = userDetails.getNotes();
		}
		return notes;
	}

	
	
	@Override
	public List<UserNotes> getNotesForUser(String email, String token) {
		Long userId = JwtUtility.validateToken(token);
		UserDetails userDetails = userRepository.findUserById(userId);
		List<UserNotes> notes = null;
		if (userDetails!=null) {
			UserDetails searchUserDetails = userRepository.findByEmail(email);
			if (searchUserDetails!=null)
				notes = noteRepository.getAllNotes(userId);
		}
		return notes;
	}

	
}
