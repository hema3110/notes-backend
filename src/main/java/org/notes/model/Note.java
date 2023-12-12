package org.notes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "notes")
public class Note {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "active")
    @Builder.Default
    private boolean isActive = true;

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "modified_at")
    @Builder.Default
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Note [id = " + id + "]";
    }
}
