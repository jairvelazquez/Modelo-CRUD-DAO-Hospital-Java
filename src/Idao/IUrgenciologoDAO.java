/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.Urgenciologo;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public interface IUrgenciologoDAO {
    public boolean registrar(Urgenciologo urgenciologo);
    public Urgenciologo obtenerID(int id);
    public List<Urgenciologo> obtener();
    public boolean actualizar(Urgenciologo urgenciologo);
    public boolean eliminar(Urgenciologo urgenciologo);
    public List<Urgenciologo> getUrgenciologos(String criterio,String valor);
}
