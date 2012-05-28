public class FindLengthOfLongestNonRepeatedSubstring{


	public static int lengthofnonrepeatedsubstring(String s){
		
		int n=s.length();
		int i=0,j=0,max=0;
		boolean temp[]=new boolean[256];
		while(j<n){
			if(temp[s.charAt(j)]){
				max=Math.max(max,j-i);
				while(s.charAt(i)!=s.charAt(j)){
					temp[s.charAt(i)]=false;
					i++;
				}
				i++;
				j++;
			}else{
				temp[s.charAt(j)]=true;
				j++;
			}
		}
		max=Math.max(max,n-j);
		return max;
	}
	
	
	public static void main(String ab[]){
		String s="abcefgahabd";
		System.out.println(lengthofnonrepeatedsubstring(s));
	}

}