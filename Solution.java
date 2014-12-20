import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    
    List<String> list = new ArrayList<String>();
    Map<String,String> cache = new HashMap<String,String>();
    
    public List<String> wordBreak(String s, Set<String>dict){
        
        if(dict.size()==0 || (s.length()==0) )
            return list;
        if(s.length()==1 && dict.contains(s)){
            list.add(s);
        }else{
                wordBreakHelper(s,dict);    
        }
         
        return list;
    }
    
    public String wordBreakHelper(String s, Set<String> dict) {
        
        if(dict.contains(s)){
            return s;
        }
            
        if(cache.containsKey(s))
            return cache.get(s);
        
        int N = s.length();
        for(int i=1;i<N;i++){
            String prefix = s.substring(0,i);
            if(dict.contains(prefix)){
                
                String suffix = s.substring(i,N);
                String segment = null;
                segment = wordBreakHelper(suffix,dict);
                if(segment!=null){
                    if(suffix.length() + prefix.length()==(N-1))
                        list.add(prefix+" "+segment);
                    return prefix+" "+segment;
                }
            }
        }
        cache.put(s,null);
        return null;
        
    }

    public static void main(String[] args) {
        String s="abcd";
         Set<String>dict  = new HashSet<String>();
         /*dict.add("a");
         dict.add("abd");
         dict.add("b");
         dict.add("cd");
         dict  = new HashSet<String>();*/
         dict.add("a");
         dict.add("b");
         s="ab";
             Solution sol= new Solution();
       List<String> output = sol.wordBreak(s,dict);
        for(String so:output){
            System.out.println(so);
        }

    }
}