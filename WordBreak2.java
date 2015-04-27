import java.util.*;
public class WordBreak2{

	public static void main(String[] args) {
		
		String S = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> list = wordBreak(S,dict);
		for(String w:list){
			System.out.println(w);
		}
	}

	public static List<String> wordBreak(String s,Set<String> dict) {  

     	List<String> result= new ArrayList<String>();  
     	// DFS  
     	dfs(s, s.length(), dict, new Stack<String>(), result);  
    	 return result;  
    }  
   private static void dfs(String s, int index, Set<String> dict, Stack<String> path, List<String> rslt){  
     // base case  
     if(index == 0){  
       List<String> list = new ArrayList<String>();  
       StringBuilder str= new StringBuilder();  
       list.addAll(path);  
       for(int i = list.size()-1;i>=0;i--){  
         str.append(list.get(i));  
         if(i!=0) str.append(" ");  
       }  
       rslt.add(str.toString());  
     }  
     // recursion  
     int i = index-1;  
     while(i >= 0){  
       String t = s.substring(i,index);  
       if(dict.contains(t)){  
         path.push(t);  
         dfs(s, i, dict, path, rslt);  
         path.pop();  
       }  
       i--;  
     }  
     return;  
   }  


}