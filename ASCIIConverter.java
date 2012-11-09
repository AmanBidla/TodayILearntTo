public class ASCIIConverter{


	public static void main(String abc[]){
		String a="abcdefg";
		for(int i=0;i<a.length();i++){
			char c = a.charAt(i);
			int j =(int)c;
			System.out.print(j+" ");
		}
		System.out.println("");
		 
	}

}