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

    private int codUsuario; // oUsuario

    private int codAplicacion;  // oAplicacion

    private String motivo;

    private String tipoSolicitud; //Error de software, capacitación, tequerimiento

    // el sistema lo elige
    //private String prioridad; //Alto, medio, bajo
    // se muestra autom
    //private String fechaCreacion;
    // el sistema lo elige
    //private String estado; //Pendiente, en progreso y finalizado
}
