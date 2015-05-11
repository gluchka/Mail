package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbonentDAOPlanets  implements AbstractDAO<Integer, Planets> {
	
		
		public static final String SELECT = "SELECT * FROM planet.planets;";
		public static final String DELETE = "Delete  FROM planet.planets where idplanet=?;";

		public List<Planets> selectQuery() {
			List<Planets> abonents = new ArrayList<>();
			Connection cn = null;
			Statement st = null;
			try {
				cn = ConnectorDB.getConnection();
				st = cn.createStatement();
				ResultSet rs = st.executeQuery(SELECT);
				while (rs.next()) {
								
					
					int idPlanet = rs.getInt(1);
					String name = rs.getString(2);
					int radius = rs.getInt(3);
					int temperature = rs.getInt(4);
					String atmosphere = rs.getString(5);
					String existence = rs.getString(6);				
					int idGal = rs.getInt(7);
					abonents.add(new Planets(idPlanet,name,radius, temperature,atmosphere,existence ,idGal));
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
