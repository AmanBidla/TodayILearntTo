/* Replace space with '%20' */

public class ReplaceSpaceWith{


	public static void main(String abc[]){
		
		String st ="there is 3 spaces"; //16+9=25
		char [] stArray = st.toCharArray();
		String copy= st;
 
		System.out.println(st.replace(" ","%20"));
		/*System.out.println("length before  before "+stArray.length);
		st=st.replace(" ","%20");
		System.out.println(st);
		int length=st.length();
		System.out.println("length before  "+length);*/
		char[] toChange = new char[25];
		for(int i=0;i<stArray.length;i++)
			toChange[i]=stArray[i];
		/* easy method */
		//replaceSpaceEasyMethod(st);
		replaceSpaceDiffiMethod(toChange,st.length());

	}
	
	public static void replaceSpaceEasyMethod(String st){
		st=st.replace(" ","%20");
		System.out.println(st);
	}
	
	public static void replaceSpaceDiffiMethod(char[] charArray,int length){
	
		/*System.out.println("length now "+charArray.length);
 		System.out.println("inside replaceSpaceDiffiMethod");*/
		int newLength=0,spaceCount=0,i=0;
		for(i=0;i<length;i++)
			if(charArray[i]==' ') 
				spaceCount++;
		
		newLength= length + 2 *spaceCount;
		charArray[newLength]='\0';
		for( i=length-1;i>=0;i--){
			if(charArray[i]==' '){
				charArray[newLength-1]='0';
				charArray[newLength-2]='2';
				charArray[newLength-3]='%';
				newLength=newLength-3;
			}else{
				charArray[newLength-1]=charArray[i];
				newLength=newLength-1;
			}
		}
		
		for( i=0;i<charArray.length;i++)
			System.out.print(charArray[i]);
			System.out.println("");
	}

}