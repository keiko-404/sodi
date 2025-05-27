package pe.edu.utp.isi.dwi.sodi.sodi.mapper;

import pe.edu.utp.isi.dwi.sodi.sodi.dto.UsuarioDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cliente;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;

public class UsuarioMapper {

    // vista usuario
    public static UsuarioDTO toUsuarioDTO(Cuenta cuenta, Cliente cliente, String nombreUsuario) {

        return UsuarioDTO.builder()
                .correo(cuenta != null ? cuenta.getCorreo() : null)
                .nombreCliente(cliente != null ? cliente.getNombreCliente() : null)
                .nombreUsuario(nombreUsuario)
                .build();
    }
}
