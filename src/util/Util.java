package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static SimpleDateFormat sdfDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date toDate(String date){
		try {
			return sdfDDMMYYYY.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
