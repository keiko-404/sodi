package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByoCuenta_Correo(String correo);




}
