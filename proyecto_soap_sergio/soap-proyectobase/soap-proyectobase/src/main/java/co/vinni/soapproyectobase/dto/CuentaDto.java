package co.vinni.soapproyectobase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CuentaDto implements Serializable{
    private int id;
    private String nombre;
    private int idCuenta;
    private int cedula;
    private long fondos;
}
