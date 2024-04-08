package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Serializable;
import java.util.List;


@Service
public class ServicioCuentas implements Serializable{

    @Autowired
    RepositorioCuenta repoCuenta;


    private ModelMapper modelMapper; // Agrega @Autowired aquí


    public void registrarCuenta(CuentaDto cuentaDto) {
        repoCuenta.save(modelMapper.map(cuentaDto, Cuenta.class));
    }

    //Verificar còmo el usuario puede entrar la cuenta desde la consola
    public List<CuentaDto> obtenerEquipos() {
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoCuenta.findAll(), typeToken.getType());

    }




}
