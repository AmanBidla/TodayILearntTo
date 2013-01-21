public class ReverseRecursively{

	public static void main(String abc[]){
	
	 String abc="Hello World";
	 System.out.println(reverseString(abc));
	
	}
}
public String reverseString(String s){
    if (s.length() == 0) 
         return s;

    return reverseString(s.substring(1)) + s.charAt(0);
}