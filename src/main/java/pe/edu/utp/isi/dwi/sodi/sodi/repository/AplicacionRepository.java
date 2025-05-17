package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Aplicacion;

@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer>{
    Optional<Aplicacion> findById(int codAplicacion);
}
