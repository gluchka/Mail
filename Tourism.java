package xml;

//import java.util.Comparator;

public class Tourism { 
//implements Comparator<Tourism>{

	private int trip;
	private String type;
	private String country;
	private int days;
	
	public Tourism(){}
		
	public int getTrip() {
		return trip;
	}
	
	public void setTrip(int trip) {
		this.trip = trip;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}

	public int compare(Tourism o1, Tourism o2) {
		
		return (int)(Math.ceil(o1.getDays()-o2.getDays()));
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Tour: ");
		builder.append("trip= ");
		builder.append(trip);
		builder.append(", type= ");
		builder.append(type);
		builder.append(", country= ");
		builder.append(country);
		builder.append(", days= ");
		builder.append(days);
		builder.append("");
		builder.append("\n");
		
		return builder.toString();
	}

}
