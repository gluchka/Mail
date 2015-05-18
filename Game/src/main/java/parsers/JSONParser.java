package parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class JSONParser {
	final static String filePath =	"src\\main\\resources\\parser.json";
	
	
		public static List<String> jsonParser() {
//			 List<String> cities = new ArrayList<String>();
//			try {
//				FileReader reader = new FileReader(filePath);			
//				JSONParser jsonParser = new JSONParser();
//				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//				JSONArray lang = (JSONArray) jsonObject.get("City");
//				for (int i = 0; i < lang.size(); i++) {
//					String city = (String) lang.get(i);
//					cities.add(city.toLowerCase());
//				}
//			} catch (FileNotFoundException ex) {
//				ex.printStackTrace();
//			} catch (IOException ex2) {
//				ex2.printStackTrace();
//			} catch (ParseException ex3) {
//				ex3.printStackTrace();
//			} catch (NullPointerException ex4) {
//				ex4.printStackTrace();
//			}
			return null;
		}

	}

