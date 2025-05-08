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
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_colaborador")
    private int codColaborador;

    @Column(name = "nombre_colab")
    private String nombreColab;

    @Column(name = "rol")
    private String rol;

    @Column(name = "correo")
    private String correo;

    @Builder.Default
    @OneToMany(mappedBy = "oColaborador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignacion> lAsignaciones = new ArrayList<>();

    public Colaborador(int codColaborador) {
        this.codColaborador = codColaborador;
    }

    
}
