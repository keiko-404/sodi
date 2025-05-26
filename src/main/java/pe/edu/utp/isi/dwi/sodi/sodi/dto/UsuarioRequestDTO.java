package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombreUsuario;
   //private String correo;
    private int codCliente;

    // inactivo ya que al registrar uusario estaria tambien registrando la solicitud
//    @Builder.Default
//    private List<SolicitudRequest> lSolicitudesDTO = new ArrayList<>();
}
