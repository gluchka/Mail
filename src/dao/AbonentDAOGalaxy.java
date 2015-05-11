package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbonentDAOGalaxy<T> implements AbstractDAO<Integer, Galactics> {
	
	public static final String SELECT = "SELECT * FROM planet.galactics;";
	public static final String DELETE = "Delete  FROM planet.galactics where idgalactic=?;";

	public List<Galactics> selectQuery() {
		List<Galactics> abonents = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(SELECT);
			while (rs.next()) {
				int idGalactic = rs.getInt(1);
				String name = rs.getString(2);
				abonents.add(new Galactics(idGalactic, name));
			}
			System.out.println(abonents);
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return null;
	}
	
	public boolean deleteQuery() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(DELETE);
			st.executeUpdate();
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return  true;
	}

	
	
	

	
}
