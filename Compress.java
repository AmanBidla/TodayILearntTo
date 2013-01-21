public class Compress{


public static void main(String abc[]){
	
	String ab="aaabbbcc";
	Compress c = new Compress();
	System.out.println(c.compressMe(ab));
	
}

public String compressMe(String s){
	 
	/*int compressLength = compressLength(s);
	System.out.println(compressLength);
	if(compressLength>s.length())
		return s;
		*/
	
	StringBuffer s1 = new StringBuffer();
	char last= s.charAt(0);
	int count=1;
	for(int i=1;i<s.length();i++){
		if(last==s.charAt(i))
			count++;
		else{
			s1.append(last);
			s1.append(count);
			count=1;
			last=s.charAt(i);
		}
		
	}
	s1.append(last);
	s1.append(count);
 	System.out.println(s1.length());
	if(s1.length()<s.length())
		return s1.toString();
	else
		return s;
	
}

public int compressLength(String s){
	int count=1;
	int size=0;
	char last= s.charAt(0);
	for(int i=1;i<s.length();i++){
		if(last==s.charAt(i))
			count++;
		else{
			size=size+1+String.valueOf(count).length();
			System.out.println(String.valueOf(count));
//			System.out.println("count : "+ count+" size : "+size);
			count=1;
			last=s.charAt(i);
		}
		
	}
	size=size+1+String.valueOf(count).length();
//	System.out.println("count : "+count+" size : "+size);
	return size;
	
	
	
}


}