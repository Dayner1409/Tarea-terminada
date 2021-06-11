package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.tipo_cliente;
import util.MySqlDBConexion;

public class ClienteModel {
	public List<Cliente> consultaCliente(String DNI){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "select c.idCliente,c.nombres,c.apellidos,c.fechaNacimiento,c.idTipoCliente , t.nombre from cliente c inner " 
						+ "join tipo_cliente t on c.idTipoCliente= t.idTpoCliente where c.dni= ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, String.valueOf(DNI));
			
			
			rs = pstm.executeQuery();
					
			Cliente objCliente = null;
			tipo_cliente objtipo_cliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombre(rs.getString(2));
				objCliente.setApellido(rs.getString(3));
				objCliente.setFechaNacimiento(rs.getDate(4));
				
				objtipo_cliente = new tipo_cliente();
				objtipo_cliente.setIdTipoCliente(rs.getInt(5));
				objtipo_cliente.setNombre(rs.getString(6));
				
				objCliente.setTipo_cliente(objtipo_cliente);
				
				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public List<Cliente> consultaCliente(){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "select c.idCliente,c.nombres,c.apellidos,c.fechaNacimiento,c.idTipoCliente, t.nombre from cliente c inner "
						+ "join tipo_cliente t on c.idTipoCliente= t.idTpoCliente ";
			pstm = con.prepareStatement(sql);
			rs= pstm.executeQuery();
			
			
			rs = pstm.executeQuery();
					
			Cliente objCliente = null;
			tipo_cliente objtipo_cliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombre(rs.getString(2));
				objCliente.setApellido(rs.getString(3));
				objCliente.setFechaNacimiento(rs.getDate(4));
				
				objtipo_cliente = new tipo_cliente();
				objtipo_cliente.setIdTipoCliente(rs.getInt(5));
				objtipo_cliente.setNombre(rs.getString(6));
				
				objCliente.setTipo_cliente(objtipo_cliente);
				
				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
