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
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(name = "email", length = 64, unique = true)
    private String email;

    @Column(name = "mobile_number", length = 10, unique = true)
    private int mobileNumber;

    @Column(name = "active")
    @Builder.Default
    private boolean isActive = true ;

    @Column(name = "created_At")
    @Builder.Default
    private LocalDateTime created_At = LocalDateTime.now();

    @Column(name = "modified_At")
    @Builder.Default
    private LocalDateTime modified_At = LocalDateTime.now();

}
