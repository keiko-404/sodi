package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudMapper;
import pe.edu.utp.isi.dwi.sodi.sodi.exception.SolicitudNoEncontradoException;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.service.UsuarioSolicitudService;

// listar, eliminar
@Tag(
        name = "Solicitudes",
        description = "Crud relacionado a las solicitudes generadas por usuarios"
)
@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    @Autowired
    private UsuarioSolicitudService solicitudService;

    // Documentación: muestra la lista de solicitudes
    @Operation(summary = "Obtener todas las solicitudes", description = "Se muestra la lista de solicitudes registradas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Éxito al obtener lista de solicitudes"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.listarSolicitudes();
    }

    @Operation(summary = "Obtener solicitud por codigo", description = "Se muestra la solicitud por codigo")
    // buscar solic por codgi
    @GetMapping("/{codigo}")
    public ResponseEntity<SolicitudDTO> buscarPorCodigoS(@PathVariable String codigo) {
        Solicitud solicitud = solicitudService.buscarPorCodigoS(codigo);

        //si no encuentra el producto desencadena la excepcion
        if (solicitud == null) {
            throw new SolicitudNoEncontradoException(codigo);
        }

        return ResponseEntity.ok(SolicitudMapper.toDTO(solicitud));

    }

}
