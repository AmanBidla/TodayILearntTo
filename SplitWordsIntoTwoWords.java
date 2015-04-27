import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class SplitWordsIntoTwoWords{

	 Map<String, String> cache=new HashMap<String,String>();


	Map<String, String> memoized =new HashMap<String,String>();

	 public String SegmentString(String input, Set<String> dict) {
 	//System.out.println("sentence is "+input);
     	if (dict.contains(input))
           return input;

       if (memoized.containsKey(input)) {
          return memoized.get(input);
     	}

       int len = input.length();
 		for (int i = 1; i < len; i++) {
          String prefix = input.substring(0, i);
          if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = SegmentString(suffix, dict);
               // System.out.println(prefix+"  "+suffix+" segment > "+segSuffix);
             	if (segSuffix != null) {
 				    memoized.put(input, prefix + " " + segSuffix);
 	            	System.out.println(prefix+"  "+segSuffix);
                    return prefix + " " + segSuffix;
                }
           }
 
       }
       memoized.put(input, null);
      return null;
    }
 
	public static void main(String[] args) {
		
		//cache = new HashMap<String,String>();
	    Set<String> dict = new HashSet<String>();
	    
	    dict.add("cat");
	    dict.add("cats");
	    dict.add("and");
	    dict.add("sand");
	    dict.add("dog");

	    String sentence ="catsanddog";

	    sentence ="therearesomewordshiddenhere";
	    String[] dictionary =
  { "the", "a", "i", "here", "so", "hid", "there", "are", "some", "word",
    "words", "hid", "hi", "hidden", "he", "here", "her", "rear",
    "me", "den" };
    dict = new HashSet<String>();
    for(int i=0;i<dictionary.length;i++){
    	dict.add(dictionary[i]);
    }
		dict = new HashSet<String>();
		dict.add("this");
		dict.add("is");
		dict.add("a");
		dict.add("test");

		sentence="thisisatest";

		SplitWordsIntoTwoWords s = new SplitWordsIntoTwoWords();
		//s.splitWords(sentence,dict);
	    //s.SegmentString(sentence,dict);
		dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		sentence="ab";;
	     
	     //s.SegmentString(sentence,dict);
	     dict = new HashSet<String>();
		 
		dict.add("b");
		sentence="a";;
	    //String answer =s.SegmentString(sentence,dict);

	    sentence="aaaaaaa";
	    dict = new HashSet<String>();
	    dict.add("aaaa");
	    dict.add("aa");
		//String answer =s.SegmentString(sentence,dict);	

		sentence="abcd";
		dict = new HashSet<String>();
	    dict.add("a");
	    dict.add("b");
	    dict.add("abc");
	    dict.add("cd");
	    //dict.add("b");
	    //for(int i=0;i<sentence.length();i++)
			//s.SegmentString(sentence.substring(i),dict);

	    String S="catsanddog";
	    dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		s.SegmentString(S,dict)


	}

}