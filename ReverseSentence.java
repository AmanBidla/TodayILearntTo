public class ReverseSentence{


	public static void main(String abc[]){
		
		String sentence =" Hi, My name is sreeprasad";
		
		 //reverse(sentence.toCharArray());
		System.out.println(reverse());
		
	}


	public static void reverse(char[] sentence){
		
		char[] rev = new char[sentence.length];
		for(int i=0;i<sentence.length;i++){
			
			if(sentence[i]==' '){
				for(int start=0,j=i;j<sentence.length-i;j++,start++){
					rev[start]=sentence[j];
				}
			}
		}
		
		for(int i=0;i<rev.length;i++)
			System.out.print(rev[i]);
		
	}

	 

}