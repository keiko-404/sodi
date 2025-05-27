package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Administrador;

@Repository
public interface AdminRepository extends JpaRepository<Administrador, Integer>{
    Optional<Administrador> findByoCuenta_Correo(String correo);
}
