package xml_task;

import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import xml_task.parser.Trip;
import xml_task.parser.Trips;

public class JaxbParser {

	public static void jaxbParser() {

		
		
		try {
			JAXBContext jc = JAXBContext.newInstance(Trips.class);

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Trips allTrip;
			allTrip = (Trips) unmarshaller.unmarshal(new File("src/task.xml"));
			Marshaller marshaller;
			marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(allTrip, System.out);
		
			
			 List<Tourism> list = new ArrayList<Tourism>();
		        
		          Demo.collectionAll.addAll(list);
		       
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
