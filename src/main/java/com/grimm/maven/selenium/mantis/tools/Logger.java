package com.grimm.maven.selenium.mantis.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public static String OutputFileName = getDateTimeByFormat(new Date(), "yyyyMMdd_HHmmss");
	private static OutputStreamWriter outputStreamWriter;
	private static String logFileName;
	public static boolean LogFlag = true;

	public Logger() {

	}

	public static void WriteLog(String logEntry) {
		try {
			logFileName = ".\\Log" + "\\" + OutputFileName + ".log";
			if (outputStreamWriter == null) {
				File logFile = new File(logFileName);
				if (!logFile.exists())
					logFile.createNewFile();
				outputStreamWriter = new OutputStreamWriter(new FileOutputStream(logFileName), "utf-8");
			}
		} catch (Exception e) {
			System.out.println(LogType.LogTypeName.ERROR.toString() + "：无法写入文件" + logFileName);
			e.printStackTrace();
		}
	}

	private static String getDateTimeByFormat(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
}