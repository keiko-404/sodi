package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {

    private String codigo;
    private String tipo; //Error, capacitación, tequerimiento
    private String motivo;
    private String fecha;
     // quit estado

    public SolicitudDTO(String codigo) {
        this.codigo = codigo;
    }
}
