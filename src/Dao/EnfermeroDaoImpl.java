/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IEnfermeroDAO;
import Modelo.Enfermero;
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
public class EnfermeroDaoImpl implements IEnfermeroDAO{

    @Override
    public boolean registrar(Enfermero enfermero) {
        boolean registrar = false;

	Connection con=null;
        PreparedStatement ps = null;
	String sql="INSERT INTO ENFERMERO (nombre,apellido1,apellido2,antiguedad) "
                        + "values ('"+enfermero.getNombre()+"','"+enfermero.getApellido1()+"','"+enfermero.getApellido2()+"',"
                        +enfermero.getAntiguedad()+")";
	try {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                enfermero.setId(rs.getInt(1));
            }
            registrar=true;
            con.close();
            JOptionPane.showMessageDialog(null,"Registrado!");
            } catch (SQLException e) {
            	System.out.println("Error: Clase ClienteDaoImple, método registrar");
		e.printStackTrace();
            }
	return registrar;
    }

    @Override
    public Enfermero obtenerID(int id) {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="SELECT * FROM ENFERMERO WHERE id = "+id;
		
	Enfermero enfermero = null;
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                enfermero = new Enfermero();
		enfermero.setId(rs.getInt(1));
		enfermero.setNombre(rs.getString(2));
                enfermero.setApellido1(rs.getString(3));
                enfermero.setApellido2(rs.getString(4));
                enfermero.setAntiguedad(rs.getInt(5));
		}
		stm.close();
		rs.close();
		co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ENFERMERO DaoImple, método obtener");
			e.printStackTrace();
		}
		return enfermero;
    }

    @Override
    public List<Enfermero> obtener() {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
	
	String sql="SELECT * FROM PACIENTE ORDER BY ID";
		
	List<Enfermero> listaEnfermero = new ArrayList<Enfermero>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Enfermero enfermero = new Enfermero();
		enfermero.setId(rs.getInt(1));
		enfermero.setNombre(rs.getString(2));
                enfermero.setApellido1(rs.getString(3));
                enfermero.setApellido2(rs.getString(4));
                enfermero.setAntiguedad(rs.getInt(5));
		listaEnfermero.add(enfermero);
            }
		stm.close();
		rs.close();
		co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		
	return listaEnfermero;
    }

    @Override
    public boolean actualizar(Enfermero enfermero) {
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE ENFERMERO SET nombre='"+enfermero.getNombre()+"',"
                + "apellido1='"+enfermero.getApellido1()+"',"
                + "apellido2='"+enfermero.getApellido2()+"',"
                + "antiguedad="+enfermero.getAntiguedad()
                + " WHERE ID="+enfermero.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            JOptionPane.showMessageDialog(null,"Actualizado!");
            } catch (SQLException e) {
            System.out.println("Error: Clase EnfermeroDAO IMPL, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;
    }

    @Override
    public boolean eliminar(Enfermero enfermero) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM ENFERMERO WHERE ID="+enfermero.getId();
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
    public List<Enfermero> getEnfermeros(String criterio,String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
         String sql = "";
	if(isNumeric(valor)){
            sql="SELECT * FROM ENFERMERO WHERE "+criterio+"="+valor+"";
        }
        else{
            sql="SELECT * FROM ENFERMERO WHERE "+criterio+"='"+valor+"'";
        }
	
		
	List<Enfermero> listaEnfermero = new ArrayList<Enfermero>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Enfermero enfermero = new Enfermero();
		enfermero.setId(rs.getInt(1));
		enfermero.setNombre(rs.getString(2));
                enfermero.setApellido1(rs.getString(3));
                enfermero.setApellido2(rs.getString(4));
                enfermero.setAntiguedad(rs.getInt(5));
		listaEnfermero.add(enfermero);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaEnfermero;
    }
}
