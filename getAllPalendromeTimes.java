import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.text.DateFormat;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

import java.util.Date;

public class getAllPalendromeTimes{


 	public static void main(String arg[]){
	
	Date startDate = new Date(Integer.parseInt(arg[0].substring(4,8))-1900,Integer.parseInt(arg[0].substring(0,2))-1,Integer.parseInt(arg[0].substring(2,4)));
	Date endDate = new Date(Integer.parseInt(arg[1].substring(4,8))-1900,Integer.parseInt(arg[1].substring(0,2))-1,Integer.parseInt(arg[1].substring(2,4)));	
	
	Set<Date> dates= pallendrome(startDate,endDate);
	Iterator it = dates.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	
	}
	
	
	public static Set<Date> pallendrome(Date start, Date end){
		
	SortedSet <Date> dates = new TreeSet<Date>();
	DateFormat df = new SimpleDateFormat("MMddyyyy");
	Calendar startDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();		
	startDate.setTime(start);
	endDate.setTime(end);
	
	while(startDate.compareTo(endDate)<=0){
		StringBuffer current = new StringBuffer (df.format(startDate.getTime()));
		String front = current.substring(0,4);
		String back = new StringBuffer(current.substring(4,8)).reverse().toString();
		if(front.equals(back)) dates.add(startDate.getTime());
		startDate.add(Calendar.DATE,1);
	}
	return dates;s
	}

}