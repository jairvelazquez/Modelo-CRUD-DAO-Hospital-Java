/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Idao.IDiagnosticoDAO;
import Modelo.Diagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class DiagnosticoDaoImpl implements IDiagnosticoDAO{

    @Override
    public int registrar(Diagnostico diagnostico) {
        Connection con=null;
        PreparedStatement ps = null;
        String sql="INSERT INTO DIAGNOSTICO (id_urgencia,id_urgenciologo,id_departamento,id_especialista,gravedad) "
                   + "values ("+diagnostico.getIDUrgencia()+","+diagnostico.getIdUgrneciologo()+","+diagnostico.getIdDepartamento()+","+diagnostico.getIdEspecialista()+",'"
                   +diagnostico.getGravedad()+"')";
        try {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                diagnostico.setId(rs.getInt(1));
            }
            con.close();
            }catch (SQLException e) {
                System.out.println("Error: Clase DiagnosticoDaoImple, método registrar");
                e.printStackTrace();
            }
	return diagnostico.getId();
    }

    @Override
    public Diagnostico obtenerID(int id) {
        Connection co =null;
	Statement stm= null;
	ResultSet rs=null;
		
	String sql="select diagnostico.id as id_diagnostico, urgencia.id as id_urgencia, paciente.nombre as nombre_paciente, paciente.apellido1 as apellido_paciente, diagnostico.gravedad, especialista.nombre as nombre_especialista, especialista.apellido1 as apellido_especialista, departamento.nombre_departamento from diagnostico "
        +"inner join urgencia on diagnostico.id_urgencia = urgencia.id inner join paciente on urgencia.id_paciente = paciente.id inner join especialista on diagnostico.id_especialista = especialista.id inner join departamento on diagnostico.id_departamento = departamento.id"
        +" where diagnostico.id ="+id;
		
	Diagnostico diagnostico = null;
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
            	diagnostico = new Diagnostico();
		diagnostico.setId(rs.getInt("id_diagnostico"));
                diagnostico.setIdUrgencia(rs.getInt("id_urgencia"));
                diagnostico.setNombrePaciente(rs.getString("nombre_paciente"));
                diagnostico.setApellidoPaciente(rs.getString("apellido_paciente"));
                diagnostico.setGravedad(rs.getString("gravedad"));
                diagnostico.setNombreEspecialista(rs.getString("nombre_especialista"));
                diagnostico.setApellidoEspecialista(rs.getString("apellido_especialista"));
                diagnostico.setNombreDepartamento(rs.getString("nombre_departamento"));
            }
		stm.close();
		rs.close();
		co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DIAGNOSTICO DaoImple, método obtener");
            e.printStackTrace();
	}
	return diagnostico;
    }

    @Override
    public List<Diagnostico> obtener() {
        Connection co =null;
        Statement stm= null;
	ResultSet rs=null;
	
	String sql="SELECT * FROM DIAGNOSTICO ORDER BY ID";
		
	List<Diagnostico> listaDiagnostico = new ArrayList<Diagnostico>();
		
	try {			
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
		Diagnostico diagnostico = new Diagnostico();
 		diagnostico.setId(rs.getInt(1));
                diagnostico.setIdUgrneciologo(rs.getInt(2));
                diagnostico.setIdDepartamento(rs.getInt(3));
                diagnostico.setIdEspecialista(rs.getInt(4));
                diagnostico.setGravedad(rs.getString(5));
		listaDiagnostico.add(diagnostico);
            }
            stm.close();
            rs.close();
            co.close();
	} catch (SQLException e) {
            System.out.println("Error: Clase DIAGNOSTICO DaoImple, método obtener");
            e.printStackTrace();
	}
		
	return listaDiagnostico;
    }

    @Override
    public boolean actualizar(Diagnostico diagnostico) {
        Connection connect= null;
	Statement stm= null;
	boolean actualizar=false;
				
	String sql="UPDATE DIAGNOSTICO SET gravedad='"+diagnostico.getGravedad()+"'" +" WHERE ID="+diagnostico.getId();
		
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
		}		
        return actualizar;  
    }

    @Override
    public boolean eliminar(Diagnostico diagnostico) {
        Connection connect= null;
	Statement stm= null;
		
	boolean eliminar=false;
			
	String sql="DELETE FROM DIAGNOSTICO WHERE ID="+diagnostico.getId();
	try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
	} catch (SQLException e) {
            System.out.println("Error: Clase DIAGNOSTICO DaoImple, método eliminar");
            e.printStackTrace();
	}		
	return eliminar;
    }
    
}
