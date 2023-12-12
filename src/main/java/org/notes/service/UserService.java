package org.notes.service;

import lombok.extern.slf4j.Slf4j;
import org.notes.model.User;
import org.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(String firstName, String lastName, String email, int mobileNumber) {
        try{
            log.info("User is trying to create a user record with email " + email);
            User user = User.builder().id(UUID.randomUUID().toString())
                    .firstName(firstName).lastName(lastName)
                    .email(email).mobileNumber(mobileNumber).build();
            return userRepository.save(user);
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);

        }
        return null;
    }

    public User update(String id, String firstName, String lastName, String email, int mobileNumber) {
        try {
            User user = User.builder().id(id)
                    .firstName(firstName).lastName(lastName)
                    .email(email).mobileNumber(mobileNumber).build();
            return userRepository.save(user);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public User delete(String id) {
        try {
            User user = null;
            Optional<User> foundUser = userRepository.findById(id);
            if (foundUser.isPresent()) {
                user = foundUser.get();
                userRepository.deleteById(user.getId());
            }
            return user;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ArrayList<>();
    }
}


