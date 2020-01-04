/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ApoyoEnfermeroDaoImpl;
import Dao.UrgenciaDaoImpl;
import Idao.IApoyoEnfermeroDAO;
import Idao.IUrgenciaDAO;
import Modelo.ApoyoEnfermero;
import Modelo.Urgencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerApoyoEnfermero {
    public ControllerApoyoEnfermero() {    
    }
	//llama al DAO para guardar un Paciente
    public void registrar(ApoyoEnfermero apoyo) {
	IApoyoEnfermeroDAO dao = new ApoyoEnfermeroDaoImpl();
	dao.registrar(apoyo);
    }
	   
    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verDepartamentos(){
	List<ApoyoEnfermero> apoyos = new ArrayList<ApoyoEnfermero>();
	IApoyoEnfermeroDAO dao= new ApoyoEnfermeroDaoImpl();
	apoyos = dao.obtener();
    }
}
