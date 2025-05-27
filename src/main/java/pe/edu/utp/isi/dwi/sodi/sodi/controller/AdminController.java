package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @GetMapping("/colaboradores")
    public List<Colaborador> listarColaboradores() {
        return adminService.listarColaboradores();
    }
}
