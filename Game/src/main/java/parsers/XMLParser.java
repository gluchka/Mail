package parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
//import org.jdom2.JDOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	final static String filePath = "src\\main\\resources\\parser.xml";

	public static void main(String[] args) {
		try {
			jdomParser();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public static List<String> jdomParser() throws JDOMException, IOException,
			ParserConfigurationException, SAXException {
		List<String> city = new ArrayList<String>();

		File xmlFile = new File(filePath);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = (Document) documentBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		NodeList nodeList = document.getElementsByTagName(document
				.getDocumentElement().getChildNodes().item(1).getNodeName());

		int length = nodeList.getLength();
		Node[] copy = new Node[length];

		for (int n = 0; n < length; ++n) {
			city.add(nodeList.item(n).getChildNodes().item(0).getNodeValue());
		}
		System.out.println(city.size());
		return city;
	}

	// public static List<String> jdomParser() {
	//
	// SAXBuilder parser = new SAXBuilder();
	// File fr = new File(filePath);
	// List<String> city = new ArrayList<String>();
	//
	// try {
	// Document document = (Document) parser.build(fr);
	// Element rootNode = document.getRootElement();
	// List list = rootNode.getChildren("cities");
	//
	// for (int i = 0; i < list.size(); i++) {
	// Element node = (Element) list.get(i);
	// city.add(node.getChildText("city"));
	// System.out.println(city);
	// }
	//
	//
	// } catch (IOException io) {
	// System.out.println(io.getMessage());
	// } catch (JDOMException jdomex) {
	// System.out.println(jdomex.getMessage());
	// }
	// return city;
	// }
}
