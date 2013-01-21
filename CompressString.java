/* convert aaabbcccaa to a3b2c3a2 and if after such compression length is > original string
return original string */
public class CompressString {

	public static void main(String abc[]){
		
//		String st= "aaabbcccaammmmmdddee";
		String st="aaabbcccaa";
		System.out.println(compress(st));
	}


	public static String compress(String st){
		int N = st.length();
		int S = CompressSize(st);
		int count=1,index=0;
		char[] array = new char[S];
		char last = st.charAt(0);
		for(int i=1;i<N;i++){
			if(last==st.charAt(i)) count++;
			else{
				index=setChar(index,array,count,last);
				last=st.charAt(i);
				count=1;
			}
		}
		index=setChar(index,array,count,last);
		return String.valueOf(array);
	}

	public static int CompressSize(String st){
		int count=1,size=0,N=st.length();
		char last= st.charAt(0);
		for(int i=1;i<N;i++){
			if(last==st.charAt(i)) count++;
			else{
//				size+=1+String.valueOf(count).length();
				size+=count;
				last=st.charAt(i);
				count=1;
			}
		}
		
		return size+=count;
		
	}
	
	public static int setChar(int index, char[]array,int count,char last){
		array[index]=last;
		index++;
		char [] number = String.valueOf(count).toCharArray();
		for(char x:number){
			array[index]=x;
			index++;
		}
		return index;
	}
}