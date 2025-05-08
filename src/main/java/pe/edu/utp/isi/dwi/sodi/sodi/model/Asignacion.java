package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignacion")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_asignacion")
    private int codAsignacion;

    @ManyToOne
    @JoinColumn(name = "cod_solicitud")
    private Solicitud oSolicitud;

    @ManyToOne
    @JoinColumn(name = "cod_colaborador")
    private Colaborador oColaborador;

    @Column(name = "es_coordinador")
    private boolean esCoordinador;

    @Builder.Default
    @OneToMany(mappedBy = "oAsignacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actividad> lActividades = new ArrayList<>();

    public Asignacion(int codAsignacion) {
        this.codAsignacion = codAsignacion;
    }

}
