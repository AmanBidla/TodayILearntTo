import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder{

 public static int shortest(String start, String end, Set<String> dict){
 	System.out.println("start "+start+" end "+end);
	if( start==null || end==null || dict==null){
            return 0;
        }
        if( dict.size()==0 || start.equals(end) ){
            return 0;
        } 
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> valueQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        valueQueue.add(1);
        while(!wordQueue.isEmpty()){
            String word = wordQueue.pop();
            System.out.println("adding word "+word);
            Integer value = valueQueue.pop();
            System.out.println("word is "+word+" and value is "+value);
            if(word.equals(end)){
                return value;
            }
            for(int i=0;i<word.length();i++){
                char [] array =  word.toCharArray();
                for(char c='a';c<='z';c++){
                    array[i]=c;
                    String newWord = new String(array);
                    if(dict.contains(newWord)){                        
                        wordQueue.add(newWord);
                        valueQueue.add(value+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static Set<String> addWord(Set<String> dict){
    	/*
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	dict.add("cog"); */

        dict.add("cat");dict.add("bat");dict.add("hat");dict.add("bad");dict.add("had");


    	return dict;
    }



    public static void main(String[] args) {
    	
    	/*String start ="hit";
    	String end ="cog"; */
        String start ="bat";
        String end="had";
    	Set<String> dict = new HashSet<String>();
    	dict = addWord(dict);
    	System.out.println("dict.size() "+dict.size());
    	System.out.println(shortest(start,end,dict));

    }

}