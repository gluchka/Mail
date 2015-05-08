package xml_task;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.kohsuke.rngom.digested.DListPattern;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

	static ArrayList<Tourism> dList = new ArrayList<Tourism>();

	public static void saxParser() {

		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();

			DefaultHandler defaultHandler = new DefaultHandler() {
				Tourism tour;

				boolean trip = false;
				boolean type = false;
				boolean country = false;
				boolean days = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					// System.out.println("Start element: " +
					// qName.equalsIgnoreCase("trip"));

					if (qName.equalsIgnoreCase("trip") && (qName != null)) {
						trip = true;
					}
					if (qName.equalsIgnoreCase("type") && (qName != null)) {
						type = true;
					}
					if (qName.equalsIgnoreCase("country") && (qName != null)) {
						country = true;
					}
					if (qName.equalsIgnoreCase("days-night") && (qName != null)) {
						days = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					// System.out.println("EndEl: " + qName);
				}

				// Tourism tour = new Tourism();
				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (trip) {

						tour = new Tourism();
						dList.add(tour);
						tour.setTrip(1);
						trip = false;

					}

					if (type) {
						tour.setType(new String(ch, start, length));
						type = false;
					}
					if (country) {
						tour.setCountry(new String(ch, start, length));
						country = false;
					}
					if (days) {
						tour.setDays(Integer.parseInt(new String(ch, start,
								length)));
						days = false;
					}
				}
			};

			saxParser.parse("src/task.xml", defaultHandler);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		Demo.collectionAll.addAll(dList);

	}
}
