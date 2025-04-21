package pe.edu.utp.isi.dwi.sodi.sodi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;
import pe.edu.utp.isi.dwi.sodi.sodi.service.UsuarioSolicitudService;

// paginacion, listar y modificar
@Tag(
        name = "Usuarios",
        description = "Crud relacionado a los usuarios registrados y sus solicitudes"
)
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioSolicitudService usuarioService;

    // Documentación: muestra la lista de solicitudes
    @Operation(summary = "Obtener todos los registros", description = "Se muestra la lista de los usuarios jutnto con las solicitudes realizadas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Éxito al obtener lista de usuarios"),
        @ApiResponse(responseCode = "500", description = "Error")
    })

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    
    @Operation(summary = "Se ordena la lista de usuarios por nombres", description = "num de pag que se verá/cantidad de elementos/tipo por el que se ordenara NOMBRE/ asc o dec ")
    // Listar usuarios ordenados y paginados
    @GetMapping("/{pagina}/{tamanoPagina}/{ordenadoPor}/{direccionOrdenamiento}")
    public List<Usuario> listarUsuariosOrden(
            @Parameter(description = "Número de página donde aparecen usuarios", required = true, example = "1")
            @PathVariable int pagina,
            @Parameter(description = "Cantidad de usuarios por página", required = true, example = "2")
            @PathVariable int tamanoPagina,
            @Parameter(description = "Campo por el que se ordena", required = true, example = "nombre")
            @PathVariable String ordenadoPor,
            @Parameter(description = "Dirección de ordenamiento: asc o desc", required = true, example = "asc")
            @PathVariable String direccionOrdenamiento
    ) {
        return usuarioService.listarUsuariosOrden(pagina, tamanoPagina, ordenadoPor, direccionOrdenamiento);
    }

    @Operation(summary = "Crear usuario", description = "Registra nuevo usuario junto a su solicitud")
    // crear usuario
    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario usuarioNuevo = usuarioService.guardar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }

    @Operation(summary = "Obtener usuario por codigo", description = "Se muestra usuario por codigo")
    // Buscar usuario por código
    @GetMapping("/{codigo}")
    public ResponseEntity<Usuario> buscarPorCodigo(@PathVariable String codigo) {
        Usuario usuario = usuarioService.buscarPorCodigoU(codigo);
        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Mdofica usuario", description = "Modifica por codigo")
    // Modificar usuario existente
    @PutMapping("/{codigo}")
    public ResponseEntity<Usuario> modificar(
            @PathVariable String codigo,
            @RequestBody Usuario usuario
    ) {
        Usuario usuarioModificado = usuarioService.modificar(codigo, usuario);
        return ResponseEntity.ok(usuarioModificado);
    }

    // Eliminar usuario por código
    @Operation(summary = "Eliminar usuario", description = "Eliminacion del usuario junto a la solicitud")
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarUsu(@PathVariable String codigo) {
        usuarioService.eliminarUsu(codigo);
        return ResponseEntity.noContent().build();
    }
}
