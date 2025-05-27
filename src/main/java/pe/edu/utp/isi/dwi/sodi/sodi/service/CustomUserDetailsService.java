package pe.edu.utp.isi.dwi.sodi.sodi.service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.CuentaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Cuenta cuenta = cuentaRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Cuenta no encontrada"));

        String nombreRol = cuenta.getORoles().getRol();

        return new User(
                cuenta.getCorreo(),
                cuenta.getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + nombreRol.toUpperCase()))
        );
    }
}
