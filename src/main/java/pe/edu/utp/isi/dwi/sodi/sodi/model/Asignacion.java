package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "asignacion")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_asignacion")
    private int codAsignacion;

    @ManyToOne
    @JoinColumn(name = "cod_solicitud")
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "cod_colaborador")
    private Colaborador colaborador;

    @Column(name = "es_coordinador")
    private boolean esCoordinador;

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    public Asignacion(int codAsignacion) {
        this.codAsignacion = codAsignacion;
    }

}
