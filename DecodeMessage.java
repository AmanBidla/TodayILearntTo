public class DecodeMessage{

	static final int upperLimit  = 26;
static final int maxHeadSize = ("" + upperLimit).length();

 

static int decode(String S) {
     char [] st= S.toCharArray();
         int len = st.length;
         if(len==0)
            return 0;
          int i,  ways[] = { 1, 0 };
    for(i = 0 ; i < len; ++i) {
        int w = 0;
        if((i > 0) && ((st[i - 1] == '1') || (st[i - 1] == '2' && st[i] < '7'))) {
            w += ways[1];
        }
        if(st[i] > '0') {
            w += ways[0];
        }
        ways[1] = ways[0];
        ways[0] = w;
    }
    return ways[0];
}


  public static int total(String S){


    if(S==null || S.length() < 1) return 0;
    if(S.length()==1 && S.charAt(0)!='0' && S.charAt(0) <='9') return Integer.parseInt(S.substring(0,1));
    int N = S.length();
    int [] dp = new int[N+1];
    dp[0]=1;
    
    if(isValid(S.substring(0,1))){
      dp[1]=1;
    }else{
      dp[1]=0;
    }

    for(int i=2;i<=N;i++){

      if(isValid(S.substring(i-1,i))){
          dp[i]+=dp[i-1];
      }

      if(isValid(S.substring(i-2,i))){
        dp[i]+=dp[i-2];
      }
    }

    return dp[N];

  }

  public static boolean isValid(String S){

    if(S==null) return false;
    if(S.charAt(0)=='0') return false;
    int code = Integer.parseInt(S);
    return code>=1 && code<=26;
  }


public static void main(String[] args) {
	//System.out.println(numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
  String S="4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
    System.out.println(decode(S));
    System.out.println(total(S));
}


}