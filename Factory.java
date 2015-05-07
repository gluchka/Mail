package xml;

public class Factory {
	
		public enum TypeParser {
			DOM,JDOM, SAX, JSON
		}
		
		public static void chooseParser(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case DOM:
			DomParser.domParser();
		case JDOM:
			JdomParser.jdomParser();
		case SAX:
			SaxParser.saxParser();
		case JSON:
			JsonParser.jsonParser();
			
		}
		}
}
