package xml_task.parser;

 
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trip {

	

	    @XmlElement(name="type")
	    public String type;

	    @XmlElement(name="country")
	    public String country;

	    @XmlElement(name="days-night")
	    public String days;


	}

