package com.text.blocking;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlocking {

	private static String regex = "[a-z]+";
	private static StringBuilder[] NORESULT;

	private static StringBuilder[] blocking(StringBuilder[] text) {

		StringBuilder[] st;

		if (validate(text)) {

			StringBuilder[] words = text;
			int wordLength = words[0].length();
			st = new StringBuilder[wordLength];
			/* initalize */
			for (int i = 0; i < wordLength; i++) {
				st[i] = new StringBuilder("");
			}
			/* construct the block */
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < wordLength; j++) {
					st[j].append(words[i].charAt(j));
				}
			}

			return st;

		} else {
			return NORESULT;
		}

	}

	public static void main(String[] args) {
		StringBuilder[] buf = new StringBuilder[args.length];
		for (int i = 0; i < args.length; i++) {
			buf[i] = new StringBuilder(args[i]);
		}
		StringBuilder[] ouput = blocking(buf);
		for (int i = 0; i < ouput.length; i++) {
			System.out.println(ouput[i]);
		}
		
		testCases();

	}
	
	public static void testCases(){
		
		/*test cases one */
		StringBuilder [] test1 = new StringBuilder[3];
		test1[0]= new StringBuilder("AAA");
		test1[1]= new StringBuilder("BBB");
		test1[2]= new StringBuilder("CCC");
		StringBuilder [] test2 = new StringBuilder[1];
		
		
		StringBuilder [] output = blocking(test1);
		assert(output[0].equals("ABC"));
		assert(output[1].equals("ABC"));
		assert(output[2].equals("ABC"));
		
		
		/*test cases two*/
		test2[0]= new StringBuilder("AAAAA");
		output = blocking(test2);
		assert(output[0].length()==test2[0].length());
		
	}

	private static boolean validate(StringBuilder[] text) {

		/* text will contain between 1 and 50 elements, inclusive */
		StringBuilder[] words = text;
		int N = words.length;
		int wordLength = words[0].length();
		if (N < 1 || N > 50)
			return false;

		/*
		 * Each element of text will contain between 1 and 50 characters,
		 * inclusive.
		 */
		/* Each element of text will contain the same number of characters. */
		/* Each character in text will be an uppercase letter ([A-Z]). */

		for (StringBuilder word : words) {
			if (word.length() < 1 || word.length() > 50)
				return false;
			Pattern pat = Pattern.compile(regex);
			Matcher mat = pat.matcher(word);
			if (mat.matches())
				return false;

			if (word.length() != wordLength)
				return false;
		}

		return true;

	}

}
