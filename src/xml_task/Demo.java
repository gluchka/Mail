package xml_task;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class Demo {
	static List<Tourism> collectionAll;

	public static void main(String[] args) throws InstantiationException,IllegalAccessException {
		collectionAll = new ArrayList<Tourism>();

//		Factory.chooseParser("dom");
//		Factory.chooseParser("jdom");
		Factory.chooseParser("sax");
//		JsonBuilder.fromXmlToJson();
//		Factory.chooseParser("json");
//		Factory.chooseParser("jaxb");
//		Factory.chooseParser("xls");
		
				
		// Collections.sort(collectionAll, Tourism.class.newInstance());

		System.out.println(collectionAll);

	}
}
