package org.notes.controller;

import org.notes.model.User;
import org.notes.request.UserRequest;
import org.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody @Valid UserRequest request) {
        User user = userService.create(request.getFirstName(), request.getLastName(), request.getEmail(), request.getMobileNumber());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") String id) {
        return new ResponseEntity<User>(userService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") String id,@RequestBody @Valid UserRequest request) {
        return new ResponseEntity<User>(userService.update(id, request.getFirstName(), request.getLastName(), request.getEmail(), request.getMobileNumber()), HttpStatus.OK);
    }

}
