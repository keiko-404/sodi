package pe.edu.utp.isi.dwi.sodi.sodi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.CuentaRepository;

@Service
public class CuentaService {
    
    private final CuentaRepository cuentaRepository;
    private final PasswordEncoder passwordEncoder;

    public CuentaService(CuentaRepository cuentaRepository, PasswordEncoder passwordEncoder) {
        this.cuentaRepository = cuentaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    
    // CREAR 
    public Cuenta crearCuenta(Cuenta cuenta) {
                // Hashea la contraseña antes de guardar
        String contrasenaHasheada = passwordEncoder.encode(cuenta.getContrasena());
        cuenta.setContrasena(contrasenaHasheada);

        return cuentaRepository.save(cuenta);
    }
    
}
