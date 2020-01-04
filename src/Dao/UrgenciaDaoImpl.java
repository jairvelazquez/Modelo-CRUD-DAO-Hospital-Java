/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IUrgenciaDAO;
import Modelo.Urgencia;
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
public class UrgenciaDaoImpl implements IUrgenciaDAO{

    @Override
    public boolean registrar(Urgencia urgencia) {
        boolean registrar = false;

	Connection con=null;
        PreparedStatement ps = null;
	String sql="INSERT INTO URGENCIA (id_paciente,id_urgenciologo,numero_cama,fecha_ingreso,causa) "
                   + "values ("+urgencia.getId_paciente()+","+urgencia.getId_urgenciologo()+",'"+urgencia.getCamilla()+"','"
                   +urgencia.getDateTimeIngreso()+"',"
                + "'"+urgencia.getCausa()+"'"
                + ")";  
	try {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                urgencia.setId(rs.getInt(1));
            }
            registrar=true;
            con.close();
            JOptionPane.showMessageDialog(null, "Registrado!");
	}catch (SQLException e) {
            System.out.println("Error: Clase UrgenciaDaoImple, método registrar");
            e.printStackTrace();
	}
	return registrar;
    }

    @Override
    public Urgencia obtenerID(int id) {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM URGENCIA WHERE id = "+id;
		
	Urgencia urgencia = null;
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		urgencia = new Urgencia();
		urgencia.setId(rs.getInt(1));
                urgencia.setId_paciente(rs.getInt(2));
                urgencia.setId_urgenciologo(rs.getInt(3));
                urgencia.setId_diagnostico(rs.getInt(4));
                urgencia.setCamilla(rs.getString(5));
                urgencia.setDateTimeIngreso(rs.getString(6));
                urgencia.setDateTimeSalida(rs.getString(7));
            }
	stm.close();
	rs.close();
	co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase URGENCIA DaoImple, método obtener");
            e.printStackTrace();
	}
	return urgencia;
    }

    @Override
    public List<Urgencia> obtener() {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM URGENCIA ORDER BY ID";
		
	List<Urgencia> listaUrgencia = new ArrayList<Urgencia>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Urgencia urgencia=new Urgencia();
		urgencia.setId(rs.getInt(1));
                urgencia.setId_paciente(rs.getInt(2));
                urgencia.setId_urgenciologo(rs.getInt(3));
                urgencia.setId_diagnostico(rs.getInt(4));
                urgencia.setCamilla(rs.getString(5));
                urgencia.setDateTimeIngreso(rs.getString(6));
                urgencia.setDateTimeSalida(rs.getString(7));
                listaUrgencia.add(urgencia);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase Urgencia DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaUrgencia;
    }

    @Override
    public boolean actualizar(Urgencia urgencia) {
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE URGENCIA SET id_paciente="+urgencia.getId_paciente()+","
                +"id_urgenciologo ="+urgencia.getId_urgenciologo()+","
                +"numero_cama ='"+urgencia.getCamilla()+"',"
                +"causa ='"+urgencia.getCausa()+"'"
                +" WHERE ID="+urgencia.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null, "Actualizado");
            } catch (SQLException e) {
            System.out.println("Error: Clase UrgenciaDaoImple, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;
    }

    @Override
    public boolean eliminar(Urgencia urgencia) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM URGENCIA WHERE ID="+urgencia.getId();
	try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
	} catch (SQLException e) {
            System.out.println("Error: Clase URGENCIA DaoImple, método eliminar");
            e.printStackTrace();
	}		
	return eliminar;
    }
    @Override
    public boolean actualizaFecha(Urgencia urgencia){
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE URGENCIA SET fecha_salida='"+urgencia.getDateTimeSalida()+"'" +" WHERE ID="+urgencia.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null, "Fecha de Salida Ingresada");
            } catch (SQLException e) {
            System.out.println("Error: Clase UrgenciaDaoImple, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;
    }
    @Override
    public boolean actualizaDiagnostico(Urgencia urgencia){
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql= "update `urgencia` SET id_diagnostico = "+urgencia.getId_diagnostico()+" WHERE id ="+urgencia.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null, "Diagnostico Actualizado");
            } catch (SQLException e) {
            System.out.println("Error: Clase UrgenciaDaoImple, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;
    }
    @Override
    public List<Urgencia> getUrgencias(String criterio,String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
         String sql = "";
	if(isNumeric(valor)){
            sql = "select urgencia.id as id_urgencia, paciente.nombre as nombre_paciente, paciente.apellido1 as apellido_paciente,paciente.id as id_paciente, urgencia.numero_cama, urgencia.causa, urgenciologo.nombre as nombre_urgenciologo, urgenciologo.apellido1 as apellido_urgenciologo, urgenciologo.id as id_urgenciologo, urgencia.fecha_ingreso, urgencia.fecha_salida, urgencia.id_diagnostico from urgencia "
            +"inner join paciente on urgencia.id_paciente = paciente.id inner join urgenciologo on urgencia.id_urgenciologo = urgenciologo.id"
            +" where urgencia."+criterio+"="+valor;
            System.out.println(sql);
        }
        else{
            sql = "select urgencia.id as id_urgencia, paciente.nombre as nombre_paciente, paciente.apellido1 as apellido_paciente,paciente.id as id_paciente, urgencia.numero_cama, urgencia.causa, urgenciologo.nombre as nombre_urgenciologo, urgenciologo.apellido1 as apellido_urgenciologo, urgenciologo.id as id_urgenciologo, urgencia.fecha_ingreso, urgencia.fecha_salida, urgencia.id_diagnostico from urgencia "
            +"inner join paciente on urgencia.id_paciente = paciente.id inner join urgenciologo on urgencia.id_urgenciologo = urgenciologo.id"
            +" where urgencia."+criterio+"='"+valor+"'";
            System.out.println(sql);
        }
	
	List<Urgencia> listaUrgencias = new ArrayList<Urgencia>();	
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Urgencia urgencia = new Urgencia();
                urgencia.setId(rs.getInt("id_urgencia"));
                urgencia.setNombrePaciente(rs.getString("nombre_paciente"));
                urgencia.setApellidoPaciente(rs.getString("apellido_paciente"));
                urgencia.setNombreUrgenciologo(rs.getString("nombre_urgenciologo"));
                urgencia.setApellidoUrgenciologo(rs.getString("apellido_urgenciologo"));
                urgencia.setDateTimeIngreso(rs.getString("fecha_ingreso"));
                urgencia.setDateTimeSalida(rs.getString("fecha_salida"));
                urgencia.setCamilla(rs.getString("numero_cama"));
                urgencia.setCausa(rs.getString("causa"));
                urgencia.setId_diagnostico(rs.getInt("id_diagnostico"));
                urgencia.setId_urgenciologo(rs.getInt("id_urgenciologo"));
                urgencia.setId_paciente(rs.getInt("id_paciente"));
		listaUrgencias.add(urgencia);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
        
	return listaUrgencias;
    }
}
