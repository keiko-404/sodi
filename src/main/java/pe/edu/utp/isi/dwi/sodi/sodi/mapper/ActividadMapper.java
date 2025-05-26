package pe.edu.utp.isi.dwi.sodi.sodi.mapper;

import java.time.LocalDateTime;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.ColabActividadRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Actividad;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Asignacion;

/**
 *
 * @author #RoaAlyc '^'
 */
public class ActividadMapper {
    
    public static Actividad toActividad(ColabActividadRequest dto, Asignacion asignacion) {
        
        Actividad actividad = new Actividad();
        actividad.setOAsignacion(asignacion);
        actividad.setDescripcionAct(dto.getDescripcionAct());
        
        //fecha autom.
        actividad.setFechaActividad(LocalDateTime.now());
        
        actividad.setTiempoConsumido(dto.getTiempoConsumido());
        return actividad;
    }
    
}
