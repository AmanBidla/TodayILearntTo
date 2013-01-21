public class LearnLongestCommonSubsequence{
	
	public static String LCS1(String a, String b){
		
		int lena =a.length();
		int lenb =b.length();
		String x,y;
		
		if((lena==0)|| (lenb==0)) return "";
		else if (a.charAt(lena-1)==b.charAt(lenb-1)) 
			return LCS1(a.substring(0,lena-1),b.substring(0,lenb-1))+a.charAt(lena-1);
		else{
			x=LCS1(a,b.substring(0,lenb-1));
			y=LCS1(a.substring(0,lena-1),b);
		}
		if(x.length()>y.length()) return x; 
		else return y;
		
	}
	
	public static void main(String ab[]){
		
		    String a="computer";
			//String a="1224533324";
 			String b="houseboat";

			System.out.println(LCS1(a,b));

		
	}



}