package web.capstone.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.capstone.dao.UserRepository;
import web.capstone.entities.User;
import web.capstone.model.request.AuthenticateUserRequest;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://wgu-visionvault-client-fd3e7c032ecb.herokuapp.com")
@RequestMapping("")
public class UserController {
    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping(path = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> authenticateUser(@RequestBody AuthenticateUserRequest request) {
        System.out.println("request: " + request.getEmail() + request.getPassword());
        Optional<User> foundUser = userRepository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());
        if (foundUser.isPresent()) {
            return new ResponseEntity<>(foundUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
