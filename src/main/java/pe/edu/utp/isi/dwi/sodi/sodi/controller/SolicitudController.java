package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudUsuarioResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.exception.SolicitudNoEncontradoException;
import pe.edu.utp.isi.dwi.sodi.sodi.mapper.SolicitudMapper;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.service.SolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    // admin & colab
    @GetMapping
    public List<SolicitudResponseDTO> listarSolicitudes() {
        List<Solicitud> solicitudes = solicitudService.listarSolicitudes();
        return solicitudes.stream()
                // vista desde colaborador
                .map(SolicitudMapper::toSolicitudColabResponseDTO)
                .collect(Collectors.toList());
    }

    // Esta de lado usuario, cambiar a colab, para usuario y colab se mostrara lista con filtros para usuario !!!!!!!!!!!!!!!!!!!!!!!
    @GetMapping("/{codSolicitud}")
    public ResponseEntity<SolicitudUsuarioResponseDTO> obtenerPorCodigo(@PathVariable int codSolicitud) {
        Solicitud solicitud = solicitudService.obtenerPorCodigo(codSolicitud)
                .orElseThrow(() -> new SolicitudNoEncontradoException(codSolicitud));
        // vista desde usuario
        return ResponseEntity.ok(SolicitudMapper.toSolicitudUsuarioResponseDTO(solicitud));
    }

    // admin
    @DeleteMapping("/{codSolicitud}")
    public ResponseEntity<Void> eliminarPorCodigo(@PathVariable int codSolicitud) {
        solicitudService.eliminarPorCodigo(codSolicitud);
        return ResponseEntity.noContent().build();
    }

    // usuario
//    @PostMapping
//    public ResponseEntity<SolicitudUsuarioResponseDTO> crearSolicitud(@RequestBody SolicitudRequest solicitudRequest) {
//        Solicitud solicitudCreada = solicitudService.registrarSolicitud(solicitudRequest);
//        SolicitudUsuarioResponseDTO response = SolicitudMapper.toSolicitudUsuarioResponseDTO(solicitudCreada);
//        return ResponseEntity.ok(response);
//    }

    // ---------- admin
    @GetMapping("/colaborador/{codColaborador}")
    public List<SolicitudResponseDTO> listarSolicitudesPorColaborador(@PathVariable int codColaborador) {
        List<Solicitud> solicitudes = solicitudService.listarSolicitudesPorColaborador(codColaborador);
        return solicitudes.stream()
                .map(SolicitudMapper::toSolicitudColabResponseDTO)
                .collect(Collectors.toList());
    }

}
