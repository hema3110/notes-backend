package org.notes.repository;

import org.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
//    @Query("select n from notes n where n.isActive = true")
    List<Note> findAllByIsActiveTrue();
}
