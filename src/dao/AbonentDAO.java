package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AbonentDAO<T> implements AbstractDAO<Integer, Galactics> {
	public static final String FIRSTREQ = "SELECT name, radius, distance From satellites WHERE idplanet IN (SELECT idplanet FROM planets WHERE existence='yes' AND idgalactic=1111)";
	public static final String SECONDREQ = "SELECT planets.*,count(satellites.idplanet) as countSatelites FROM satellites,planets where planets.idplanet=satellites.idplanet group by satellites.idplanet order by countSatelites desc, planets.radius asc limit 1 ";
	public static final String THIRDREQ = "SELECT *,count(satellites.idplanet) as summa,sum(4/3*(satellites.radius*satellites.radius*satellites.radius))as volumeR  FROM satellites INNER JOIN planets using(idplanet) group by satellites.idplanet order by summa desc limit 1 ";
	public static final String FOURREQ = "SELECT galactics.name, sum(temperature) as summa FROM galactics,planets where planets.idgalactic=galactics.idgalactic group by planets.idgalactic order by summa desc limit 1";

	public void firstRequest() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(FIRSTREQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.println("First request");
			System.out.print("planet name =  " + resultSet.getString("name")
					+ ", ");
			System.out.print("  radius: " + resultSet.getInt("radius") + ", ");
			System.out.println("  distance: " + resultSet.getInt("distance"));
			;
		} catch (SQLException e) {
			System.err.println("SQL exception (request or table failed):" + e);
		}

	}

	public void secondRequest() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SECONDREQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.println("Second request");
			System.out.print("planet name=  " + resultSet.getString("name")
					+ ", ");
			System.out.print("  radius:  " + resultSet.getInt("radius") + ", ");
			System.out.print("  temperature:  "
					+ resultSet.getInt("temperature") + ", ");
			System.out.print("  atmosphere:  "
					+ resultSet.getString("atmosphere") + ", ");
			System.out.print("  existence:  "
					+ resultSet.getString("existence") + ", ");
			System.out.println("  max satellite count:  "
					+ resultSet.getInt("countSatelites") + ".");
			;
		} catch (SQLException e) {

			System.err.println("SQL exception (request or table failed):" + e);
		}

	}

	public void thirdRequest() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(THIRDREQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.println("Third request");
			System.out.print("planet name =  " + resultSet.getString("name")
					+ ", ");
			System.out.print("  radius: " + resultSet.getInt("radius") + ", ");
			System.out.print("  temperature: "
					+ resultSet.getInt("temperature") + ", ");
			System.out.print("atmosphere =  "
					+ resultSet.getString("atmosphere") + ", ");
			System.out.print("existence =  " + resultSet.getString("existence")
					+ ", ");
			System.out.print("  galacticId: " + resultSet.getInt("idgalactic")
					+ ", ");
			System.out.print("  count of satellites: "
					+ resultSet.getInt("summa") + ", ");
			System.out.println("  total volume: " + resultSet.getInt("volumeR")
					+ ", ");
			;
		} catch (SQLException e) {
			System.err.println("SQL exception (request or table failed):" + e);
		}

	}

	public void fourRequest() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(FOURREQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.println("Four request");
			System.out
					.println("galaxy, the sum of the temperatures of it planets  the largest  is: "
							+ resultSet.getString("name"));
			;
		} catch (SQLException e) {
			System.err.println("SQL exception (request or table failed):" + e);
		}
	}

	@Override
	public List<Galactics> selectQuery() {
		return null;
	}

	@Override
	public boolean deleteQuery() {
		return false;
	}

}
