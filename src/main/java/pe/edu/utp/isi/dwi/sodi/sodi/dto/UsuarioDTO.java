package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String correo; // oCuenta
    private String nombreCliente; // oCliente
    private String nombreUsuario; //ordenaar

}
