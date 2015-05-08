package xml_task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class XLParser {

	final static String filePath = "src/parser.xls";
	private HashMap<Integer, ArrayList<String>> table;

	public static HashMap<Integer, ArrayList<String>> getFullTable() {
		HashMap<Integer, ArrayList<String>> table = new HashMap<Integer, ArrayList<String>>();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			HSSFRow currentRow = null;
			HSSFCell currentCell = null;
			int currentRowNumber = 0; 
			int currentCellNumber = 0;
			int rowNumber = 1; 
			
			while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
				ArrayList<String> row = new ArrayList<String>();
				while ((currentCell = currentRow.getCell(currentCellNumber)) != null) {
					row.add(currentCell.toString());
					currentCellNumber++;
				}
				
				table.put(rowNumber,row);
				currentRowNumber++;
				currentCellNumber = 0;
				rowNumber++;
			}
			System.out.println(table);
			
			//beautiful print
			for (Map.Entry<Integer, ArrayList<String>> tableRow : table.entrySet()) {
				for (int i = 0; i < tableRow.getValue().size(); i++) {
					System.out.print(tableRow.getValue().get(i) + " ");
				}
				System.out.println();
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}
	
	public ArrayList<String> getTableRow(String rowNumber) {
		ArrayList<String> row = new ArrayList<String>();
		if (table == null) {
			table = getFullTable();
		}
		if(Integer.parseInt(rowNumber) < table.keySet().size()) {
			row = table.get(rowNumber);
		}

		return row;
	}
	
	
}
