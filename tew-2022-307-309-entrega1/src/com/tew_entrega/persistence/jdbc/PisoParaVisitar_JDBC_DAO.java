package com.tew_entrega.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;
import com.tew_entrega.model.Usuario;
import com.tew_entrega.persistence.templates.PisoParaVisitar_DAO;

public class PisoParaVisitar_JDBC_DAO implements PisoParaVisitar_DAO {

	@Override
	public List<PisoParaVisitar> getPisosParaVisitar() throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<PisoParaVisitar> pisosparavisitar = new ArrayList<PisoParaVisitar>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO_PARA_VISITAR");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PisoParaVisitar pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_CITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
				pisosparavisitar.add(pisoparavisitar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisosparavisitar;
	}

	@Override
	public void save(PisoParaVisitar a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR (ID_PISO, ID_CLIENTE, FECHA_HORA_CITA, ESTADO_VISITA) VALUES(?, ?, ?, ?)");

			ps.setInt(1, a.getId_piso());
			ps.setInt(2, a.getId_cliente());
			ps.setLong(3, a.getFecha_hora_cita());
			ps.setInt(4, a.getEstado_visita());

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
	public void update(PisoParaVisitar a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("UPDATE PISO_PARA_VISITAR SET ID_PISO=?, ID_CLIENTE=?, FECHA_HORA_CITA=?, ESTADO_VISITA=? WHERE ID=?");

			ps.setInt(1, a.getId_piso());
			ps.setInt(2, a.getId_cliente());
			ps.setLong(3, a.getFecha_hora_cita());
			ps.setInt(4, a.getEstado_visita());
			ps.setInt(5, a.getId());
			
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
	public void delete(PisoParaVisitar a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM PISO_PARA_VISITAR WHERE ID=?");
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
	public PisoParaVisitar findById(int id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		PisoParaVisitar pisoparavisitar = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM PISO_PARA_VISITAR WHERE PISO_PARA_VISITAR.ID_PISO=? LIMIT 1");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_VISITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}

		return pisoparavisitar;
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroHora(long hora_inferior, long hora_superior) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<PisoParaVisitar> pisosparavisitar = new ArrayList<PisoParaVisitar>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement(""
					+ "SELECT * FROM PISO_PARA_VISITAR "
					+ "WHERE FECHA_HORA_CITA "
					+ "BETWEEN ? AND ? "
					+ "ORDER BY FECHA_HORA_CITA ASC"
					);
			
			ps.setLong(1, hora_inferior);
			ps.setLong(2, hora_superior);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PisoParaVisitar pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_CITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
				pisosparavisitar.add(pisoparavisitar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisosparavisitar;
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroCliente(Cliente c) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<PisoParaVisitar> pisosparavisitar = new ArrayList<PisoParaVisitar>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement(""
					+ "SELECT * FROM PISO_PARA_VISITAR "
					+ "WHERE ID_CLIENTE=?"
					);
			
			ps.setLong(1, c.getId());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PisoParaVisitar pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_CITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
				pisosparavisitar.add(pisoparavisitar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisosparavisitar;
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroAgente(Agente a) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<PisoParaVisitar> pisosparavisitar = new ArrayList<PisoParaVisitar>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement(""
					+ "SELECT * FROM PISO_PARA_VISITAR "
					+ "INNER JOIN PISO ON PISO_PARA_VISITAR.ID_PISO = PISO.ID "
					+ "INNER JOIN AGENTE ON PISO.ID_AGENTE = AGENTE.ID "
					+ "WHERE AGENTE.ID=?"
					);
			
			ps.setLong(1, a.getId());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PisoParaVisitar pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_CITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
				pisosparavisitar.add(pisoparavisitar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisosparavisitar;
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroPiso(Piso p) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<PisoParaVisitar> pisosparavisitar = new ArrayList<PisoParaVisitar>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement(""
					+ "SELECT * FROM PISO_PARA_VISITAR "
					+ "WHERE ID_PISO=?"
					);
			
			ps.setLong(1, p.getId());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PisoParaVisitar pisoparavisitar = new PisoParaVisitar();
				pisoparavisitar.setId(rs.getInt("ID"));
				pisoparavisitar.setId_piso(rs.getInt("ID_PISO"));
				pisoparavisitar.setId_cliente(rs.getInt("ID_CLIENTE"));
				pisoparavisitar.setFecha_hora_cita(rs.getLong("FECHA_HORA_CITA"));
				pisoparavisitar.setEstado_visita(rs.getInt("ESTADO_VISITA"));
				pisosparavisitar.add(pisoparavisitar);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return pisosparavisitar;
	}

}
