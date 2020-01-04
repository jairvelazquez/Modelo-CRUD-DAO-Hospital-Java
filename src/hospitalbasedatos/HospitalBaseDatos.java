/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalbasedatos;

import Controllers.ControllerDepartamento;
import Modelo.Departamento;

/**
 *
 * @author Jair Velazquez
 */
public class HospitalBaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Ciencias Forenses");			
		
	// controlador
	ControllerDepartamento controller = new ControllerDepartamento();
 
	// guarda un cliente a través del controlador
	controller.registrar(departamento);
                
	// ver clientes
	controller.verDepartamentos();
 
        departamento.setNombreDepartamento("Autopsias");
	controller.actualizar(departamento);
 
	// eliminar un cliente por medio del id
	departamento.setId(1);
        controller.eliminar(departamento);
    }
    
}
