package com.os.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeUtil {
	
	private static Logger LOG = LoggerFactory.getLogger(TimeUtil.class);

	public static long now(){
		return System.currentTimeMillis();
	}
	
	public static String format(long timestamp){
		return format(timestamp, "yyyy-MM-dd HH:mm:ss.SSS");		
	}
	
	public static String format(long timestamp, String formatString){
		SimpleDateFormat sdf= new SimpleDateFormat(formatString);
		Date dt = new Date(timestamp); 
		return sdf.format(dt);		
	}
	
	public static Date parse(String dateString){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			LOG.error("", e);
		}
		return null;
	}
}
