package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRol(String rol);
}
