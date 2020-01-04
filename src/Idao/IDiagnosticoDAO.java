/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.Diagnostico;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public interface IDiagnosticoDAO {
    public int registrar(Diagnostico diagnostico);
    public Diagnostico obtenerID(int id);
    public List<Diagnostico> obtener();
    public boolean actualizar(Diagnostico diagnostico);
    public boolean eliminar(Diagnostico diagnostico);
}
