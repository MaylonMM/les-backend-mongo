package br.edu.fatecso.les.lesbackend.resources.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static Date convertDate(String texDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(texDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
	
}
