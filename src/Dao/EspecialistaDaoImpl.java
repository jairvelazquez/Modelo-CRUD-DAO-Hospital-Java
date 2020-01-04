/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IEspecialistaDAO;
import Modelo.Especialista;
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
public class EspecialistaDaoImpl implements IEspecialistaDAO {

    @Override
    public boolean registrar(Especialista especialista) {
        boolean registrar = false;

	Connection con=null;
        PreparedStatement ps = null;
	String sql="INSERT INTO ESPECIALISTA (id_departamento,nombre,apellido1,apellido2,especialidad,antiguedad_años) "
                + "values ("+especialista.getId_departamento()+",'"+especialista.getNombre()+"','"+especialista.getApellido1()+"','"+especialista.getApellido2()+"','"
                +especialista.getEspecialidad()+"',"+especialista.getAntiguedad()+")";
                
        try {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                especialista.setId(rs.getInt(1));
            }
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
    public Especialista obtenerID(int id) {
                Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM ESPECIALISTA WHERE id = "+id;
		
		Especialista especialista = null;
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				especialista = new Especialista();
				especialista.setId(rs.getInt(1));
                                especialista.setId_departamento(rs.getInt(2));
				especialista.setNombre(rs.getString(3));
                                especialista.setApellido1(rs.getString(4));
                                especialista.setApellido2(rs.getString(5));
                                especialista.setEspecialidad(rs.getString(6));
                                especialista.setAntiguedad(rs.getInt(7));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ESPECIALISTA DaoImple, método obtener");
			e.printStackTrace();
		}
		return especialista;
    }

    @Override
    public List<Especialista> obtener() {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM ESPECIALISTA ORDER BY ID";
		
		List<Especialista> listaEspecialista = new ArrayList<Especialista>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Especialista especialista = new Especialista();
				especialista.setId(rs.getInt(1));
                                especialista.setId_departamento(rs.getInt(2));
				especialista.setNombre(rs.getString(3));
                                especialista.setApellido1(rs.getString(4));
                                especialista.setApellido2(rs.getString(5));
                                especialista.setEspecialidad(rs.getString(6));
                                especialista.setAntiguedad(rs.getInt(7));
                                listaEspecialista.add(especialista);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		
	return listaEspecialista;
    }

    @Override
    public boolean actualizar(Especialista especialista) {
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE ESPECIALISTA SET nombre='"+especialista.getNombre()+"'," +
                "id_departamento="+especialista.getId_departamento()+","+
                "apellido1='"+especialista.getApellido1()+"',"+
                "apellido2='"+especialista.getApellido2()+"',"+
                "especialidad='"+especialista.getEspecialidad()+"',"+
                "antiguedad_años="+especialista.getAntiguedad()+
                " WHERE ID="+especialista.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null,"Actualizado!");
            } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
	}		
        return actualizar;  
    }

    @Override
    public boolean eliminar(Especialista especialista) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM ESPECIALISTA WHERE ID="+especialista.getId();
        
	try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
            JOptionPane.showMessageDialog(null,"Eliminado!");
	} catch (SQLException e) {
            System.out.println("Error: Clase Departamento DaoImple, método eliminar");
            e.printStackTrace();
	}		
	return eliminar; 
    }
    @Override
    public List<Especialista> getEspecialistas(String criterio, String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
         String sql = "";
	if(isNumeric(valor)){
            sql="SELECT * FROM ESPECIALISTA WHERE "+criterio+"="+valor+"";
        }
        else{
            sql="SELECT * FROM ESPECIALISTA WHERE "+criterio+"='"+valor+"'";
        }
	
		
	List<Especialista> listaEspecialista = new ArrayList<Especialista>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Especialista especialista=new Especialista();
		especialista.setId(rs.getInt(1));
                especialista.setId_departamento(rs.getInt(2));
		especialista.setNombre(rs.getString(3));
                especialista.setApellido1(rs.getString(4));
                especialista.setApellido2(rs.getString(5));
                especialista.setEspecialidad(rs.getString(6));
                especialista.setAntiguedad(rs.getInt(7));
		listaEspecialista.add(especialista);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaEspecialista;
    }
}
