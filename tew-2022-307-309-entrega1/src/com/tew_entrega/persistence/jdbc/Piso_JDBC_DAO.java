package com.tew_entrega.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew_entrega.model.Piso;
import com.tew_entrega.persistence.templates.Piso_DAO;



public class Piso_JDBC_DAO implements Piso_DAO {
	
	@Override
	public List<Piso> getPisos() throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Piso> pisos = new ArrayList<Piso>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Piso piso = new Piso();
				piso.setId(rs.getInt("ID"));
				piso.setId_agente(rs.getInt("ID_AGENTE"));
				piso.setPrecio(rs.getFloat("PRECIO"));
				piso.setDireccion(rs.getString("DIRECCION"));
				piso.setCiudad(rs.getString("CIUDAD"));
				piso.setAno(rs.getInt("ANO"));
				piso.setEstado(rs.getInt("ESTADO"));
				pisos.add(piso);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisos;
	}

	@Override
	public void save(Piso a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("INSERT INTO PISO (ID_AGENTE, PRECIO, DIRECCION, CIUDAD, ANO, ESTADO) VALUES(?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, a.getId_agente());
			ps.setFloat(2, a.getPrecio());
			ps.setString(3, a.getDireccion());
			ps.setString(4, a.getCiudad());
			ps.setInt(5, a.getAno());
			ps.setInt(6, a.getEstado());
			
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
	public void update(Piso a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("UPDATE PISO SET ID_AGENTE=?, PRECIO=?, DIRECCION=?, CIUDAD=?, ANO=?, ESTADO=? WHERE ID=?");

			ps.setInt(1, a.getId_agente());
			ps.setFloat(2, a.getPrecio());
			ps.setString(3, a.getDireccion());
			ps.setString(4, a.getCiudad());
			ps.setInt(5, a.getAno());
			ps.setInt(6, a.getEstado());
			ps.setInt(7, a.getId());
			
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
	public void delete(Piso a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM PISO WHERE ID=?");
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
	public Piso findById(int id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		Piso piso = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO WHERE PISO.ID=? LIMIT 1");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				piso = new Piso();
				piso.setId(rs.getInt("ID"));
				piso.setId_agente(rs.getInt("ID_AGENTE"));
				piso.setPrecio(rs.getFloat("PRECIO"));
				piso.setDireccion(rs.getString("DIRECCION"));
				piso.setCiudad(rs.getString("CIUDAD"));
				piso.setAno(rs.getInt("ANO"));
				piso.setEstado(rs.getInt("ESTADO"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}

		return piso;
	}

	@Override
	public List<Piso> getPisosFiltroCIUDAD(String filtro) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Piso> pisos = new ArrayList<Piso>();
		
		filtro = '%' + filtro + '%';

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO WHERE CIUDAD LIKE ?");
			
			ps.setString(1, filtro);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Piso piso = new Piso();
				piso.setId(rs.getInt("ID"));
				piso.setId_agente(rs.getInt("ID_AGENTE"));
				piso.setPrecio(rs.getFloat("PRECIO"));
				piso.setDireccion(rs.getString("DIRECCION"));
				piso.setCiudad(rs.getString("CIUDAD"));
				piso.setAno(rs.getInt("ANO"));
				piso.setEstado(rs.getInt("ESTADO"));
				pisos.add(piso);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisos;
	}

	@Override
	public List<Piso> getPisosFiltroPRECIO(float precio_inferior, float precio_superior) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Piso> pisos = new ArrayList<Piso>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO WHERE PRECIO BETWEEN ? AND ? ORDER BY PRECIO ASC");
			
			ps.setFloat(1, precio_inferior);
			ps.setFloat(2, precio_superior);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Piso piso = new Piso();
				piso.setId(rs.getInt("ID"));
				piso.setId_agente(rs.getInt("ID_AGENTE"));
				piso.setPrecio(rs.getFloat("PRECIO"));
				piso.setDireccion(rs.getString("DIRECCION"));
				piso.setCiudad(rs.getString("CIUDAD"));
				piso.setAno(rs.getInt("ANO"));
				piso.setEstado(rs.getInt("ESTADO"));
				pisos.add(piso);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisos;
	}

}
