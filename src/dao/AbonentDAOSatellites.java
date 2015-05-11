package dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	public class AbonentDAOSatellites implements AbstractDAO<Integer, Satellites> {
		
		public static final String SELECT = "SELECT * FROM planet.satellites;";
		public static final String DELETE = "Delete  FROM planet.satellites where idsatellite=?;";

		public List<Satellites> selectQuery() {
			List<Satellites> abonents = new ArrayList<>();
			Connection cn = null;
			Statement st = null;
			try {
				cn = ConnectorDB.getConnection();
				st = cn.createStatement();
				ResultSet rs = st.executeQuery(SELECT);
				while (rs.next()) {
								
					int idSatellite = rs.getInt(1);
					String name = rs.getString(2);
					int radius = rs.getInt(3);
					int distance = rs.getInt(4);
					int idPlan = rs.getInt(5);
					abonents.add(new Satellites(idSatellite,name,radius, distance,idPlan ));
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
