/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IUrgenciologoDAO;
import Modelo.Especialista;
import Modelo.Urgenciologo;
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
public class UrgenciologoDaoImpl implements IUrgenciologoDAO {

    @Override
    public boolean registrar(Urgenciologo urgenciologo) {
        boolean registrar = false;

		Connection con=null;
                PreparedStatement ps = null;
		String sql="INSERT INTO URGENCIOLOGO (nombre,apellido1,apellido2,antiguedad_años)"
                        + "values ('"+urgenciologo.getNombre()+"','"+urgenciologo.getApellido1()+"','"+urgenciologo.getApellido2()+"',"
                        +urgenciologo.getAntiguedad()+")";
                
		try {			
                    con=Conexion.conectar();
                    ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.execute();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs != null && rs.next()) {
                        urgenciologo.setId(rs.getInt(1));
                    }
                        registrar=true;
			con.close();
                        JOptionPane.showMessageDialog(null, "Registrado!");
		}catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método registrar");
			e.printStackTrace();
		}
		return registrar;
    }

    @Override
    public Urgenciologo obtenerID(int id) {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM URGENCIOLOGO WHERE id = "+id;
		
	Urgenciologo urgenciologo = null;
		
	try {			
            co = Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		urgenciologo = new Urgenciologo();
		urgenciologo.setId(rs.getInt(1));
		urgenciologo.setNombre(rs.getString(2));
                urgenciologo.setApellido1(rs.getString(3));
                urgenciologo.setApellido2(rs.getString(4));
                urgenciologo.setAntiguedad(rs.getInt(5));
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
	return urgenciologo;
    }

    @Override
    public List<Urgenciologo> obtener() {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM URGENCIOLOGO ORDER BY ID";
		
	List<Urgenciologo> listaUrgenciologo = new ArrayList<Urgenciologo>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Urgenciologo urgenciologo=new Urgenciologo();
		urgenciologo.setId(rs.getInt(1));
		urgenciologo.setNombre(rs.getString(2));
                urgenciologo.setApellido1(rs.getString(3));
                urgenciologo.setApellido2(rs.getString(4));
                urgenciologo.setAntiguedad(rs.getInt(5));
                listaUrgenciologo.add(urgenciologo);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaUrgenciologo;   
    }

    @Override
    public boolean actualizar(Urgenciologo urgenciologo) {
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE URGENCIOLOGO SET nombre='"+urgenciologo.getNombre()+"'," 
                +"apellido1='"+urgenciologo.getApellido1()+"',"
                +"apellido2='"+urgenciologo.getApellido2()+"',"
                +"antiguedad_años="+urgenciologo.getAntiguedad()
                +" WHERE ID="+urgenciologo.getId();
		
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
    public boolean eliminar(Urgenciologo urgenciologo) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM URGENCIOLOGO WHERE ID="+urgenciologo.getId();
	try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
            JOptionPane.showMessageDialog(null, "Eliminado!");
	} catch (SQLException e) {
            System.out.println("Error: Clase Departamento DaoImple, método eliminar");
            e.printStackTrace();
	}		
	return eliminar;
    }
    @Override
    public List<Urgenciologo> getUrgenciologos(String criterio,String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
        String sql = "";
	if(isNumeric(valor)){
            sql="SELECT * FROM URGENCIOLOGO WHERE "+criterio+"="+valor+"";
        }
        else{
            sql="SELECT * FROM URGENCIOLOGO WHERE "+criterio+"='"+valor+"'";
        }
	
		
	List<Urgenciologo> listaUrgenciologo = new ArrayList<Urgenciologo>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Urgenciologo urgenciologo =new Urgenciologo();
		urgenciologo.setId(rs.getInt(1));
		urgenciologo.setNombre(rs.getString(2));
                urgenciologo.setApellido1(rs.getString(3));
                urgenciologo.setApellido2(rs.getString(4));
                urgenciologo.setAntiguedad(rs.getInt(5));
		listaUrgenciologo.add(urgenciologo);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaUrgenciologo;
    }
}
