
package com.mycompany.stiw3054_a2;


import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;

public class savetoexcel {
    public void writeData() {
        try {

             Json link = new Json();
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet("Statistic");
            
             //create row Header
             Row rowHeader = sheet.createRow(0);
             rowHeader.createCell(0).setCellValue("    Login ID          ");
             rowHeader.createCell(1).setCellValue("    Number of Repositories   ");
             rowHeader.createCell(2).setCellValue("    Number of Followers      ");
             rowHeader.createCell(3).setCellValue("    Number of Events         ");
             rowHeader.createCell(4).setCellValue("    Number of Subcriptions   ");
             rowHeader.createCell(5).setCellValue("    Type      ");

             //set row heading size, font and position
             for (int i = 0; i <= 5; i++) {
                 CellStyle style = workbook.createCellStyle();
                 Font font = workbook.createFont();
                 font.setBold(true);
                 font.setFontName(HSSFFont.FONT_ARIAL);
                 style.setFont(font);
                 style.setVerticalAlignment(VerticalAlignment.CENTER);
                 rowHeader.getCell(i).setCellStyle(style);
             }
            
             //column size
             
             int r = 1;
             for (Data info : link.Scrape()) {
                 //Create row
                 Row row = sheet.createRow(r);
                 //column 1 : matric
                 Cell Column1 = row.createCell(0);
                 Column1.setCellValue(info.getfollowersId());
                 //column 2 : name
                 Cell Column2 = row.createCell(1);
                 Column2.setCellValue(info.gettotalrepos());
                 //column 3 : link
                 Cell Column3 = row.createCell(2);
                 Column3.setCellValue(info.gettotalfollowers());
                 Cell Column4 = row.createCell(3);
                 Column4.setCellValue(info.gettotalevents());
                 Cell Column5 = row.createCell(4);
                 Column5.setCellValue(info.gettotalsubscriptions());
                 Cell Column6 = row.createCell(5);
                 Column6.setCellValue(info.getType());
                 r++;
             }
             
              //column size
             for (int i = 1; i <= 35; i++)
                sheet.autoSizeColumn(i);
              
             //Save to Excel 
             FileOutputStream out = new FileOutputStream(new File("D:\\Report.xls"));
             workbook.write(out);
             out.close();
             workbook.close();

        } catch (Exception e) {
          System.out.print(e.getStackTrace());
        }
    }
}
