import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
     public boolean wordBreak(String s, Set<String> dict) {
    
      if( (dict.size()==0)||(s.length()==0))
         return false;
       
      if(s.length()==1 && !dict.contains(s))
          return false;
       else if(s.length()==1 && dict.contains(s))
          return true;
          
      Set<Integer> cache = new HashSet<Integer>();
      return wordBreakHelper(s,0,dict,cache);
       
    }
    
    public boolean wordBreakHelper(String s, int i,Set<String> dict, Set<Integer> cache){
        
        if(dict.contains(s.substring(i)))
            return true;
        if(cache.contains(i))
            return false;
        
        for(int j=i;j<s.length();j++){
            if(dict.contains(s.substring(i,j+1))){
                if(wordBreakHelper(s,j+1,dict,cache)){
                    return true;
                }
            }    
        }
        
        cache.add(i);
        return false;
    }
     
    
}