public class ReverseWordsTwo {



	public static void reverseWords(char[] s) {
          
        int left=0, right=s.length-1;
        reverse(s,left,right);
        int start=0;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                reverse(s,start,i-1);
                start=i+1;
            }
        }
        reverse(s,start,s.length-1);
      
    }
    
    private static char[] reverse(char[]s, int left, int right) {
         while (left<right) {
            char c= s[left];
            s[left]=s[right];
            s[right]=c;
            left++; right--;
        }
        return s;
    }

    public static void main(String[] args) {
    	
    	char[] s = "the sky is blue".toCharArray();
    	reverseWords(s);
    	System.out.println(new String(s)); // should be: blue is sky the
    	assert(s.equals("blue is sky the"));

    }
}