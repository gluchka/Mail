package dao;

public class PlanetsDAO extends Entity {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private int idPlanet;
	private String name;
	private int radius;
	private int temperature;
	private String atmosphere;
	private String existence;
	private int idGal;

	public PlanetsDAO(){}
	public PlanetsDAO( String name, int radius, int temperature,
			String atmosphere, String existence, int idGal) {
		super();
//		setIdPlanet(idPlanet);
		setName(name);
		setRadius(radius);
		setTemperature(temperature);
		setAtmosphere(atmosphere);
		setExistence(existence);
		setIdGal(idGal);

	}

//	public int getIdPlanet() {
//		return idPlanet;
//	}
//
//	public void setIdPlanet(int idPlanet) {
//		this.idPlanet = idPlanet;
//	}

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

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getExistence() {
		return existence;
	}

	public void setExistence(String existence) {
		this.existence = existence;
	}

	public int getIdGal() {
		return idGal;
	}

	public void setIdGal(int idGal) {
		this.idGal = idGal;
	}
	@Override
	public String toString() {
	return	"idPlanet  " + super.getId()+ "  name " +name+"  radius  "+radius+"  temperature  "+temperature+"atmosphere"+atmosphere+"existence"+existence+"idGal"+idGal;
		
	}

	
}
