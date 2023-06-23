package cecy.cecy_backend.cecy_certificados.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import feign.Response;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/register/")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Estudiantes request){
        return ResponseEntity.ok(service.register(request));
    }    
    
    @PostMapping("/authenticate/")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }


}
