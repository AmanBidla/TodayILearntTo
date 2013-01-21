public class ReverseSpaceIteratively{


	public static void main(String abc[]){
		String s="hello from Microsoft";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String words){
	
	if((words==null) || (words.isEmpty()) || (!words.contains(" ")))
		return words;
	else{
		String reverse="";
		for(String word:words.split(" ")){
			reverse=word+" "+reverse;
		}
		return reverse;
	}
 		
	}
			 
	}
