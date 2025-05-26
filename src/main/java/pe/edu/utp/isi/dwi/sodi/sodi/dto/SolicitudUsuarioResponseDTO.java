package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudUsuarioResponseDTO {

    private int codSolicitud;
    private String nombreAplicacion;
    private String motivo;
    private String tipoSolicitud;
    private String estado;
    private LocalDateTime fechaCreacion;
}
