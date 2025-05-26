package pe.edu.utp.isi.dwi.sodi.sodi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrador")
public class Administrador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_admin")
    private int codAdministrador;
    
    @OneToOne
    @JoinColumn(name = "cod_cuenta")
    private Cuenta oCuenta;
    
    @Column(name = "nombre_admin")
    private String nombreAdmin;

    public Administrador(int codAdministrador) {
        this.codAdministrador = codAdministrador;
    }    
    
}
