package pe.edu.utp.isi.dwi.sodi.sodi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Usuario;

@Service
public class UsuarioSolicitudService {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Solicitud> solicitudes = new ArrayList<>();

    public UsuarioSolicitudService() {

        //datos solicituds
        solicitudes.add(new Solicitud("1", "Error de software", "La aplicación se cierra inesperadamente.", "02-04-25", "Pendiente"));
        solicitudes.add(new Solicitud("2", "Capacitación", "Necesito capacitación en el uso del módulo de ventas.", "06-04-25", "En Progreso"));
        solicitudes.add(new Solicitud("3", "Requerimiento", "Quisiera un reporte personalizado.", "01-04-25", "Finalizado"));
        solicitudes.add(new Solicitud("4", "Error de software", "Problemas con el login del sistema.", "03-04-25", "Pendiente"));
        solicitudes.add(new Solicitud("5", "Capacitación", "Capacitación para el nuevo personal.", "07-04-25", "En Progreso"));
        solicitudes.add(new Solicitud("6", "Requerimiento", "Agregar opción para exportar datos a Excel.", "08-04-25", "Pendiente"));

        // datios usuarios
        usuarios.add(new Usuario("U01", "Lucas Flores", "Persona Natural", "luk_flores@gmail.com", solicitudes.get(0)));
        usuarios.add(new Usuario("U02", "Maria Beauty", "Empresa", "maria.bea@beauty.com", solicitudes.get(1)));
        usuarios.add(new Usuario("U03", "Killari Alferez", "Persona Natural", "killa04@gmail.com", solicitudes.get(2)));
        usuarios.add(new Usuario("U04", "Alexandra Spa", "Empresa", "aaa_spa@spa.com", solicitudes.get(3)));
        usuarios.add(new Usuario("U05", "Italo Nuñez", "Persona Natural", "talo__ppp@gmail.com", solicitudes.get(4)));
        usuarios.add(new Usuario("U06", "Oliver Sanchez", "Persona Natural", "sanchez_ol@gmail.com", solicitudes.get(5)));

    }

    // listar solic
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    // listar solic
    public List<Solicitud> listarSolicitudes() {
        return solicitudes;
    }

    // lsta ordenada de usuario
    public List<Usuario> listarUsuariosOrden(int pagina, int tamanoPagina, String ordenadoPor, String direccionOrdenamiento) {

        Comparator<Usuario> comparator;

        switch (ordenadoPor) {
            case "codigo":
                comparator = Comparator.comparing(Usuario::getCodigo);
                break;
            case "nombre":
                comparator = Comparator.comparing(Usuario::getNombre, String.CASE_INSENSITIVE_ORDER);
                break;
            case "tipo":
                comparator = Comparator.comparing(Usuario::getTipo);
                break;
            case "email":
                comparator = Comparator.comparing(Usuario::getEmail);
                break;
            default:
                comparator = Comparator.comparing(Usuario::getNombre, String.CASE_INSENSITIVE_ORDER); // no distingue mayus ni minus
                break;
        }

        if ("desc".equals(direccionOrdenamiento)) {
            // el comparador trabajo de forma reversa
            comparator = comparator.reversed();
        }

        return usuarios.stream()
                .sorted(comparator)
                .skip((pagina - 1) * tamanoPagina) // salta por el tamaño de pagina
                .limit(tamanoPagina) // cuantos elementos tiene la pagina
                .collect(Collectors.toList()); // collector= se genera la lista
    }

    
    // buscar por cod usuario
    public Usuario buscarPorCodigoU(String codigo) {
        return usuarios.stream().filter((p) -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    
    //guardar usuario 
    public Usuario guardar(Usuario usuario) {
        boolean existeUsuario = usuarios.stream()
                .anyMatch(u -> u.getCodigo().equals(usuario.getCodigo()));

        if (!existeUsuario) {
            Solicitud solicitud = usuario.getSolicitud();

            if (solicitud != null) {
                boolean existeSolicitud = solicitudes.stream()
                        .anyMatch(s -> s.getCodigo().equals(solicitud.getCodigo()));

                if (!existeSolicitud) {
                    solicitudes.add(solicitud);
                }
            }
            usuarios.add(usuario);
        }
        return usuario;
    }
    

    // modificar USUARIO por cod
    public Usuario modificar(String codigo, Usuario usuario) {

        usuarios.forEach(p -> {
            if (p.getCodigo().equals(codigo)) {
                p.setNombre(usuario.getNombre());
                p.setTipo(usuario.getTipo());
                p.setEmail(usuario.getEmail());
            }

        }
        );

        return usuario;
    }

    
    // eliminar USUARIO por cod
    public void eliminarUsu(String codigo) {
        Usuario usuarioAEliminar = usuarios.stream()
                .filter(u -> u.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (usuarioAEliminar != null) {
            if (usuarioAEliminar.getSolicitud() != null) {
                solicitudes.removeIf(s -> s.getCodigo().equals(usuarioAEliminar.getSolicitud().getCodigo()));
            }

            usuarios.remove(usuarioAEliminar);
        }
    }

    
    // buscar por cod solicitu
    public Solicitud buscarPorCodigoS(String codigo) {
        return solicitudes.stream().filter((p) -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

}
