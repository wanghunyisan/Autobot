package com.grimm.maven.selenium.mantis.tools;

public class ReadExcelExcelDemo {

	public static void main(String[] args) throws Exception {
		String excelReadPath = "data/TestPlan.xlsx";
		String excelWritePath = "data/TestPlan.xlsx";

		ReadWriteExcel rwe = new ReadWriteExcel();
		rwe.xlRead(excelReadPath, 0);

		for (int i = 0; i < rwe.xRows; i++) {
			for (int j = 0; j < rwe.xCols; j++) {
				System.out.println("\t" + rwe.xData[i][j]);
			}
			System.out.println("");
		}

		rwe.xData[1][0] = "row1";
		rwe.xData[2][0] = "row2";

		rwe.xlwrite(excelWritePath, rwe.xData);

		System.out.println("Done");
	}

}
