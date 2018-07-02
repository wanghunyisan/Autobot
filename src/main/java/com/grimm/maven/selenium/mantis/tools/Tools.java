package com.grimm.maven.selenium.mantis.tools;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Tools {
	/**
	 * ��ȡ��ǰ����
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
	 * ��ȡ��ǰ��Ŀ�ľ���·��
	 */
	public static String getPath() {
		try {
			File directory = new File("");
			String courseFile = directory.getCanonicalPath();
			return courseFile;
		} catch (IOException e) {
			Log.error("û�л�ȡ����Ŀ·����������Ŀ�ļ�!");
			return null;
		}
	}
}
