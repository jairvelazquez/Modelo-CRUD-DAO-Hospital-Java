/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IApoyoEnfermeroDAO;
import Modelo.ApoyoEnfermero;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jair Velazquez
 */
public class ApoyoEnfermeroDaoImpl implements IApoyoEnfermeroDAO {

    @Override
    public boolean registrar(ApoyoEnfermero apoyoEnfermero) {
        boolean registrar = false;

	Connection con=null;
        PreparedStatement ps = null;
	String sql="INSERT INTO APOYO_ENFERMERO(id_enfermero,id_urgencia) "
                   + "values ("+apoyoEnfermero.getId_enfermero()+","+apoyoEnfermero.getId_urgencia()+")";        
        try {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.execute();
            registrar=true;
            con.close();
            JOptionPane.showMessageDialog(null,"Registrado!");
	}catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
            }
	return registrar;
    }

    @Override
    public ApoyoEnfermero obtenerID(int id) {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
	
	String sql="SELECT * FROM APOYO_ENFERMERO WHERE id = "+id;
		
	ApoyoEnfermero apoyoEnfermero = null;
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		apoyoEnfermero = new ApoyoEnfermero();
		apoyoEnfermero.setId_enfermero(rs.getInt(1));
		apoyoEnfermero.setId_urgencia(rs.getInt(1));
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase apoyoEnfermero DaoImple, método obtener");
            e.printStackTrace();
	}
	return apoyoEnfermero;
    }

    @Override
    public List<ApoyoEnfermero> obtener() {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM APOYO_ENFERMERO ORDER BY ID";
		
	List<ApoyoEnfermero> listaApoyoEnfermero = new ArrayList<ApoyoEnfermero>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		ApoyoEnfermero apoyoEnfermero=new ApoyoEnfermero();
                apoyoEnfermero.setId_enfermero(rs.getInt(1));
                apoyoEnfermero.setId_urgencia(rs.getInt(2));
		listaApoyoEnfermero.add(apoyoEnfermero);
        	}
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase ApoyoEnfermero DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaApoyoEnfermero;
    }
    public List<ApoyoEnfermero> getApoyoEnfermero(String criterio,String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
         String sql = "";
	if(isNumeric(valor)){
            sql ="select urgencia.id as id_urgencia, paciente.nombre as nombre_paciente, paciente.apellido1 as apellido_paciente, enfermero.nombre as nombre_enfermero, enfermero.apellido1 as apellido_enfermero from apoyo_enfermero "+
            "inner join urgencia on apoyo_enfermero.id_urgencia = urgencia.id inner join paciente on urgencia.id_paciente = paciente.id inner join enfermero on apoyo_enfermero.id_enfermero = enfermero.id"+
            " WHERE "+criterio+"="+valor;
           
        }
        else{
            sql="SELECT * FROM PACIENTE WHERE "+criterio+"='"+valor+"'";
        }
	
	List<ApoyoEnfermero> listaApoyos = new ArrayList<ApoyoEnfermero>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		ApoyoEnfermero apoyo = new ApoyoEnfermero();
                apoyo.setId_urgencia(rs.getInt("id_urgencia"));
                apoyo.setNombrePaciente(rs.getString("nombre_paciente"));
                apoyo.setApellidoPaciente(rs.getString("apellido_paciente"));
                apoyo.setNombreEnfermero(rs.getString("nombre_enfermero"));
                apoyo.setApellidoEnfermero(rs.getString("apellido_enfermero"));
		listaApoyos.add(apoyo);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaApoyos;
    }
}
