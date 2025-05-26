package pe.edu.utp.isi.dwi.sodi.sodi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.mapper.SolicitudMapper;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Aplicacion;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.AplicacionRepository;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.SolicitudRepository;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.UsuarioRepository;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AplicacionRepository aplicacionRepository;

    @Autowired
    private AsignacionService asignacionService;

    // LISTAR SOLCICITUDES   ---------------------
    public List<Solicitud> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    //  BUSCAR POR COD  ---------------------
    public Optional<Solicitud> obtenerPorCodigo(int codSolicitud) {
        return solicitudRepository.findById(codSolicitud);
    }

    // ELIMINAR POR COD  ---------------------
    public void eliminarPorCodigo(int codSolicitud) {
        solicitudRepository.deleteById(codSolicitud);
    }

    // REGISTRAR SOLICITUD LADO USUARI  ---------------------
    @Transactional // asegura que si algo falla (usuario no existe, error en el guardado), no se persiste nada parcial.
    public Solicitud registrarSolicitud(SolicitudRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getCodUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Aplicacion aplicacion = aplicacionRepository.findById(request.getCodAplicacion())
                .orElseThrow(() -> new RuntimeException("Aplicación no encontrada"));

        //crea la solicitud base desde el mapper
        Solicitud solicitud = SolicitudMapper.toSolicitud(request, usuario, aplicacion);

        // valores automaticos
        solicitud.setPrioridad(elegirPrioridad(request.getTipoSolicitud()));
//        solicitud.setPrioridad(Prioridad);
        solicitud.setEstado("En Progreso");
        solicitud.setFechaCreacion(LocalDateTime.now());

        // guardar y retrna
//        return solicitudRepository.save(solicitud);
        Solicitud solicitudGuardada = solicitudRepository.save(solicitud);

        // delegamos la asignación
        asignacionService.asignarColaboradores(solicitudGuardada);

        return solicitudGuardada;
    }

    // es para eliegir la prioirdad dependiendo del tipo de solicitud
    private String elegirPrioridad(String tipoSolicitud) {

        switch (tipoSolicitud) {
            case "Error de software":
                return "Alta";
            case "Capacitación sobre  uso  del  Software":
                return "Baja";
            case "Requerimiento de Software":
                return "Media";
            default:
                return "Media";
        }
    }

    
    
    public List<Solicitud> listarSolicitudesPorColaborador(int codColaborador) {
        return solicitudRepository.findByColaboradorId(codColaborador);
    }

}
