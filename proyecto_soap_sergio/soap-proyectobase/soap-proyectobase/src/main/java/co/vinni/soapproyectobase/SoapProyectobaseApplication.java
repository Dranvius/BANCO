package co.vinni.soapproyectobase;

//import co.vinni.soapproyectobase.controladores.ControladorEquipos;
//import co.vinni.soapproyectobase.dto.EquipoDto;
//import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.servicios.ServicioCuentas;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
@Log4j2
public class SoapProyectobaseApplication implements CommandLineRunner {


    public static void main(String[] args) {

        SpringApplication.run(SoapProyectobaseApplication.class, args);
        System.out.println("proyecto base");

    }

    @Autowired
    RepositorioCuenta repoCuenta;
    @Override
    public void run(String... args) throws Exception{

        Cuenta a = new Cuenta();
        a.setId(2);
        a.setNombre("Alexis");
        a.setCedula(1023929372);
        a.setIdCuenta(2);
        a.setFondos(10000);

        repoCuenta.save(a);


        List<Cuenta> listCuenta =  repoCuenta.findAll();
        for(Cuenta cuenta: listCuenta){
            System.out.println(cuenta.getNombre());
        }

    }



}
