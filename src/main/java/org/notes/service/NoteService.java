package org.notes.service;

import lombok.extern.slf4j.Slf4j;
import org.notes.exception.EntityNotFoundException;
import org.notes.model.Note;
import org.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j // logger module
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note create(String title, String body) {
        try {
            log.info("User is trying to create a note with title - " + title);
            Note note = Note.builder()
                            .id(UUID.randomUUID().toString())
                            .title(title)
                            .body(body).build();
            return noteRepository.save(note);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public Note update(String id, String title ,String body) {
        try {
            Note note = Note.builder().
                    id(id).title(title).body(body).build();
            return noteRepository.save(note);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public Note delete(String id) {
        try {
            Note note = null;
            Optional<Note> foundNote = noteRepository.findById(id);
            if (foundNote.isPresent()) {
                note = foundNote.get();
                noteRepository.deleteById(note.getId());
            }
            return note;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public List<Note> findAll() {
        try {
            return noteRepository.findAll();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ArrayList<>();
    }

    public Note findById(String id) {
        Optional<Note> note = noteRepository.findById(id);
        if(note.isPresent())
            return note.get();
        throw new EntityNotFoundException("Note not found!");
    }
}
