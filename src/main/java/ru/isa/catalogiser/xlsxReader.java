package ru.isa.catalogiser;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class xlsxReader {
    File xlsxFile = null;
    FileInputStream fis = null;
    XSSFWorkbook workbook = null;
    public xlsxReader(File xlsxFile) {
        this.xlsxFile = xlsxFile;
        try {
            this.fis = new FileInputStream(this.xlsxFile);
        } catch (FileNotFoundException e) {
            //TODO: Errors method for all errors(customised)
            e.printStackTrace();
        }
    }

    void tmp(){
        // Finds the workbook instance for XLSX file
        try {
            XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
