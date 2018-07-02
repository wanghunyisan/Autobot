package com.grimm.maven.selenium.mantis.tools;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Tools {
	/**
	 * 获取当前日期
	 */
	public static String getCurrentDate() throws IOException {
		int y, m, d, h, mi, s;
		Calendar cal = Calendar.getInstance();
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH);
		d = cal.get(Calendar.DATE);
		h = cal.get(Calendar.HOUR);
		mi = cal.get(Calendar.MINUTE);
		s = cal.get(Calendar.SECOND);
		if ((m + 1) < 10)
			return y + "/0" + (m + 1) + "/" + d + " " + h + "-" + mi + "-" + s;
		else
			return y + "/" + (m + 1) + "/" + d + " " + h + "-" + mi + "-" + s;
	}

	/**
	 * 获取当前项目的绝对路径
	 */
	public static String getPath() {
		try {
			File directory = new File("");
			String courseFile = directory.getCanonicalPath();
			return courseFile;
		} catch (IOException e) {
			Log.error("没有获取到项目路径，请检查项目文件!");
			return null;
		}
	}
}
