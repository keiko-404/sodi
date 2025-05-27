package pe.edu.utp.isi.dwi.sodi.sodi.mapper;

import pe.edu.utp.isi.dwi.sodi.sodi.dto.ColaboradorDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;

public class ColaboradorMapper {
    
    
    public static ColaboradorDTO toColaboradorDTO(Cuenta cuenta, String nombreColab, String rol) {
        
        return ColaboradorDTO.builder()
                .correo(cuenta != null ? cuenta.getCorreo() : null)
                .nombreColab(nombreColab)
                .rol(rol).build();
        
    }
    
    
}
