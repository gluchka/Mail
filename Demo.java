package xml;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class Demo {
	static List<Tourism> collectionAll;

	public static void main(String[] args) throws InstantiationException,IllegalAccessException {
		collectionAll = new ArrayList<Tourism>();

//		Factory.chooseParser("dom");
		Factory.chooseParser("jdom");
//		Factory.chooseParser("sax");
//		Factory.chooseParser("json");
		
		
		
		// Collections.sort(collectionAll, Tourism.class.newInstance());

		System.out.println(collectionAll);

	}
}
