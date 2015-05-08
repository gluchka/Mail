package xml_task;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JdomParser {

	public static void jdomParser() {

		SAXBuilder parser = new SAXBuilder();
		File fr = new File("src/task.xml");

		try {
			Tourism tour;
			Document document = (Document) parser.build(fr);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("trip");

			for (int i = 0; i < list.size(); i++) {
				tour = new Tourism();
				Element node = (Element) list.get(i);

				
				tour.setTrip(i+1);
				tour.setType(node.getChildText("type"));
				tour.setCountry(node.getChildText("country"));
				tour.setDays(Integer.parseInt(node.getChildText("days-night")));
			
				Demo.collectionAll.add(tour);
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
}
