package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AbonentDAO implements AbstractDAO<Integer, PlanetsDAO> {
	
	public static final String FOURFEQ = "SELECT galactics.name, sum(temperature) as summa FROM galactics,planets where planets.idgal=galactics.idgalactic group by planets.idgal order by summa desc limit 1";
	public static final String SECONDREQ = "SELECT planets.*,count(satellites.idplan) as countSatelites FROM satellites,planets where planets.idplanet=satellites.idplan group by satellites.idplan order by countSatelites desc, planets.radius asc limit 1 ";

	
//	@Override
//	public Planets findEntityById(Integer Id) {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public boolean delete(Integer Id) {
//		throw new UnsupportedOperationException();
//	}
//	@Override
//	public boolean delete(Planets entity) {
//		throw new UnsupportedOperationException();
//	}
//	@Override
//	public boolean create(Planets entity) {
//		throw new UnsupportedOperationException();
//	}
//	@Override
//	public Planets update(Planets entity) {
//		return null;
//	}

	
	public void secondRequest() {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SECONDREQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.print("planet name=  "+resultSet.getString("name")+", ");
			System.out.print("  radius:  "+resultSet.getInt("radius")+", ");
			System.out.print("  temperature:  "+resultSet.getInt("temperature")+", ");
			System.out.print("  atmosphere:  "+resultSet.getString("atmosphere")+", ");
			System.out.print("  existence:  "+resultSet.getString("existence")+", ");
			System.out.print("  max satellite count:  "+resultSet.getInt("countSatelites")+".");
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
			st = cn.prepareStatement(FOURFEQ);
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			System.out.println("galaxy, the sum of the temperatures of it planets  the largest  is: "+resultSet.getString("name"));
			;
		} catch (SQLException e) {

			System.err.println("SQL exception (request or table failed):" + e);
		}

	}

}
