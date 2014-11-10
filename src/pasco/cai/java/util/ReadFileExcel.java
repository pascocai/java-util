package pasco.cai.java.util;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadFileExcel extends ReadFile {

	public Workbook book = null;
	public Sheet sheet = null;
	public Cell cell = null;
	public WritableWorkbook wwb = null;
	public WritableSheet ws = null;
	
	public void openExcel(File file, int sheetNumber) {
		try {
			book = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetNumber);
	}
	
	public String getCell(int col, int row) {
		try {
			return sheet.getCell(col, row).getContents().toString().trim();
		} catch (Exception e) {
			return null;
		}
	}
}
