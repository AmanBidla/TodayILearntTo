package com.race.average;

import java.util.Arrays;

public class RaceAverage {

	public static void test() {
		String[] times = { "12:00 PM, DAY 1", "12:01 PM, DAY 1" };
		String[] timesTwo = { "12:00 AM, DAY 2" };
		String[] timesThree = { "02:00 PM, DAY 19", "02:00 PM, DAY 20",
				"01:58 PM, DAY 20" };
		System.out.println("test one : "+Arrays.toString(times));
		avgMinutes(times);
		System.out.println("test one : "+Arrays.toString(timesTwo));
		avgMinutes(timesTwo);
		System.out.println("test one : "+Arrays.toString(timesThree));
		avgMinutes(timesThree);
	}

	public static double avgMinutes(String[] times) {

		/* total number */
		int totalTimes = times.length;
		double total = 0;
		int hh, mm, day;
		char a;
		
		/* initialize start */
		int start = 60 * 8;
		
		
		for (int i = 0; i < totalTimes; i++) {
			
			String timePart = times[i].split(",")[0];
			
			int indexOfColen = timePart.indexOf(':');

			hh = getHH(timePart, indexOfColen);

			mm = getMM(timePart, indexOfColen);

			day = dayPart(times, i);
			
			String ampm = timePart.substring(timePart.length() - 2);

			a = ampm.charAt(0);
			
			if (a == 'P' && hh < 12)
				hh += 12;
			
			if (a == 'A' && hh == 12)
				hh = 0;
			
			/* total finish */
			int finish = hh * 60 + mm + (day - 1) * 60 * 24;
			
			total += finish - start;

		}
		
		/* get average */
		total = Math.floor((total / totalTimes) + 0.5);
		
		System.out.println("total " + total);
		
		return total;

	}

	private static int dayPart(String[] times, int i) {
		int day;
		String dayPart = times[i].split(",")[1];
		day = Integer.parseInt(dayPart.substring(5));
		return day;
	}

	private static int getMM(String timePart, int indexOfColen) {
		int mm;
		String mmm = timePart.substring(indexOfColen + 1, indexOfColen + 3);
		if (mmm.equals("00"))
			mm = 0;
		else
			mm = Integer.parseInt(mmm);
		return mm;
	}

	private static int getHH(String timePart, int indexOfColen) {
		int hh;
		String hhh = timePart.substring(0, indexOfColen);
		if (hhh.equals("00"))
			hh = 0;
		else
			hh = Integer.parseInt(hhh);
		return hh;
	}

	public static void main(String[] args) {
		test();

		String[] times = new String[args.length];
		if (times.length > 0) {
			for (int i = 0; i < times.length; i++) {
				times[i] = args[0];
			}
			double total = avgMinutes(times);
			System.out.println(" total average is " + total);
		}

	}
}
