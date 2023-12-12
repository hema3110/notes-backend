package org.notes.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ResponseBase {
    private boolean isValid;

    private List<String> messages;

    @Builder.Default
    private LocalDateTime completed = LocalDateTime.now();
}
