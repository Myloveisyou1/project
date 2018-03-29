package com.jiemin.wages.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/28 0028 15:17
 */
public class ExcelReadUtil {

    private static final String EXTENSION_XLS = "xls";
    private static final String EXTENSION_XLSX = "xlsx";

    private static Workbook getWorkbook(String filePath)
            throws IOException
    {
        Workbook workbook = null;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(is);
        } else if (filePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(is);
        }
        return workbook;
    }

    private static void preReadCheck(String filePath)
            throws FileNotFoundException, FileFormatException
    {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("传入的文件不存在" + filePath);
        }
        if ((!filePath.endsWith("xls")) && (!filePath.endsWith("xlsx"))) {
            throw new FileFormatException("传入的文件不是excel");
        }
    }

    private static String getCellValue(Cell cell, boolean treatAsStr)
    {
        if (cell == null) {
            return "";
        }
        if (treatAsStr) {
            cell.setCellType(1);
        }
        if (cell.getCellType() == 4) {
            return String.valueOf(cell.getBooleanCellValue());
        }
        if (cell.getCellType() == 0) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return String.valueOf(cell.getStringCellValue());
    }

    public static List<String[]> readExcel(String filePath) throws FileNotFoundException, FileFormatException
    {
        //List<ExcelVO> vos = new ArrayList();
        // 创建一个list 用来存储读取的内容
        List<String[]> list = new ArrayList<String[]>();

        preReadCheck(filePath);

        Workbook workbook = null;
        try
        {
            workbook = getWorkbook(filePath);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++)
            {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet != null)
                {
                    int firstRowIndex = sheet.getFirstRowNum();//获取第一行
                    int lastRowIndex = sheet.getLastRowNum();   //获取最后一行
                    //因为有表头,所以从第二行开始
                    for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++){
                        String[] str = new String[lastRowIndex+1];
                        Row currentRow = sheet.getRow(rowIndex);//当前行的数据
                        int firstColumnIndex = currentRow.getFirstCellNum();//第一个单元格的位置
                        int lastColumnIndex = currentRow.getLastCellNum();  //最后一个单元格的位置
                        for (int columnIndex = firstColumnIndex; columnIndex < lastColumnIndex; columnIndex++){
                            Cell currentCell = currentRow.getCell(columnIndex);
                            String currentCellValue = getCellValue(currentCell, true);
                            System.out.println(currentCellValue);
                            str[rowIndex] = currentCellValue;
                        }
                        list.add(str);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (workbook != null) {
                workbook = null;
            }
        }
        return list;
    }

    public static void main(String[] args)
            throws FileNotFoundException, FileFormatException
    {
        List<String[]> vos = readExcel("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        System.out.println(vos);
    }
}
