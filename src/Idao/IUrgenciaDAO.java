/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;
import Modelo.Urgencia;
import java.util.List;
/**
 *
 * @author Jair Velazquez
 */
public interface IUrgenciaDAO {
    public boolean registrar(Urgencia urgencia);
    public Urgencia obtenerID(int id);
    public List<Urgencia> obtener();
    public boolean actualizar(Urgencia urgencia);
    public boolean eliminar(Urgencia urgencia);
    public boolean actualizaFecha(Urgencia urgencia);
    public boolean actualizaDiagnostico(Urgencia urgencia);
    public List<Urgencia> getUrgencias(String criterio,String valor);
}
