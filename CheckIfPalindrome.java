public class CheckIfPalindrome{

public static void main(String abc[]){

String word="malayalam";
int i1=0,i2=word.length()-1;
while(i2>i1){
	if(word.charAt(i2)!=word.charAt(i1)) System.out.println("not palindrome");
	else{
		i2--;
		i1++;
	}
}
System.out.println("is a palindrome");
}


}