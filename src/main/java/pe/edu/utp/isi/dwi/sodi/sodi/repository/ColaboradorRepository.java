package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    // Buscar colaboradores por rol exacto (por ejemplo: "Analista")

    List<Colaborador> findByRol(String rol);

    // Buscar colaboradores que tengan alguno de estos roles: "Programador", "Diseñador"
    List<Colaborador> findByRolIn(List<String> roles);

    Optional<Colaborador> findByoCuenta_Correo(String correo);
}
