package com.automationframework.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {
public static String getcurrentdatetime(){
	DateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd_hh-mm-ss");
	Calendar cal= Calendar.getInstance();
	String time=dateformat.format(cal);
	return time;
	}
public static String getcurrentdate(){
return getcurrentdatetime().substring(0, 10);
}
}
