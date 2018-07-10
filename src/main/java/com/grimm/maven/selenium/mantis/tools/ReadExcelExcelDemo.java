package com.grimm.maven.selenium.mantis.tools;

public class ReadExcelExcelDemo {

	public static void main(String[] args) throws Exception {
		String excelReadPath = "data/TestPlan.xlsx";
		String excelWritePath = "data/TestPlan.xlsx";

		ReadWriteExcel g = new ReadWriteExcel();
		g.xlRead(excelReadPath, 0);

		for (int i = 0; i < g.xRows; i++) {
			for (int j = 0; j < g.xCols; j++) {
				System.out.println("\t" + g.xData[i][j]);
			}
			System.out.println("");
		}

		g.xData[1][0] = "何叶";
		g.xData[2][0] = "郝凌";

		g.xlwrite(excelWritePath, g.xData);

		System.out.println("Done");
	}

}
