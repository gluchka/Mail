package xml_task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static final String filePath = "src/jsonOne.json";

	public static void jsonParser() {
		
		try {

			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray lang = (JSONArray) jsonObject.get("trips");
			
			Iterator i = lang.iterator();
			 Tourism tour;
					while (i.hasNext()) {
						tour = new Tourism();		
				JSONObject innerObj = (JSONObject) i.next();
			
				tour.setTrip(Integer.parseInt((String) innerObj.get("trip")));
				tour.setType((String) innerObj.get("type"));
				tour.setCountry((String) innerObj.get("country"));
				tour.setDays(Integer.parseInt((String)innerObj.get("days-night")));

				Demo.collectionAll.add(tour);
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
