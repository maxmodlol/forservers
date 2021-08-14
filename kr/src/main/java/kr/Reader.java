package kr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This program read date values from XLSX file in Java using Apache POI.
 * 
 * @author WINDOWS 8
 *
 */


public class Reader {

    
    public static Object infoFromExcel(String file, double ItemNumber) throws IOException
    {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Books");
        XSSFRow row = myExcelSheet.getRow(0);
        //According to the ID number choose which row you want to get info from.
        if(ItemNumber==1)
        {
         row = myExcelSheet.getRow(1);
         }
        else if (ItemNumber==2) 
        {
        	row = myExcelSheet.getRow(2);
        }
        else if (ItemNumber==3) 
        {
        	row = myExcelSheet.getRow(3);
        }
        else 
        {
        	row = myExcelSheet.getRow(4);
        }
        
        
      
            int ID = (int)row.getCell(0).getNumericCellValue();
            System.out.println("ID :" + ID);
            String name = row.getCell(1).getStringCellValue();
            System.out.println("NAME : " + name);
            double price = row.getCell(2).getNumericCellValue();
            System.out.println(" price:" + price);
            double amount = row.getCell(3).getNumericCellValue();
            System.out.println("amount :" + amount);
            String topic = row.getCell(4).getStringCellValue();
            System.out.println("topic : " + topic);
//        String data = new String(ID+" ,"+name+" ,"+price+" ,"+amount+" ,"+topic);
        
       String s;
       HashMap<String, Object> map = new HashMap<>();
       map.put("id", ID);
       map.put("name", name);
       map.put("price", price);
       map.put("amount", amount);
       map.put("topic", topic);
       
        
        myExcelBook.close();
		return map;
        
    }//look up function
    
    public static Object SearchFromExcel(String file, String topic) throws IOException
    {
    	 XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
         XSSFSheet myExcelSheet = myExcelBook.getSheet("Books");
         XSSFRow row = myExcelSheet.getRow(0);
    	if(topic.equals("DistributedSystems"))
    	{
    		row = myExcelSheet.getRow(1);
            double ID1 = row.getCell(0).getNumericCellValue();
            String name1 = row.getCell(1).getStringCellValue();
            
    		row = myExcelSheet.getRow(2);
    		 double ID2 = row.getCell(0).getNumericCellValue();
             String name2 = row.getCell(1).getStringCellValue();
             
             String book1 = ID1+" , "+name1;
             String book2 = ID2+" , "+name2;
             String data = book1 +"  //  "+book2;
             return data;
             

    	}
    	else if (topic.equals("UnderGraduateSchool"))
    	{
    		row = myExcelSheet.getRow(3);
            double ID1 = row.getCell(0).getNumericCellValue();
            String name1 = row.getCell(1).getStringCellValue();
            
    		row = myExcelSheet.getRow(4);
    		 double ID2 = row.getCell(0).getNumericCellValue();
             String name2 = row.getCell(1).getStringCellValue();
             
             String book1 = ID1+" , "+name1;
             String book2 = ID2+" , "+name2;
             String data = book1 +"  //  " +book2;
             return data;
    		
    	}
    	else {
    	
		return "This topic does not exist";
    	}
    	
    }//Search function
    
	
}