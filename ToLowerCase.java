/*Print continuous alphabets from a sequence of arbitrary alphabets
For example:
Input: abcdefljdflsjflmnopflsjflasjftuvwxyz
Output: abcdef; mnop; tuvwxyz

Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
Output: abcdef; mnop; tuvwxyz

*/

public class ToLowerCase{

	public static void main(String []abc){
		String a="1abcdefljdflsjflmnopflsjflasjftuvwxyz22";
		StringBuffer st = new StringBuffer();
		System.out.println(a.toLowerCase());
		int count=0;
		a=a.toLowerCase();
		boolean addsemi=false;
		char []b= a.toCharArray();
		for(int i=1;i<a.length();i++){
//			System.out.println((((int)(b[i]))));
			if((((int)(b[i]))>=97) && ((((int)(b[i]))<=121))){
//				System.out.println("starting from "+b[i]);
				if((i+1)<b.length){
//					System.out.println("\n"+(((int)b[i+1])-((int)b[i])==1)+"\n");
					if(((int)b[i+1])-((int)b[i])==1){
//						st=st.append(b[i]+""+b[i+1]);
						System.out.print(b[i]+"");
					}else{
						if(((int)b[i])-((int)b[i-1])==1){
						System.out.print(b[i]+";");							
						}
					} 
				}
			}
		}
		//System.out.println(st.toString());
		System.out.println(";");
	}


}