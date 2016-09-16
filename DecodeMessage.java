public class DecodeMessage{
  
   

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
  }

  private static int decode(String S){

    if(S==null || S.length()==0){
      return 0;
    }

    int N = S.length();

    if (N==1) {
      return S.charAt(0)>='1' && S.charAt(0)<='9' ? 1 :0;
    }

    int result=0,a=0,b=0;

    if (S.charAt(0)>='1' && S.charAt(0)<='9') {
       a=1; b=1;
    }

    for(int i=1;i<N;i++){
      result=0;
      if(S.charAt(i)>='1' && S.charAt(i)<='9'){
        result+=a;
      }
      int prevNum = S.charAt(i-1)-'0';
      int currNum = S.charAt(i)-'0';
      int val = (prevNum*10)+currNum;
      if(val>=10 && val<=26){
        result+=b;
      }
      b=a;
      a=result;
    }

    return result;
  }


}