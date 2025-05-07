package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "colaborador")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    public Colaborador(int codColaborador) {
        this.codColaborador = codColaborador;
    }

    
}
