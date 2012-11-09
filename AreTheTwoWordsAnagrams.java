public class AreTheTwoWordsAnagrams{

public boolean areAnagrams(String s1, String s2) {
    char[] ch1 = s1.toCharArray();
    char[] ch2 = s2.toCharArray();
    Arrays.sort(ch1);
    Arrays.sort(ch2);
    return Arrays.equals(ch1,ch2);
}



	public static void main(String abc[]){
	
		System.out.println(areAnagrams("tree","eret"));
	
	}

}