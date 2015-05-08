package xml_task;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;


public class DomParser {
	
	
	public static void domParser(){
	try
    {
        File xmlFile = new File("src/task.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
     
        ////////////
        Tourism tt ;
        
        for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
        {
            Node node = nodeList.item(tmp);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
            	
                Element element = (Element)node;
              
                ///////////////
                tt = new Tourism();
                tt.setTrip(tmp+1);
                tt.setType(element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue());
                tt.setCountry(element.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue());
                tt.setDays(Integer.parseInt(element.getElementsByTagName("days-night").item(0).getChildNodes().item(0).getNodeValue()));
         
                Demo.collectionAll.add(tt);
            }
        }
    }
    catch (Exception e)
    {
        System.out.println(e.getLocalizedMessage());
        e.printStackTrace();
    }
	
}
}

