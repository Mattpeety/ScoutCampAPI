package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@AllArgsConstructor
//@RequestMapping(LoginController.LOGIN)
//public class LoginController {
//
//    private final AuthenticationManager authenticationManager;
//
//    public static final String LOGIN = "/login";
//    public static final String FORM = "/form";

//    @PostMapping(FORM)
//    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
//        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
//                .unauthenticated(loginRequest.username(), loginRequest.password());
//        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    public record LoginRequest(String username, String password) {
//    }
//}
