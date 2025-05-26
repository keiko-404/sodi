package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    Optional<Cuenta> findByCorreo(String correo);
}
