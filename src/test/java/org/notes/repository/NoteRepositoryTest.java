package org.notes.repository;

import org.junit.jupiter.api.Test;
import org.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void findAllByIsActiveTrueTest() {
        List<Note> notes = new ArrayList<>();
        Note note1 = Note.builder().id(UUID.randomUUID().toString())
                .title("Title 1").body("Body 1").isActive(true).build();
        notes.add(note1);
        Note note2 = Note.builder().id(UUID.randomUUID().toString())
                .title("Title 2").body("Body 2").isActive(false).build();
        notes.add(note2);
        noteRepository.saveAll(notes);

        List<Note> notesActive = noteRepository.findAllByIsActiveTrue();
        assertEquals(notesActive.size(), 1);
    }

    @Test
    public void findByIdTest() {
        String noteId = UUID.randomUUID().toString();
        Note note = Note.builder().id(noteId)
                .title("Title 1").body("Body 1").isActive(true).build();
        noteRepository.save(note);
        Optional<Note> foundNote = noteRepository.findById(noteId);
        assertNotNull(foundNote.get());
        assertEquals(foundNote.get().getId(), noteId);
    }

    @Test
    public void deleteByIdTest() {
        String noteId = UUID.randomUUID().toString();
        Note note = Note.builder().id(noteId).title(" note 1").body("note 1 body").isActive(true).build();
        noteRepository.save(note);
        noteRepository.deleteById(noteId);
        boolean isExists = noteRepository.existsById(noteId);
        assertFalse(isExists);
    }
}
