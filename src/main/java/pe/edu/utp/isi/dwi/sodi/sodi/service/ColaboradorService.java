package pe.edu.utp.isi.dwi.sodi.sodi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    
    //LISTAR COLAB
    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }
            
     
    
}
