package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRequest {

    private int codAplicacion;  // oAplicacion pasarlo a nombre

    private String motivo;

    private String tipoSolicitud;


}
