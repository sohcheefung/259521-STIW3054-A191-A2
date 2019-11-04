
package com.mycompany;

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
            Row rowTitle = sheet.createRow(0);
            rowTitle.createCell(0).setCellValue("    Login ID          ");
            rowTitle.createCell(1).setCellValue("    Number of Repositories   ");
            rowTitle.createCell(2).setCellValue("    Number of Followers      ");
            rowTitle.createCell(3).setCellValue("    Number of Events         ");
            rowTitle.createCell(4).setCellValue("    Number of Subcriptions   ");
            rowTitle.createCell(5).setCellValue("    Type      ");

             //set row heading size, font and position
            for (int i = 0; i <= 5; i++) {
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowTitle.getCell(i).setCellStyle(style);
            }
            
             //column size
             
            int r = 1;
            for (Define info : link.Scrape()) {
                 //Create row
                Row row = sheet.createRow(r);
                 //column 1 : loginId
                Cell Column1 = row.createCell(0);
                Column1.setCellValue(info.getloginId());
                //column 2 : totalrepos
                Cell Column2 = row.createCell(1);
                Column2.setCellValue(info.gettotalrepos());
                //column 3 : totalfollowers
                Cell Column3 = row.createCell(2);
                Column3.setCellValue(info.gettotalfollowers());
                //column 4 : totalfollowings
                Cell Column4 = row.createCell(3);
                Column4.setCellValue(info.gettotalfollowings());
                //column 5 : totalgists
                Cell Column5 = row.createCell(4);
                Column5.setCellValue(info.gettotalgists());
                //column 6 : type
                Cell Column6 = row.createCell(5);
                Column6.setCellValue(info.getType());
                r++;
            }
             
             //column size
            for (int i = 1; i <= 35; i++)
                sheet.autoSizeColumn(i);
              
            //Save to Excel 
            FileOutputStream result = new FileOutputStream(new File("D:\\Report.xls"));
            workbook.write(result);
            result.close();
            workbook.close();

        }catch (Exception e) {
          System.out.print(e.getStackTrace());
        }
    }
}
