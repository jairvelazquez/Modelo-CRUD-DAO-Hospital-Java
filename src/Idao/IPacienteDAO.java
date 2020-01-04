/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.Paciente;
import java.util.List;
/**
 *
 * @author Jair Velazquez
 */
public interface IPacienteDAO {
    public boolean registrar(Paciente paciente);
    public Paciente obtenerID(int id);
    public List<Paciente> obtener();
    public boolean actualizar(Paciente paciente);
    public boolean eliminar(Paciente paciente);
    public List<Paciente> getPacientes(String criterio, String valor);
}
