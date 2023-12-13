package org.notes.controller;

import org.notes.model.Note;
import org.notes.request.NoteRequest;
import org.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NotesController {

    @Autowired
    private NoteService notesService;

    @PostMapping("/create")
    public ResponseEntity<Note> create(@RequestBody @Valid NoteRequest request) {
        Note note = notesService.create(request.getTitle(), request.getBody());
        return new ResponseEntity<Note>(note, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> findAll() {
        return new ResponseEntity<List<Note>>(notesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") String id) {
        return new ResponseEntity<Note>(notesService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable("id") String id,@RequestBody @Valid NoteRequest request) {
        return new ResponseEntity<Note>(notesService.update(id, request.getTitle(), request.getBody()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteOrInsert(@PathVariable("id") String id) {
        return new ResponseEntity<Note>(notesService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Note> updateOrInsert(@PathVariable("id") String id) {
        return new ResponseEntity<Note>(notesService.delete(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> upsert(@PathVariable("id") String id) {
        return new ResponseEntity<Note>(notesService.delete(id), HttpStatus.OK);
    }
}
