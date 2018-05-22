package ru.isa.catalogiser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



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
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
    }

}
