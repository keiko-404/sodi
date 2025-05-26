package pe.edu.utp.isi.dwi.sodi.sodi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cuenta")
public class Cuenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cuenta")
    private int codCuenta;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name = "cod_roles")
    private Roles oRoles;

    public Cuenta(int codCuenta) {
        this.codCuenta = codCuenta;
    }
    
}
