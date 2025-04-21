package pe.edu.utp.isi.dwi.sodi.sodi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    private String codigo;
    private String tipo; //Error, capacitación, tequerimiento
    private String motivo;
    private String fecha;
    private String estado; //Pendiente en progreso y finalizado

    public Solicitud(String codigo) {
        this.codigo = codigo;
    }
    
    

}
