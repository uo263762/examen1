package com.tew_entrega.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tew_entrega.model.Agente;
import com.tew_entrega.persistence.templates.Agente_DAO;

public class Agente_JDBC_DAO implements Agente_DAO {

	@Override
	public List<Agente> getAgentes() throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Agente> agentes = new ArrayList<Agente>();

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM AGENTE");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Agente agente = new Agente();
				agente.setId(rs.getInt("ID"));
				agente.setLogin(rs.getString("LOGIN"));
				agente.setPassword(rs.getString("PASSWORD"));
				agentes.add(agente);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}
		return agentes;
	}

	@Override
	public void save(Agente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("INSERT INTO AGENTE (LOGIN, PASSWORD) VALUES(?, ?)");
			
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			
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
	public void update(Agente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("UPDATE AGENTE SET LOGIN=?, PASSWORD=? WHERE ID=?");

			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			ps.setInt(3, a.getId());
			
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
	public void delete(Agente a) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM AGENTE WHERE ID=?");
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
	public Agente findById(int id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		Agente agente = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("SELECT * FROM AGENTE WHERE AGENTE.ID=? LIMIT 1");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				agente = new Agente();
				agente.setId(rs.getInt("ID"));
				agente.setLogin(rs.getString("LOGIN"));
				agente.setPassword(rs.getString("PASSWORD"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (Exception ex) {}}
			if (ps != null) {try {ps.close();} catch (Exception ex) {}}
			if (con != null) {try {con.close();} catch (Exception ex) {}}
		}

		return agente;
	}

	@Override
	public void borrar_todo() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM PISO_PARA_VISITAR"); ps.executeUpdate();
			ps = con.prepareStatement("DELETE FROM PISO"); ps.executeUpdate();
			ps = con.prepareStatement("DELETE FROM AGENTE"); ps.executeUpdate();
			ps = con.prepareStatement("DELETE FROM CLIENTE"); ps.executeUpdate();
			
			ps = con.prepareStatement("INSERT INTO AGENTE VALUES(1,'agente1@micorreo.com','clave1')"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO AGENTE VALUES(2,'agente2@micorreo.com','clave2')"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO CLIENTE VALUES(1,'user1@micorreo.com','clave1','user1','micorreo','user1@micorreo.com')"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO CLIENTE VALUES(2,'user2@micorreo.com','clave2','user2','micorreo','user12micorreo.com')"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(1,1,212000,'Calle 1','Oviedo',2021,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(2,1,212000,'Calle 2','Oviedo',2021,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(3,1,212000,'Calle 3','Oviedo',2021,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(4,1,212000,'Calle 4','Oviedo',2021,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(5,1,212000,'Calle 5','Oviedo',2021,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(6,1,212000,'Calle 6','Gijon',2022,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(7,1,212000,'Calle 7','Gijon',2022,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(8,1,212000,'Calle 8','Gijon',2022,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(9,1,212000,'Calle 9','Gijon',2022,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(10,1,212000,'Calle 10','Gijon',2022,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(11,1,212000,'Calle 11','Aviles',2023,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(12,1,212000,'Calle 12','Aviles',2023,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(13,1,212000,'Calle 13','Aviles',2023,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(14,1,212000,'Calle 14','Aviles',2023,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(15,1,212000,'Calle 15','Aviles',2023,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(16,1,212000,'Calle 16','Llanes',2024,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(17,1,212000,'Calle 17','Llanes',2024,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(18,1,212000,'Calle 18','Llanes',2024,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(19,1,212000,'Calle 19','Llanes',2024,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(20,1,212000,'Calle 20','Llanes',2024,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(21,2,212000,'Calle -1','Oviedo',2021,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(22,2,212000,'Calle -2','Oviedo',2021,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(23,2,212000,'Calle -3','Oviedo',2021,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(24,2,212000,'Calle -4','Oviedo',2021,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(25,2,212000,'Calle -5','Oviedo',2021,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(26,2,212000,'Calle -6','Gijon',2022,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(27,2,212000,'Calle -7','Gijon',2022,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(28,2,212000,'Calle -8','Gijon',2022,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(29,2,212000,'Calle -9','Gijon',2022,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(30,2,212000,'Calle -10','Gijon',2022,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(31,2,212000,'Calle -11','Aviles',2023,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(32,2,212000,'Calle -12','Aviles',2023,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(33,2,212000,'Calle -13','Aviles',2023,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(34,2,212000,'Calle -14','Aviles',2023,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(35,2,212000,'Calle -15','Aviles',2023,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(36,2,212000,'Calle -16','Llanes',2024,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(37,2,212000,'Calle -17','Llanes',2024,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(38,2,212000,'Calle -18','Llanes',2024,3)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(39,2,212000,'Calle -19','Llanes',2024,4)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO VALUES(40,2,212000,'Calle -20','Llanes',2024,5)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(1,1,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(2,2,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(3,3,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(4,4,1,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(5,5,1,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(6,6,1,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(7,7,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(8,8,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(9,9,1,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(10,21,2,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(11,22,2,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(12,23,2,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(13,24,2,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(14,25,2,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(15,26,2,1577228400000,2)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(16,27,2,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(17,28,2,1577228400000,1)"); ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO PISO_PARA_VISITAR VALUES(18,29,2,1577228400000,1)"); ps.executeUpdate();

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ex) {
				}
			}
		}
	}

}
