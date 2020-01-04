/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DepartamentoDaoImpl;
import Idao.IDepartamentoDAO;
import Modelo.Departamento;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerDepartamento{
    
    //private VistaDepartamento vista= new VistaDepartamento();   
    
    public ControllerDepartamento() {            
    }
        
	
	//llama al DAO para guardar un cliente
	public void registrar(Departamento departamento ) {
		IDepartamentoDAO dao= new  DepartamentoDaoImpl();
		dao.registrar(departamento);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Departamento cliente) {
		IDepartamentoDAO dao= new DepartamentoDaoImpl();
		dao.actualizar(cliente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Departamento departamento) {
		IDepartamentoDAO dao= new DepartamentoDaoImpl();
		dao.eliminar(departamento);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verDepartamentos(){
		//List<Departamento> clientes = new ArrayList<Departamento>();
		//IDepartamentoDAO dao= new  DepartamentoDaoImpl();
		//clientes = dao.obtener();
		//vistaDemo.verClientes(clientes);
	}
}
