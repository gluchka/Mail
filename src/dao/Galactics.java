package dao;


public class Galactics extends Entity {

	private int idGalactic;
	private String name;

	public Galactics(){}
	public Galactics(int id,String name){

		setIdGalactic(id);
		setName(name);
		}
	
	public static void create() {

	}

	public static void read() {

	}

	public int getIdGalactic() {
		return idGalactic;
	}
	public void setIdGalactic(int idGalactic) {
		this.idGalactic = idGalactic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return "Galactics: [id= " + idGalactic + ", name =" + name + "]";
	}
	
	
}
