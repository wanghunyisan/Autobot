package com.grimm.maven.selenium.mantis.tools;

import java.util.ArrayList;

public class Trace {
	
	public static ArrayList<String> getCaller(){
		StackTraceElement stack[]=(new Throwable()).getStackTrace();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<stack.length;i++) {
			 if(stack[i].getMethodName().equals("setLog")) {
				 list.add(stack[i+2].getClassName().toString());
				 list.add(stack[i+2].getMethodName().toString());
			 }
		}
		return list;
	}

	public static GetLogName getLogName(ArrayList<String> list) {
		return new GetLogName(list.get(0),list.get(1));
	}
}
