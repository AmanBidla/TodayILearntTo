public class DecodeMessage{

	static final int upperLimit  = 26;
static final int maxHeadSize = ("" + upperLimit).length();

 

int decode(char[] st) {
     char [] st= s.toCharArray();
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


public static void main(String[] args) {
	//System.out.println(numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
    System.out.println(numDecodings("10"));
}


}