package cecy.cecy_backend.cecy_certificados.auth;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import cecy.cecy_backend.cecy_certificados.estudiantes.EstudiantesRepository;
import cecy.cecy_backend.cecy_certificados.estudiantes.Role;
import cecy.cecy_backend.config.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EstudiantesRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Estudiantes request){

        request.setClave(passwordEncoder.encode(request.getClave()));
        request.setRol(Role.ESTUDIANTE);

        repository.save(request);

        var jwtToken = service.generateToken(request);
        return AuthenticationResponse.builder()
        .token(jwtToken)
        .cedula(request.getCedula())
        .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCedula(), request.getClave()));
        var user = repository.findByCedula(request.getCedula()).orElseThrow();

        var jwtToken = service.generateToken(user);
        return AuthenticationResponse.builder()
        .token(jwtToken)
        .cedula(user.getCedula())
        .build();
    }
    
}
