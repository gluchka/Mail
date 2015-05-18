package factory;

import java.util.ArrayList;
import java.util.List;

import parsers.*;
import parsers.jdbc.*;



public class Factory {
	public enum TypeParser {
		TXT,JSON, XLS,XML,DB
	}
	public static List<String> cities ;
	public static void chooseParser(String typeParser) {
	TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
	switch (type) {
	case TXT:
		cities	= TXTParser.txtParser();
	case XLS:
			Myself.getFullTable();    
//	case JSON:
//		JSONParser.jsonParser();
	case DB:
		cities	= JDBCRunner.parserBD();
	default:
		TXTParser.txtParser();
	}
		
	}
}
