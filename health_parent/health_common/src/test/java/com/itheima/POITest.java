package com.itheima;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author JinLu
 * @date 2019/11/12 20:21
 */
public class POITest {
    /**
     * 使用POI读取Excel文件
     * @throws Exception
     *//*
    @Test
    public void test1() throws Exception{
        //加载指定文件，创建一个Excel对象
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("/Users/mac/Documents/test.xlsx")));
        //读取Excel文件中的第一个Sheet标签
        XSSFSheet sheet = excel.getSheetAt(0);
        //遍历Sheet标签获得每一行数据
        for (Row row: sheet) {
            //遍历行获得每一个单元格对象
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }
        //关闭资源
        excel.close();
    }

    *//**
     * 使用POI读取Excel中的数据
     * @throws Exception
     *//*
    @Test
    public void test2() throws Exception {
        //加载指定文件，创建一个Excel对象 XSSFWorkbook
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("/Users/mac/Documents/test.xlsx")));
        //读取Excel文件中的第一个Sheet标签
        XSSFSheet sheet = excel.getSheetAt(0);
        //获取当前工作表中的最后一个行号
        int lastRowNum = sheet.getLastRowNum();
        //遍历
        for (int i = 0; i <= lastRowNum; i++){
            //根据行号获取每一行
            XSSFRow row = sheet.getRow(i);
            //获得当前最后一个单元格索引
            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                //根据单元格索引获取单元格对象
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }
    }

    @Test
    public void test3() throws Exception {
        //在内存中创建一个Excel文件
        XSSFWorkbook excel = new XSSFWorkbook();
        //创建一个工作表对象
        XSSFSheet sheet = excel.createSheet("test2");
        //在工作表中创建行对象
        XSSFRow row = sheet.createRow(0);
        //在行中创建单元格对象
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("住址");

        XSSFRow dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("justin");
        dataRow.createCell(1).setCellValue("13");
        dataRow.createCell(2).setCellValue("北京");

        FileOutputStream outputStream = new FileOutputStream(new File("/Users/mac/Documents/test3.xlsx"));
        excel.write(outputStream);
        outputStream.flush();
        excel.close();
    }*/

}
