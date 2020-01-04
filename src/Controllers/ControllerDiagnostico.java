/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DiagnosticoDaoImpl;
import Idao.IDiagnosticoDAO;
import Modelo.Diagnostico;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Jair Velazquez
 */
public class ControllerDiagnostico {
        
    public ControllerDiagnostico() {    
    }
	//llama al DAO para guardar un Paciente
	public void registrar(Diagnostico diagnosticos) {
            IDiagnosticoDAO dao= new DiagnosticoDaoImpl();
            dao.registrar(diagnosticos);
	}
	
	//llama al DAO para actualizar un Paciente
	public void actualizar(Diagnostico diagnosticos) {
            IDiagnosticoDAO dao= new DiagnosticoDaoImpl();
            dao.actualizar(diagnosticos);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Diagnostico diagnosticos) {
            IDiagnosticoDAO dao= new DiagnosticoDaoImpl();
            dao.eliminar(diagnosticos);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verDiagnosticos(){
            List<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
            IDiagnosticoDAO dao= new DiagnosticoDaoImpl();
            diagnosticos = dao.obtener();
	}
}
