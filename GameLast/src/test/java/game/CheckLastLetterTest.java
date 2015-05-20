package game;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckLastLetterTest {
	
	private static final Logger log = Logger.getLogger(User.class);
	
	
	@DataProvider
	public Object[][] testLastLetter() {
		return new Object[][] {
				new Object[] { 'В', "Харьков" },
				new Object[] { 'Г', "Кременчуг" },
		};
	}

//	@DataProvider
//	public Object[][] checkWordInList() {
//		return new Object[][] {
//				new Object[] {  "Лондон" },
//				new Object[] {  "Кременчуг" },
//		};
//	}
	
  @Test(dataProvider="testLastLetter")
  public void getLastTest(char last, String word) {
   char expected=last;
   char actual= Players.checkLastLetter(word);
 Assert.assertEquals(expected,actual);
 log.info("assertion true for testLastLetter");
  }
  
    
  
  
//  @Test(dataProvider="checkWordInList")
//  public void checkWordInList(String sity) {
//	  String expected=null;
//	  String actual= User.checkInList(sity);
//	 Assert.assertEquals(expected,actual);
//	 log.info("assertion true for checkWordInList");
//	  }
  
 

}