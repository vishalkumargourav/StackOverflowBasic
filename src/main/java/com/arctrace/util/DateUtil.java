package com.arctrace.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
	public Timestamp getSqlDate(Date date){
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		System.out.println(timestamp);
		return timestamp;
	}
}
