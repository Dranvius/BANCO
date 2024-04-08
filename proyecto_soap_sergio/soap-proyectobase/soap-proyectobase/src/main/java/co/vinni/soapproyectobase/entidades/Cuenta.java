package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cuenta")
@Table(name = "CUENTAS")
//No hay relaciòn de herencia
//Aosicaciòn o extencion

public class Cuenta implements Serializable  {
    // private int id;
    // private String nombre;
    // private int idCuenta;
    // private int cedula;
    // private long fondos;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUENTA")
    @SequenceGenerator(name = "SEQ_CUENTA", sequenceName = "SEQ_CUENTA", allocationSize = 1)
    
    @Column(name = "EQU_CODIGO", nullable = false)
    private long id;

    @Column(name = "EQU_nombre", nullable = false)
    private String nombre;

    @Column(name = "EQU_PERSONA", nullable = false)
    private int idCuenta;


    @Column(name = "EQU_cedula", nullable = false)
    private int cedula;

    @Column(name = "EQU_fondos", nullable = false)
    private int fondos;


}

