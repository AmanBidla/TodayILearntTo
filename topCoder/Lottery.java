public class Lottery {
    public String[] sortByOdds(String[] rules) {

    	
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			LotteryHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LotteryHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class LotteryHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(String[] expected, String[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (!expected[i].equals(result[i])) return false; return true; }

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, String[] expected, String[] received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			String[] rules            = {"PICK ANY TWO: 10 2 F F"
,"PICK TWO IN ORDER: 10 2 T F"
,"PICK TWO DIFFERENT: 10 2 F T"
,"PICK TWO LIMITED: 10 2 T T"};
			String[] expected__       = { "PICK TWO LIMITED",  "PICK TWO IN ORDER",  "PICK TWO DIFFERENT",  "PICK ANY TWO" };

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}
		case 1: {
			String[] rules            = {"INDIGO: 93 8 T F",
 "ORANGE: 29 8 F T",
 "VIOLET: 76 6 F F",
 "BLUE: 100 8 T T",
 "RED: 99 8 T T",
 "GREEN: 78 6 F T",
 "YELLOW: 75 6 F F"}
;
			String[] expected__       = { "RED",  "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "INDIGO",  "VIOLET" };

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}
		case 2: {
			String[] rules            = {};
			String[] expected__       = { };

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}

		// custom cases

/*      case 3: {
			String[] rules            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}*/
/*      case 4: {
			String[] rules            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}*/
/*      case 5: {
			String[] rules            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Lottery().sortByOdds(rules));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
