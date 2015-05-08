package xml_task.parser;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Trips {


	@XmlElement(name = "trip")
	public List<Trip> trips;


	
	
}
