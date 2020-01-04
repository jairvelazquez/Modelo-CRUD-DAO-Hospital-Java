/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.Enfermero;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public interface IEnfermeroDAO {
    public boolean registrar(Enfermero enfermero);
    public Enfermero obtenerID(int id);
    public List<Enfermero> obtener();
    public boolean actualizar(Enfermero enfermero);
    public boolean eliminar(Enfermero enfermero);
    public List<Enfermero>getEnfermeros(String criterio,String valor);
}
