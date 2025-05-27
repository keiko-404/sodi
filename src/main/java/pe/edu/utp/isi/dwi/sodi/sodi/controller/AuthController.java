package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.CuentaRepository;
import pe.edu.utp.isi.dwi.sodi.sodi.service.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;
    private final CuentaRepository cuentaRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtService jwtService, CuentaRepository cuentaRepository, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.cuentaRepository = cuentaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String correo, @RequestParam String contrasena) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findByCorreo(correo);

        if (cuentaOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Cuenta no encontrada");
        }

        Cuenta cuenta = cuentaOpt.get();

        if (!passwordEncoder.matches(contrasena, cuenta.getContrasena())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        // Obtener el nombre del rol como lista
        String nombreRol = cuenta.getORoles().getRol().replace("ROLE_", ""); // por ejemplo: "ROLE_ADMIN"
        List<String> roles = Collections.singletonList(nombreRol);

        return ResponseEntity.ok(jwtService.generateToken(correo, roles));

    }
}
