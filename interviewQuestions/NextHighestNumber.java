public class NextHighestNumber{
	

	public static long find(long number){
		String s = String.valueOf(number);
		int min=-1,minPos =-1;
		for(int i=1;i<s.length;i++){
			int right = Character.digit(s.charAt(i),10);
			int left = Character.digit(s.charAt(i-1),10);
		}
	}
}