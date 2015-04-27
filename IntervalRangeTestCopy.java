import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

enum Month{
	JAN(1),FEB(2),MAR(3),APR(4),MAY(5),JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),NOV(11),DEC(12);
	private int val;
	private Month(int val){
		this.val=val;
	}

	public int val(){
		return this.val;
	}
}

public class IntervalRangeTestCopy {

	private static final String DELIMITER =";\\s";
	private static final int START_YEAR_BEGIN =4;
	private static final int START_YEAR_END =8;
 	private static final int END_YEAR_BEGIN =13;
	private static final int END_YEAR_END =17;

	private static final int START_MONTH_BEGIN =0;
	private static final int START_MONTH_END =3;
 	private static final int END_MONTH_BEGIN =9;
	private static final int END_MONTH_END =12;

	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] data;
		Interval [] periods;
		int workXp, minStart, maxEnd;

 		
		while ((line = in.readLine()) != null) {

			data = line.split(DELIMITER);
			int N = data.length;
			workXp = 0;
			periods = new Interval [N];
			
			
			for (int i = 0; i < data.length; i++) {
				//System.out.println(" data[i].substring(4, 8) "+(data[i].substring(4, 8))+" data[i].substring(13, 17) "+(data[i].substring(13, 17)));
				String startYear = data[i].substring(START_YEAR_BEGIN, START_YEAR_END);
				String endYear = data[i].substring(END_YEAR_BEGIN, END_YEAR_END);
				String startMonth = data[i].substring(START_MONTH_BEGIN, START_MONTH_END);
				String endMonth = data[i].substring(END_MONTH_BEGIN, END_MONTH_END);
				//System.out.println( Month.valueOf(startMonth.toUpperCase()).val());

				int start = Integer.parseInt(startYear) * 12 + Month.valueOf(startMonth.toUpperCase()).val();
				int end = Integer.parseInt(endYear) * 12 + Month.valueOf(endMonth.toUpperCase()).val();
				periods[i] = new Interval ( start, end );
						
			}
			
			minStart = minStart(periods);
			maxEnd = maxEnd(periods);
			
			//If a month is within one of the work periods, add to workxp
			for (int i = minStart; i <= maxEnd; i++) {
				if (isWithinPeriod(i, periods)) workXp++;
			}
			
			System.out.println(workXp / 12);
		}
		
		in.close();
	}
	
	static boolean isWithinPeriod(int x, Interval [] p) {
		for (int i = 0; i < p.length; i++) {
			if (p[i].isWithinRange(x)) return true;
		}
		return false;
	}
	
	static int minStart(Interval [] p) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < p.length; i++) {
			if (p[i].getStartDate() < min) {
				min = p[i].getStartDate();
			}
		}
		return min;
	}
	
	static int maxEnd(Interval [] p) {
		int max = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i].getEndDate() > max) {
				max = p[i].getEndDate();
			}
		}
		return max;
	}
}

class Interval  {
	private int startDate, endDate;
	
	public Interval (int startDate, int endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getStartDate() {
		return startDate;
	}

	public int getEndDate() {
		return endDate;
	}
	
	public boolean isWithinRange(int i) {
		return (i >= startDate && i <= endDate);
	}
}