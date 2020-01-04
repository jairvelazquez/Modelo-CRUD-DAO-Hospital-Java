/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jair Velazquez
 */
public class Departamento {
    private String nombreDepartamento;
    private long id;
    public Departamento(){
    }
    
    public Departamento(String nombreDepartamento){
        this.nombreDepartamento = nombreDepartamento;
       // this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombreDepartamento(){
        return this.nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento){
        this.nombreDepartamento = nombreDepartamento;
    }
    
    @Override
    public String toString() {
        return this.id+", "+this.nombreDepartamento;
    }
}
