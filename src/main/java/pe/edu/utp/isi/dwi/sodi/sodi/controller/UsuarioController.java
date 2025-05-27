package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudUsuarioResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.UsuarioDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.mapper.SolicitudMapper;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.service.SolicitudService;
import pe.edu.utp.isi.dwi.sodi.sodi.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<UsuarioDTO> obtenerDatosUsuario() {
        String correoUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        UsuarioDTO dto = usuarioService.obtenerInfoUsuario(correoUsuario);
        return ResponseEntity.ok(dto);
    }

    // usuario ve solo sus solicitudes
    @GetMapping("/solicitudes")
    public ResponseEntity<List<SolicitudUsuarioResponseDTO>> verMisSolicitudes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correoUsuario = auth.getName(); // Este es el correo extraído del JWT

        List<Solicitud> solicitudes = solicitudService.buscarPorCorreoUsuario(correoUsuario);
        List<SolicitudUsuarioResponseDTO> respuesta = solicitudes.stream()
                .map(SolicitudMapper::toSolicitudUsuarioResponseDTO)
                .toList();

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/crear")
    public ResponseEntity<SolicitudUsuarioResponseDTO> crearSolicitud(@RequestBody SolicitudRequest solicitudRequest) {
        String correoUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        Solicitud solicitudCreada = usuarioService.registrarSolicitud(solicitudRequest, correoUsuario);

        SolicitudUsuarioResponseDTO response = SolicitudMapper.toSolicitudUsuarioResponseDTO(solicitudCreada);
        return ResponseEntity.ok(response);
    }

}
