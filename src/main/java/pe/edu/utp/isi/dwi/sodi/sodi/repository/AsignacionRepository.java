package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Asignacion;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer>{
    
}
