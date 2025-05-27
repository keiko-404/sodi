package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudResponseDTO {

    private int codSolicitud;
    private String nombreUsuario; //oUsuario
    private String nombreAplicacion;  //oAplicacion
    private String motivo;
    private String tipoSolicitud;
    private String prioridad;
    private String estado;
    private LocalDateTime fechaCreacion;

    private List<ColaboradorAsignadoDTO> colaboradoresAsignadosDTO;

}
