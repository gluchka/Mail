package xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static final String filePath = "jsonOne.json";

	public static void jsonParser() {
		
		try {

			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray lang = (JSONArray) jsonObject.get("trips");

			// for(int i=0; i<lang.size(); i++){
			//
			// System.out.println("The " + i +
			// " element of the array: "+lang.get(i));
			// }

			Iterator i = lang.iterator();
			 Tourism tour;
					while (i.hasNext()) {
			
						tour = new Tourism();
				
				JSONObject innerObj = (JSONObject) i.next();
				
//				tour.setTrip((Integer)innerObj.get("trip"));
				tour.setType((String) innerObj.get("type"));
				tour.setType((String) innerObj.get("country"));
//				tour.setType((String) innerObj.get("days-night"));
//				System.out.println(tour.toString()+"     !!!!!!!!!!");
							
//				System.out.println("trips! " + innerObj.get("trip")
//						+ " with type " + innerObj.get("type") + ", country "
//						+ innerObj.get("country") + ", days-night "
//						+ innerObj.get("days-night"));
//				Demo.collectionAll.add(tour);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}
}
