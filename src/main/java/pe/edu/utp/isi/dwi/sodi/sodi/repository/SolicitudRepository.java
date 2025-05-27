package pe.edu.utp.isi.dwi.sodi.sodi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    @Query("SELECT s FROM Solicitud s JOIN s.lAsignaciones a WHERE a.oColaborador.codColaborador = :codColaborador")
    List<Solicitud> findByColaboradorId(@Param("codColaborador") int codColaborador);

    @Query("SELECT s FROM Solicitud s "
            + "JOIN FETCH s.oUsuario u "
            + "JOIN FETCH u.oCuenta c "
            + "WHERE c.correo = :correo")
    List<Solicitud> findByCorreoUsuario(@Param("correo") String correo);

}
