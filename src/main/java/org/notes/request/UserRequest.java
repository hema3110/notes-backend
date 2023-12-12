package org.notes.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserRequest {
    @NotEmpty(message = "firstName cannot be empty")
    @Size(min = 3, max = 64, message = "firstName length should be greater than 3 and less than 64 characters.")
    private String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    @Size(min = 3, max = 64, message = "lastName length should be greater than 3 and less than 64 characters.")
    private String lastName;

    @NotEmpty(message = "email cannot be empty")
    @Size(min = 3, max = 64, message = "email length should be greater than 3 and less than 64 characters.")
    @Email(message = "Provided string is not a valid email")
    private String email;

    @NotEmpty(message = "mobileNumber cannot be empty")
    @Size(max = 10, min = 10, message = "mobileNumber length should be of 10 characters.")
    private int mobileNumber;
}
