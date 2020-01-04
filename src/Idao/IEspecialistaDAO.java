/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.Especialista;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */

public interface IEspecialistaDAO {
    public boolean registrar(Especialista especialista);
    public Especialista obtenerID(int id);
    public List<Especialista> obtener();
    public boolean actualizar(Especialista especialista);
    public boolean eliminar(Especialista especialista);   
    public List<Especialista> getEspecialistas(String criterio, String valor);
}
