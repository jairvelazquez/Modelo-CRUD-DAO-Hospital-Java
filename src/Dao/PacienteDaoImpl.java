/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Idao.IPacienteDAO;
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
public class PacienteDaoImpl implements IPacienteDAO {

    @Override
    public boolean registrar(Paciente paciente) {
        boolean registrar = false;

		Connection con=null;
                PreparedStatement ps = null;
		String sql="INSERT INTO PACIENTE (nombre,apellido1,apellido2,sexo,edad,tipo_sangre,telefono) "
                        + "values ('"+paciente.getNombre()+"','"+paciente.getApellido1()+"','"+paciente.getApellido2()+"','"
                        +paciente.getSexo()+"',"+paciente.getEdad()+",'"+paciente.getTipo_sangre()+"','"+paciente.getTelefono()+"')";
                
		try {			
                    con=Conexion.conectar();
                    ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.execute();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs != null && rs.next()) {
                        paciente.setId(rs.getInt(1));
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
    public Paciente obtenerID(int id) {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM DEPARTAMENTO WHERE id = "+id;
		
		Paciente paciente = null;
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt(1));
				paciente.setNombre(rs.getString(2));
                                paciente.setApellido1(rs.getString(3));
                                paciente.setApellido2(rs.getString(4));
                                paciente.setSexo(rs.getString(5));
                                paciente.setEdad(rs.getInt(6));
                                paciente.setTipo_sangre(rs.getString(7));
                                paciente.setTelefono(rs.getString(8));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		return paciente;
    }

    @Override
    public List<Paciente> obtener() {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM PACIENTE ORDER BY ID";
		
		List<Paciente> listaPaciente = new ArrayList<Paciente>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Paciente paciente=new Paciente();
				paciente.setId(rs.getInt(1));
				paciente.setNombre(rs.getString(2));
                                paciente.setApellido1(rs.getString(3));
                                paciente.setApellido2(rs.getString(4));
                                paciente.setSexo(rs.getString(5));
                                paciente.setEdad(rs.getInt(6));
                                paciente.setTipo_sangre(rs.getString(7));
                                paciente.setTelefono(rs.getString(8));
				listaPaciente.add(paciente);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		
	return listaPaciente;
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        Connection connect= null;
		Statement stm= null;
		boolean actualizar=false;
				
		String sql="UPDATE PACIENTE SET nombre='"+paciente.getNombre()+"',"
                        + "apellido1 ='"+paciente.getApellido1()+"',"
                        + "apellido2 ='"+paciente.getApellido2()+"',"
                        + "sexo ='"+paciente.getSexo()+"',"
                        + "edad ="+paciente.getEdad()+","
                        + "tipo_sangre ='"+paciente.getTipo_sangre()+"',"
                        + "telefono ='"+paciente.getTelefono()+"'"
                        + " WHERE ID="+paciente.getId();
                
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null, "Actualizado!");
            } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;
    }

    @Override
    public boolean eliminar(Paciente paciente) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM PACIENTE WHERE ID="+paciente.getId();
	try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
            JOptionPane.showMessageDialog(null, "Eliminado");
	} catch (SQLException e) {
            System.out.println("Error: Clase Departamento DaoImple, método eliminar");
            e.printStackTrace();
	}		
	return eliminar;
    }
    @Override
    public List<Paciente> getPacientes(String criterio, String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
         String sql = "";
	if(isNumeric(valor)){
            sql="SELECT * FROM PACIENTE WHERE "+criterio+"="+valor+"";
        }
        else{
            sql="SELECT * FROM PACIENTE WHERE "+criterio+"='"+valor+"'";
        }
	
	List<Paciente> listaPaciente = new ArrayList<Paciente>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Paciente paciente=new Paciente();
		paciente.setId(rs.getInt(1));
		paciente.setNombre(rs.getString(2));
                paciente.setApellido1(rs.getString(3));
                paciente.setApellido2(rs.getString(4));
                paciente.setSexo(rs.getString(5));
                paciente.setEdad(rs.getInt(6));
                paciente.setTipo_sangre(rs.getString(7));
                paciente.setTelefono(rs.getString(8));
		listaPaciente.add(paciente);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaPaciente;
    }
    public static boolean isNumeric(String cadena) {
        
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
