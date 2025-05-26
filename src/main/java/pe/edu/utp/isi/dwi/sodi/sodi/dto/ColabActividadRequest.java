package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColabActividadRequest {
    

    private int codSolicitud; //oAsignacion
    private String descripcionAct;

    // private LocalDateTime fechaActividad;

    private double tiempoConsumido;
    
}
