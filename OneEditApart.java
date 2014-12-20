public class OneEditApart{

	private static boolean edit(String A, String B){

		String small = (A.length()<=B.length())?A:B;
		String large = (A.length()<=B.length())?B:A;

		int op=0;
		
		if(large.length()-small.length() >1)
			return false;

		else if(large.length()==small.length()){
 			for(int i=0;i<small.length();i++){
 				if(large.charAt(i)!=small.charAt(i) && ++op>1)
					return false;
			}
		}else{

			int i=0;
			while(i<small.length()){

				if(large.charAt(i)!=small.charAt(i+op)){
					if(++op>1)
						return false;
				}else{
					i++;
				}
			}			
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 ="cat";
		String s2="dog";
		System.out.println(edit(s1,s2));
		  s1 ="cat";
		  s2="cats";
		System.out.println(edit(s1,s2));

	}

}