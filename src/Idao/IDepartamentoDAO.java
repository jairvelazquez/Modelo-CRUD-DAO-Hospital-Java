/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;
import Modelo.Departamento;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public interface IDepartamentoDAO {
    
	public boolean registrar(Departamento departamento);
        public Departamento obtenerID(int id);
	public List<Departamento> obtener();
	public boolean actualizar(Departamento departamento);
	public boolean eliminar(Departamento departamento);
        public List<Departamento> getDepartamentos(String criterio,String valor);

}
