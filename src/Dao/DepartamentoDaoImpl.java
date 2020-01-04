/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Conexion.Conexion;
import static Dao.PacienteDaoImpl.isNumeric;
import Idao.IDepartamentoDAO;
import Modelo.Departamento;
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
public class DepartamentoDaoImpl implements IDepartamentoDAO{
    
    @Override
    public boolean registrar(Departamento departamento) {
		boolean registrar = false;

		Connection con=null;
                PreparedStatement ps = null;
		String sql="INSERT INTO DEPARTAMENTO (nombre_departamento) values ('"+departamento.getNombreDepartamento()+"')";
                
		try {			
                    con=Conexion.conectar();
                    ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.execute();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs != null && rs.next()) {
                        departamento.setId(rs.getInt(1));
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
	public List<Departamento> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM DEPARTAMENTO ORDER BY ID";
		
		List<Departamento> listaDepartamento = new ArrayList<Departamento>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Departamento c=new Departamento();
				c.setId(rs.getInt(1));
				c.setNombreDepartamento(rs.getString(2));
				listaDepartamento.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaDepartamento;
	}
 
	@Override
	public boolean actualizar(Departamento departamento) {
		Connection connect= null;
		Statement stm= null;
		boolean actualizar=false;
				
		String sql="UPDATE DEPARTAMENTO SET nombre_departamento='"+departamento.getNombreDepartamento()+"'" +" WHERE ID="+departamento.getId();
		
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
	public boolean eliminar(Departamento departamento) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM DEPARTAMENTO WHERE ID="+departamento.getId();
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
    public Departamento obtenerID(int id) {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM DEPARTAMENTO WHERE id = "+id;
		
		Departamento departamento = new Departamento();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				departamento = new Departamento();
				departamento.setId(rs.getInt(1));
				departamento.setNombreDepartamento(rs.getString(3));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
			e.printStackTrace();
		}
		return departamento ;
    }   
    @Override
    public List<Departamento> getDepartamentos(String criterio,String valor){
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
        String sql = "";
        
	if(isNumeric(valor)){
            sql="SELECT * FROM DEPARTAMENTO WHERE "+criterio+"="+valor+"";
        }
        else{
            sql="SELECT * FROM DEPARTAMENTO WHERE "+criterio+"='"+valor+"'";
        }	
	List<Departamento> listaDepartamento = new ArrayList<Departamento>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt(1));
		departamento.setNombreDepartamento(rs.getString(2));
		listaDepartamento.add(departamento);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DEPARTAMENTO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaDepartamento;
    }
}
