package pe.edu.utp.isi.dwi.sodi.sodi.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudRequest;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.ColaboradorAsignadoDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudColabResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.dto.SolicitudUsuarioResponseDTO;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Aplicacion;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Asignacion;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;

public class SolicitudMapper {

    public static Solicitud toSolicitud(SolicitudRequest dto, Usuario usuario, Aplicacion aplicacion) {
        Solicitud solicitud = new Solicitud();
        solicitud.setOUsuario(usuario);
        solicitud.setOAplicacion(aplicacion);
        solicitud.setMotivo(dto.getMotivo());
        solicitud.setTipoSolicitud(dto.getTipoSolicitud());

        // devulve tambien el estado y la fecha para vista usuario
        solicitud.setEstado("En Progreso");
        solicitud.setFechaCreacion(LocalDateTime.now());
        return solicitud;
    }

    // vista usuario
    public static SolicitudUsuarioResponseDTO toSolicitudUsuarioResponseDTO(Solicitud solicitud) {
        SolicitudUsuarioResponseDTO response = new SolicitudUsuarioResponseDTO();
        response.setCodSolicitud(solicitud.getCodSolicitud());
        response.setNombreAplicacion(solicitud.getOAplicacion() != null ? solicitud.getOAplicacion().getNombreAplic() : null);
        response.setMotivo(solicitud.getMotivo());
        response.setTipoSolicitud(solicitud.getTipoSolicitud());
        response.setEstado(solicitud.getEstado());
        response.setFechaCreacion(solicitud.getFechaCreacion());
        return response;
    }

    // el colaboradora podra ver todos los detalles de la solicitud
//    public static SolicitudColabResponseDTO toSolicitudColabResponseDTO(Solicitud solicitud) {
//        return SolicitudColabResponseDTO.builder()
//                .codSolicitud(solicitud.getCodSolicitud())
//                .nombreUsuario(solicitud.getOUsuario().getNombreUsuario())
//                .nombreAplicacion(solicitud.getOAplicacion().getNombreAplicacion())
//                .motivo(solicitud.getMotivo())
//                .tipoSolicitud(solicitud.getTipoSolicitud())
//                .prioridad(solicitud.getPrioridad())
//                .estado(solicitud.getEstado())
//                .fechaCreacion(solicitud.getFechaCreacion())
//                .colaboradoresAsignados(
//                    solicitud.getLAsignaciones().stream()
//                        .map(asignacion -> {
//                            Colaborador colab = asignacion.getOColaborador();
//                            return ColaboradorAsignadoDTO.builder()
//                                    .codColaborador(colab.getCodColaborador())
//                                    .nombreColab(colab.getNombreColab())
//                                    .rol(colab.getRol())
//                                    .esCoordinador(asignacion.isEsCoordinador())
//                                    .build();
//                        }).collect(Collectors.toList())
//                )
//                .build();
//    }
    // se ve las solicitudes y el colaborado que se le fue asignado
    public static SolicitudColabResponseDTO toSolicitudColabResponseDTO(Solicitud solicitud) {
        SolicitudColabResponseDTO dto = new SolicitudColabResponseDTO();

        dto.setCodSolicitud(solicitud.getCodSolicitud());
        dto.setNombreUsuario(solicitud.getOUsuario().getNombreUsuario());
        dto.setNombreAplicacion(solicitud.getOAplicacion() != null ? solicitud.getOAplicacion().getNombreAplic() : null);
        dto.setMotivo(solicitud.getMotivo());
        dto.setTipoSolicitud(solicitud.getTipoSolicitud());
        dto.setPrioridad(solicitud.getPrioridad());
        dto.setEstado(solicitud.getEstado());
        dto.setFechaCreacion(solicitud.getFechaCreacion());

        List<ColaboradorAsignadoDTO> listaColabs = new ArrayList<>();

        for (Asignacion asignacion : solicitud.getLAsignaciones()) {
            Colaborador colab = asignacion.getOColaborador();

            ColaboradorAsignadoDTO colabDTO = new ColaboradorAsignadoDTO();
            colabDTO.setCodColaborador(colab.getCodColaborador());
            colabDTO.setNombreColab(colab.getNombreColab());
            colabDTO.setRol(colab.getRol());
            colabDTO.setEsCoordinador(asignacion.isEsCoordinador());

            listaColabs.add(colabDTO);
        }

        dto.setColaboradoresAsignadosDTO(listaColabs);

        return dto;
    }

}
