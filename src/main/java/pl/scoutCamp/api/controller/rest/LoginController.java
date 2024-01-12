package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

////TODO: create login endpoint
@RestController
@AllArgsConstructor
@RequestMapping(LoginController.LOGIN)
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    public static final String SIGNIN = "/signin";



//    @ResponseBody
//    @RequestMapping(value = SIGNIN, method = RequestMethod.POST)
//    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
//        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
//                .unauthenticated(loginRequest.username(), loginRequest.password());
//        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    public record LoginRequest(String username, String password) {
//    }

//    @PostMapping(value = REGISTER)

}
