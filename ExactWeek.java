/*
get a date(mon/day/year) from user. Print exact the week of dates(Sun to Sat)
ex) input: 2/20/2001 if the day is Wednesday
output: Sunday 2/17/2001
Monday 2/18/2001
Tuesday 2/19/2001
Wednesday 2/20/2001
Thursday 2/21/2001
Friday 2/22/2001
Saturday 2/23/2002

*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
public class ExactWeek{

	public static void main(String arg[]){
		
		Date date = new Date(Integer.parseInt(arg[0].substring(4,8))-1900,Integer.parseInt(arg[0].substring(0,2))-1,Integer.parseInt(arg[0].substring(2,4)));
		
		String []months={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		

		Calendar xmas;
 		
		switch(Integer.parseInt(arg[0].substring(0,2))){
			case(1):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.JANUARY, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(2):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.FEBRUARY, Integer.parseInt(arg[0].substring(2,4)));; 			
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
							break;
			case(3):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.MARCH, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(4):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.APRIL, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;			
			case(5):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.MAY, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(6):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.JUNE, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(7):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.JULY,      Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(8):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.AUGUST, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(9):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.SEPTEMBER, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;		
			case(10):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.OCTOBER, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(11):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.NOVEMBER, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;
			case(12):   xmas = new GregorianCalendar(Integer.parseInt(arg[0].substring(4,8)), Calendar.DECEMBER, Integer.parseInt(arg[0].substring(2,4)));; 
						System.out.println(xmas.get(Calendar.DAY_OF_WEEK));
						break;

			default :System.out.println("No such day!");;	
		}
		
		
	}


}