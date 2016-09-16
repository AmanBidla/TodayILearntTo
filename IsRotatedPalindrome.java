public class IsRotatedPalindrome {

	public static void main(String[] args) {
		

		String S="aab";
		System.out.println(isRotatedPalindrome(S));
	}
	public static boolean isRotatedPalindrome(String S){
        
        if(isPalidrome(S.toCharArray())) return true;
 
     
        for(int i=0;i<S.length();i++){
           
            String left=S.substring(0,i);
            String right = S.substring(i);
            char []array = (left+right).toCharArray();
            if(isPalidrome(array)) return true;
     
            
        }
        
        return false;
          
    }
     
    
    public static boolean isPalidrome(char []array){
        int start=0,end=array.length-1;
        while(start<=end){
            if(array[start] != array[end]) return false;
            start++; end--;
        }
        return true;
    }
}