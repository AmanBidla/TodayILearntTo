public class Compression{

	public static void main(String abd[]){
		String str="aabcccccaaa";
		String newstr="abcd";
		System.out.println(compress(str));
		System.out.println(compress(newstr));		
	}

	public static String compress(String str){

		if( lengthOfCompressedString(str)>str.length()) return str;

		StringBuffer buf = new StringBuffer();
		char [] content = str.toCharArray();
		char last= content[0];
		int count=0;
		for(int i=0;i<content.length;i++){
			if(content[i]==last){
				count++;
			}else{
				buf.append(last);
				buf.append(count);
				last=content[i];
				count=1;
			}
		}
		buf.append(last);
		buf.append(count);
		
		return buf.toString();

	}

	public static int lengthOfCompressedString(String str){
		char []content= str.toCharArray();
		int count=0;
		int size=0;
		char last= content[0];
		for(int i=0;i<content.length;i++){
			if(last==content[i]){
				count++;
			}else{
				size=size+2;
				count=1;
				last=content[i];
			}
		}
		size+=2;
		return size;
	}

}