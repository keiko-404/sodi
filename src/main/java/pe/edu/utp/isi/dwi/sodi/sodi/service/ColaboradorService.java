package pe.edu.utp.isi.dwi.sodi.sodi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.ColaboradorDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.mapper.ColaboradorMapper;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Cuenta;

import pe.edu.utp.isi.dwi.sodi.sodi.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    

         public ColaboradorDTO obtenerInfoColaborador(String correoUsuario) {
        Colaborador colaborador = colaboradorRepository.findByoCuenta_Correo(correoUsuario)
                .orElseThrow(() -> new RuntimeException(" "));
        Cuenta cuenta = colaborador.getOCuenta();
        String nombreColab = colaborador.getNombreColab();
        String rol = colaborador.getRol();

        return ColaboradorMapper.toColaboradorDTO(cuenta, nombreColab, rol);
    }       
     
    
}
