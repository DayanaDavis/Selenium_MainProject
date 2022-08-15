package com.buffaloCart.utilities;

import com.buffaloCart.constants.Constant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtility {
    public String readSingleData(int i, int j, String sheetname) {
        String filepath = System.getProperty("user.dir") + Constant.EXCEL_FILE;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheet(sheetname);
        Row r = sheet.getRow(i);
        Cell c = r.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
        return value;
    }

    public Object[][] readDataFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int noOfRows = sheet.getLastRowNum();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[noOfRows][noOfColumns];
        for (int i = 1; i <= noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter formatter = new DataFormatter();
                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            System.out.println();
        }
        workbook.close();
        file.close();
        return data;
    }

    public List<ArrayList<String>> getExcelAs2DList(String sheetName){
        String filepath = System.getProperty("user.dir") + Constant.EXCEL_FILE;
        FileInputStream file = null;
        try {
            file = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();
        String[] columnList = new String[cellCount];
        List<ArrayList<String>> excelData = new ArrayList<ArrayList<String>>();
        for (int i = 0; i <= rowCount; i++) {
            Row r = sheet.getRow(i);
            for (int j = 0; j < cellCount; j++) {
                Cell c = r.getCell(j);
                DataFormatter formatter = new DataFormatter();
                columnList[j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
                excelData.add(new ArrayList<String>(Arrays.asList(columnList)));


        }
        return excelData;
    }
    public List<String> getExcelAsArrayList(String sheetName){
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
        FileInputStream file = null;
        try {
            file = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();
        List<String> values=new ArrayList<String>();
        for (int i = 0; i <= rowCount; i++) {
            Row r = sheet.getRow(i);
            for (int j = 0; j < cellCount; j++) {
                Cell c = r.getCell(j);
                DataFormatter formatter = new DataFormatter();
                values.add (formatter.formatCellValue(sheet.getRow(i).getCell(j)));
            }

        }
       return values;
    }
}
