package pe.edu.utp.isi.dwi.sodi.sodi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Asignacion;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Colaborador;
import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;

import pe.edu.utp.isi.dwi.sodi.sodi.repository.AsignacionRepository;
import pe.edu.utp.isi.dwi.sodi.sodi.repository.ColaboradorRepository;

@Service
public class AsignacionService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private AsignacionRepository asignacionRepository;

    public void asignarColaboradores(Solicitud solicitud) {
        String prioridad = solicitud.getPrioridad();

        if (prioridad.equals("Alta")) {
            List<Colaborador> analistas = colaboradorRepository.findByRol("Analista");
            List<Colaborador> programadores = colaboradorRepository.findByRol("Programador");

            if (analistas.size() < 1 || programadores.size() < 2) {
                throw new RuntimeException("No hay suficientes colaboradores para prioridad Alta");
            }

            asignacionRepository.save(new Asignacion(0, solicitud, analistas.get(0), false, new ArrayList<>()));
            asignacionRepository.save(new Asignacion(0, solicitud, programadores.get(0), true, new ArrayList<>()));
            asignacionRepository.save(new Asignacion(0, solicitud, programadores.get(1), false, new ArrayList<>()));

        } else if (prioridad.equals("Media")) {
            List<Colaborador> disponibles = colaboradorRepository.findByRolIn(List.of("Programador", "Diseñador"));

            if (disponibles.size() < 2) {
                throw new RuntimeException("No hay suficientes colaboradores para prioridad Media");
            }

            asignacionRepository.save(new Asignacion(0, solicitud, disponibles.get(0), false, new ArrayList<>()));
            asignacionRepository.save(new Asignacion(0, solicitud, disponibles.get(1), false, new ArrayList<>()));

        } else if (prioridad.equals("Baja")) {
            List<Colaborador> soporte = colaboradorRepository.findByRol("Soporte");

            if (soporte.isEmpty()) {
                throw new RuntimeException("No hay colaboradores de Soporte disponibles");
            }

            asignacionRepository.save(new Asignacion(0, solicitud, soporte.get(0), false, new ArrayList<>()));
        }
    }
}

