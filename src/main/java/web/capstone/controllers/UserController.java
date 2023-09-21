package web.capstone.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.capstone.model.AuthenticationResponse;
import web.capstone.model.request.AuthenticationRequest;
import web.capstone.model.request.SignUpRequest;
import web.capstone.services.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/users")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponse> signUp(@RequestBody SignUpRequest request) {
    return ResponseEntity.ok(authenticationService.signUp(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }
}
