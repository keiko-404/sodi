package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.ColaboradorDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.service.ColaboradorService;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<ColaboradorDTO> obtenerDatosColab() {
        String correoColab = SecurityContextHolder.getContext().getAuthentication().getName();
        ColaboradorDTO dto = colaboradorService.obtenerInfoColaborador(correoColab);
        return ResponseEntity.ok(dto);
    }

}
