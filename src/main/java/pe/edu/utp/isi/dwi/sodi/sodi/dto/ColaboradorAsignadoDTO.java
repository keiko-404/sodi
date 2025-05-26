package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorAsignadoDTO {
    private int codColaborador;
    private String nombreColab;
    private String rol;
    private boolean esCoordinador;
}
