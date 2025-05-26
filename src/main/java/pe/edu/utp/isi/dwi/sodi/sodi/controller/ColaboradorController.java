package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.service.ColaboradorService;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;
    
    @GetMapping
    public List<Colaborador> listarColaboradores() {
        return colaboradorService.listarColaboradores();
    }
    
    
    
}
