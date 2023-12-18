package org.notes.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.notes.model.Note;
import org.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class NoteServiceTest {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Test
    public void findAllActiveTest() {
        List<Note> notes = new ArrayList<>();
        Note note1 = Note.builder().id(UUID.randomUUID().toString())
                .title("Title 1").body("Body 1").isActive(true).build();
        notes.add(note1);
        Note note2 = Note.builder().id(UUID.randomUUID().toString())
                .title("Title 2").body("Body 2").isActive(false).build();
        notes.add(note2);
        List<Note> notesInserted = noteRepository.saveAll(notes);
        log.info("Inserted notes - " + notesInserted.size());

        List<Note> notesActive = noteService.findAllActive();
        assertEquals(notesActive.size(), 1);
    }

//    @Test
//    public void findAllActiveErrorTest() {
//        List<Note> notesActive = noteService.findAllActive();
//        assertEquals(notesActive.size(), 0);
//    }
}
