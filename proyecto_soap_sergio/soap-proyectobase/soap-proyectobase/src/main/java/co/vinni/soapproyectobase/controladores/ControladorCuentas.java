package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Log4j2
@Controller
public class ControladorCuentas {
    private static final Logger logger = LogManager.getLogger(ControladorCuentas.class);


    @Autowired
    ServicioCuentas serviciosCuentas;


    //Invocacción por URL a esa Ruta del back
    @getMapping({"/cuentas"})


    //DTO
    //Enlistar cuentas
    public String listarCuentas(Model model){
        logger.info("Verificando ");
        model.addAttribute("cuentas",ServicioCuentas.obtenerEquipos());

        //Retorna la pagina
        return "cuentas";
    }


    //Mostrar formulario
    @getMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model){
        CuentaDto cuentaDto = new CuentaDto();
        model.addAttribute("cuenta",cuentaDto);
        return "crear_equipo"
    }

    //Registrar cuentas

    @PostMapping("/cuentas")
    public String registrarCuenta(@ModelAttribute("cuenta") CuentaDto cuenta) {
        servicioCuenta.registrar(cuenta);
        //Re dirige a cuentas cuando termine el servicio
        return "redirect:/cuentas";
    }

    //Editar

    @GetMapping("/cuentas/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        CuentaDto cuentaDto = new EquipoDto();
        model.addAttribute("cuenta", servicioCuentas.obtenerCuenta(serial));
        return "editar_cuenta";
    }


    @PostMapping("/cuentas/{serial}")
    public String modificarCuenta(@PathVariable long serial,@ModelAttribute( "cuenta") CuentaDto cuentaDto, Model model){


        model.addAttribute("cuenta", servicioCuenta.actualizar(cuentaDto));
        return "redirect:/cuentas";
    }


    @GetMapping("/cuentas/{serial}")
    public String eliminarCuenta(@PathVariable long serial){

        servicioCuentas.eliminar(serial);

        return "redirect:/cuentas";
    }


}
