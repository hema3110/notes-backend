package org.notes.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class NoteRequest {
    @NotEmpty(message = "Title cannot be null.")
    @Size(min = 2, max = 128, message = "Title length should be greater than 2 and less than 128 characters.")
    private String title;

    @Size(min = 3, max = 256, message = "Body length should be greater than 3 and less than 256 characters.")
    private String body;
}
