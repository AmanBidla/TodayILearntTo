public class FirstNonRepeatedCharacter{


	public static void main(String[] args) {
		
		String S ="aabccd";
		System.out.println( first(S));
	}


	public static char first(String S){

		int [] map = new int[256];
		char [] array = S.toCharArray();
		for(int i=0;i<array.length;i++){

			 map[(int)array[i]]++;
		}

		Character  c=null;
		for(int i=0;i<array.length;i++){

			 if(map[(int)array[i]]==1) {
			 	c= array[i];
			 	break;
			 }
		}

		return c;
	}
}