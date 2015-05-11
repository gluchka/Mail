package dao;

public class MainDAO {

	public static void main(String[] args) {

		AbonentDAO abonent = new AbonentDAO();
		abonent.firstRequest();
		 abonent.secondRequest();
		abonent.thirdRequest();
		abonent.fourRequest();
//		
		
		AbonentDAOGalaxy galaxy =new AbonentDAOGalaxy();
//		galaxy.deleteQuery();
//		galaxy.selectQuery();
		
		AbonentDAOPlanets planet = new AbonentDAOPlanets();
//		planet.deleteQuery();
//		planet.selectQuery();
		
		AbonentDAOSatellites satellite = new AbonentDAOSatellites();
//		satellite.deleteQuery();
//		satellite.selectQuery();
	}

}
