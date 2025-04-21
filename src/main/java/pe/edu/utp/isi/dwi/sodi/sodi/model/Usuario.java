package pe.edu.utp.isi.dwi.sodi.sodi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String codigo;
    private String nombre;
    private String tipo;
    private String email;

    private Solicitud solicitud;

    //usar el objeto con solo el cod
    public Usuario(String codigo) {
        this.codigo = codigo;
    }

}
