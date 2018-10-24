import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class T1 {

    public static  void main (String[]args){

Scrapper ty = new Scrapper();//call class
        List<String>list = ty.getArrayList();//create object list dan get back method scrapper


        XSSFWorkbook workbook = new XSSFWorkbook();//Create blank workbook
        XSSFSheet spreadsheet = workbook.createSheet( " Trivia");//Create a blank sheet

        int rowNum = 0;   // Create a Row

          for (int i = 0; i <48; i++) {
              Row row = spreadsheet.createRow(rowNum++);

              int cellindex = 0;
               row.createCell(1); //create heading
               row.createCell(cellindex++).setCellValue(list.get(i));
               row.createCell(2);
               row.createCell(cellindex++).setCellValue(list.get(i+1));

                i= i + 1;
           }

        try{
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(
                    new File("D:\\intelj\\trivia.xlsx"));

            workbook.write(out);
            out.close();
            System.out.println("Excel file is created");
        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

