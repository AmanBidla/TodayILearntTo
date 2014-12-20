 
public class PatternMatching {

 
      private static int dp[][];
      public static void main(String[] args) {
        
        //String s="abab";
        //String p="abab";
        //String p="a*b";
        //String p="a**b";

//        String s="ababab";
//      String p="ab*b";

        //String s="";
        //String p="*";

         //String s="aaaaab";
         //String p="?*b";

        String s="ababab";
        String p="ab";


        dp = new int[s.length()][p.length()];

        for(int i=0;i<s.length();i++)
        {
          for(int j=0;j<p.length();j++)
          {
            dp[i][j]=-1;
          }
        }
        boolean result = isPatterMatch(0,0,s,p);
        System.out.println("result is "+dp[s.length()-1][p.length()-1]);
        System.out.println("result is "+result);
      } 


      public static boolean isPatterMatch(int i, int j,String s, String p){
            
            System.out.println("i :"+i+" s :"+s+" j :"+j+" p :"+p);
            if((i==s.length()) && (j==p.length())) 
            {
              //dp[i][j]=1;
              return true;
            }
              

            if((i==s.length()) || (j==p.length())){
              //dp[i][j]=0;
              return false;
            } 
            if(dp[i][j]!=-1){
              if(dp[i][j]==0) return false;
              else return true;
            }

            char pchar = p.charAt(j);
            char schar = s.charAt(i);
            
            System.out.println("pchar :"+pchar+" schar :"+schar);
            if((pchar!='*') && (pchar!='?')){

              if(pchar!=schar) {
                dp[i][j]=0;
                return false;
              }
              else {
                dp[i][j]=1;
                return isPatterMatch(i+1, j+1, s, p);
              }
            }

            if(pchar=='*'){

              boolean starresult = isPatterMatch(i+1,j+1,s,p) || isPatterMatch(i+1,j ,s,p);
              if(starresult) dp[i][j]=1;
              else dp[i][j]=0;

            }else if(pchar=='?'){

                boolean questionMarkresult = isPatterMatch(i+1,j+1,s,p);
                if(questionMarkresult)
                    dp[i][j]=1;
                else
                  dp[i][j]=0;
                
            }

            if(dp[i][j]==0) return false;
            else return true;


      }
    }
