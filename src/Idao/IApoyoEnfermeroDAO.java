/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import Modelo.ApoyoEnfermero;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public interface IApoyoEnfermeroDAO {
    public boolean registrar(ApoyoEnfermero apoyoEnfermero);
    public ApoyoEnfermero obtenerID(int id);
    public List<ApoyoEnfermero> obtener();
    public List<ApoyoEnfermero> getApoyoEnfermero(String criterio,String valor);
}
