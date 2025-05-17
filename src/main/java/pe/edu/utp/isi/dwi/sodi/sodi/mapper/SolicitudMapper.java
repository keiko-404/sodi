package pe.edu.utp.isi.dwi.sodi.sodi.mapper;

import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Aplicacion;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;

public class SolicitudMapper {

    public static Solicitud toSolicitud(SolicitudRequest dto, Usuario usuario, Aplicacion aplicacion) {
        Solicitud solicitud = new Solicitud();
        solicitud.setOUsuario(usuario);
        solicitud.setOAplicacion(aplicacion);
        solicitud.setMotivo(dto.getMotivo());
        solicitud.setTipoSolicitud(dto.getTipoSolicitud());
        return solicitud;
    }

public static SolicitudResponseDTO toSolicitudResponseDTO(Solicitud solicitud) {
    SolicitudResponseDTO response = new SolicitudResponseDTO();
    response.setCodSolicitud(solicitud.getCodSolicitud());
    response.setNombreUsuario(solicitud.getOUsuario() != null ? solicitud.getOUsuario().getNombreUsuario() : null);
    response.setNombreAplicacion(solicitud.getOAplicacion() != null ? solicitud.getOAplicacion().getNombreAplic() : null);
    response.setMotivo(solicitud.getMotivo());
    response.setTipoSolicitud(solicitud.getTipoSolicitud());
    response.setPrioridad(solicitud.getPrioridad());
    response.setEstado(solicitud.getEstado());
    response.setFechaCreacion(solicitud.getFechaCreacion());
    return response;
}

}
