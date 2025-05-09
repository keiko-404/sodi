package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Actividad;

@Repository
public interface ActividadRespository extends JpaRepository<Actividad, Integer>{
    
}
