package com.oracle.course.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
		return date;
	}

}
