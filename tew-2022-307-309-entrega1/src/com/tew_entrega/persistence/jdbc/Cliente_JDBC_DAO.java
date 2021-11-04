package com.tew_entrega.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tew_entrega.model.Cliente;
import com.tew_entrega.persistence.templates.Cliente_DAO;

public class Cliente_JDBC_DAO implements Cliente_DAO {
	@Override
	public List<Cliente> getClientes() throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM CLIENTE");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("ID"));
				cliente.setLogin(rs.getString("LOGIN"));
				cliente.setPassword(rs.getString("PASSWORD"));
				cliente.setNombre(rs.getString("NOMBRE"));
				cliente.setApellidos(rs.getString("APELLIDOS"));
				cliente.setEmail(rs.getString("EMAIL"));
				clientes.add(cliente);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return clientes;
	}

	@Override
	public void save(Cliente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("INSERT INTO CLIENTE (LOGIN, PASSWORD, NOMBRE, APELLIDOS, EMAIL) VALUES(?, ?, ?, ?, ?)");
			
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getNombre());
			ps.setString(4, a.getApellidos());
			ps.setString(5, a.getEmail());
			
			ps.executeUpdate();
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
	}

	@Override
	public void update(Cliente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("UPDATE CLIENTE SET LOGIN=?, PASSWORD=?, NOMBRE=?, APELLIDOS=?, EMAIL=? WHERE ID=?");

			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getNombre());
			ps.setString(4, a.getApellidos());
			ps.setString(5, a.getEmail());
			ps.setInt(6, a.getId());
			
			ps.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
	}

	@Override
	public void delete(Cliente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM CLIENTE WHERE CLIENTE.ID=?");
			ps.setInt(1, a.getId());

			ps.executeUpdate();
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}

	}

	@Override
	public Cliente findById(int id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		Cliente cliente = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM CLIENTE WHERE CLIENTE.ID=? LIMIT 1");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("ID"));
				cliente.setLogin(rs.getString("LOGIN"));
				cliente.setPassword(rs.getString("PASSWORD"));
				cliente.setNombre(rs.getString("NOMBRE"));
				cliente.setApellidos(rs.getString("APELLIDOS"));
				cliente.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}

		return cliente;
	}

}
