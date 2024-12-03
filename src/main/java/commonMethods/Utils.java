package commonMethods;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Utils {
	
	public static String exefile = Utils.getDataFromTestConfig("TestExeFile");
	
	public static String getDataFromTestData(String autoTestCaseNameVal, String Sheetname,String label) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/data/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(Sheetname);
			int rowNum = ws.getLastRowNum() + 1;

			Iterator rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {

				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				String cellVal = cellToString(cell);
				//System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					//System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							//System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow
									.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							//System.out.println("Cell Val: "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requiredCellVal.trim();
	}
	
	
	public static String getDataFromTestConfig(String component)
	
	{
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/data/TestConfiguration.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
            int numberOfCells = 0;
            if (rowIterator.hasNext())
            {
                Row headerRow = (Row) rowIterator.next();
                //get the number of cells in the header row
                numberOfCells = headerRow.getLastCellNum();
            }
            
			for (int index = 0; index < rowNum; index++) 
			{
				XSSFRow row = ws.getRow(index);
				
				for(int cellIndex=0; cellIndex<numberOfCells; cellIndex++)
				{
					XSSFCell cell = row.getCell(cellIndex);
					String cellVal = cellToString(cell);
					if (cellVal.equals(component)) 
					{
						XSSFCell adjacentCell = row.getCell(cellIndex+1);
						String adjacentCellVal = cellToString(adjacentCell);
						requiredCellVal = adjacentCellVal;
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}
	
	public static String cellToString(XSSFCell cell) {
	    CellType type;
	    String result;
	    type = cell.getCellType();

	    switch (type) {
	        case NUMERIC: // numeric value in Excel
	            result = "" + cell.getNumericCellValue();
	            break;
	        case FORMULA: // precomputed value based on formula
	            result = "" + cell.getNumericCellValue();
	            break;
	        case STRING: // String Value in Excel
	            result = "" + cell.getStringCellValue();
	            break;
	        case BLANK:
	            result = "";
	            break;
	        case BOOLEAN: // boolean value
	            result = "" + cell.getBooleanCellValue();
	            break;
	        case ERROR:
	            result = "Error";
	            break;
	        default:
	            throw new RuntimeException("There is no support for this type of cell");
	    }

	    return result;
	}
	
	@Test
	public static String multipleDataExecution(String Path,int ColumnNum,int RowNum)
	{
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
            int numberOfCells = 0;
            if (rowIterator.hasNext())
            {
                Row headerRow = (Row) rowIterator.next();
                //get the number of cells in the header row
                numberOfCells = headerRow.getLastCellNum();
            }
			for (int index = 0; index < rowNum; index++) 
			{
				XSSFRow row = ws.getRow(index);	
				for(int cellIndex=0; cellIndex<numberOfCells; cellIndex++)
				{
					XSSFCell cell = row.getCell(cellIndex);
					try{
					String cellVal = cellToString(cell);
					if ((cellIndex==ColumnNum)&&(index==RowNum))
					{
						XSSFCell adjacentCell = row.getCell(cellIndex);
						String adjacentCellVal = cellToString(adjacentCell);
						
						requiredCellVal = adjacentCellVal;
  					  break;
					}
					}
					catch(NullPointerException w)
					{
						requiredCellVal="";
					}				
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}
	
	
	
	
	public static int getNoOfRows(String Path)
	{
		int rowNum =0;
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
            int numberOfCells = 0;
           

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return rowNum;
	}
	
	public static Properties readproperties() throws Exception  {
		FileInputStream file;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/data/Properties.properties");
		    prop = new Properties();
		    prop.load(file);
		
           } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		 }
		return prop;
		
	}
	public static String getproperties(String key) throws Exception {
		 Properties prop =readproperties();
		return prop.getProperty(key).toString();
	}

	
}