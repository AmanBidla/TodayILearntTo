import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class WordBreak {

     public static boolean wordBreak(String s, Set<String> dict) {
    
      boolean[] dp = new boolean[s.length()];
      for(int i=0; i<s.length(); i++){
          for(int j=i; j>=0; j--){               
              if(dict.contains(s.substring(j,i+1)) && (j == 0 || dp[j-1])){
                  dp[i] = true;
                  break;
              }
          }
      }
           
      return dp[s.length()-1];
       
    }

     
    
    public static void main(String[] args) {
    
      String S ="leetcode";  
      Set<String> dict = new HashSet<String>();
      dict.add("leet");
      dict.add("code");
       

      System.out.println(S);
      System.out.println(wordBreak(S,dict));

    }    
     
    
}