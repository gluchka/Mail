package dao;

public class Satellites extends Entity{
	
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private int idSatellite;
		private String name;
		private int radius;
		private int distance;
		private int idPlan;

		public Satellites(){}
		public Satellites( int id,  String name, int radius, int distance,
				 int idPlan) {
		
			setIdSatellite(id);
			setName(name);
			setRadius(radius);
			setDistance(distance);
			setIdPlan(idPlan);

		}

		public int getIdPlanet() {
			return idSatellite;
		}
	
		public void setIdSatellite(int idSatellite) {
			this.idSatellite = idSatellite;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getIdPlan() {
			return idPlan;
		}

		public void setIdPlan(int idPlan) {
			this.idPlan = idPlan;
		}
		@Override
		public String toString() {
		return	"idPlanet  " + idSatellite+ "  name " +name+"  radius  "+radius+"  distance  "+distance+"idPlan"+idPlan;
			
		}

		
	}


