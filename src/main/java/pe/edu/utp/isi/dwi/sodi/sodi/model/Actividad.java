package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.time.LocalDateTime;

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
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_actividad")
    private int codActividad;

    @ManyToOne
    @JoinColumn(name = "cod_asignacion")
    private Asignacion oAsignacion;

    @Column(name = "descripcion_actividad")
    private String descripcionAct;

    @Column(name = "fecha_actividad")
    private LocalDateTime fechaActividad;

    @Column(name = "tiempo_consumido")
    private double tiempoConsumido;

    public Actividad(int codActividad) {
        this.codActividad = codActividad;
    }

}
