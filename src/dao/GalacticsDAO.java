package dao;

public class GalacticsDAO extends Entity {

//	private int idGalactic;
	private String name;

	public GalacticsDAO(){}
	public GalacticsDAO(String name){
		super();
//		setIdGalactic(id);
		setName(name);
		}
	
	public static void create() {

	}

	public static void read() {

	}

//	public int getIdGalactic() {
//		return idGalactic;
//	}
//	public void setIdGalactic(int idGalactic) {
//		this.idGalactic = idGalactic;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return "Galactics: [id= " + super.getId() + ", name =" + name + "]";
	}
	
	
}
