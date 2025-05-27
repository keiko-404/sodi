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



    public List<Solicitud> listarSolicitudesPorColaborador(int codColaborador) {
        return solicitudRepository.findByColaboradorId(codColaborador);
    }

    public List<Solicitud> buscarPorCorreoUsuario(String correoUsuario) {
        return solicitudRepository.findByCorreoUsuario(correoUsuario);
    }

}
