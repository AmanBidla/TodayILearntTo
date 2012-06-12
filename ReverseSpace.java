public class ReverseSpace{


	public static void main(String abc[]){
		String s="hello from Microsoft";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String words){
	
		int k=words.indexOf(" ");
		return (k==-1)?words:(reverse(words.substring(k+1)) + " "+words.substring(0,k)  );
		
	}
			
 
	}
