public class StringToInteger {



public static void main(String abd[]){
	
	convertToInteger("123.35");
	
}


public static void convertToInteger(String s){
	
	int n=0,length=0;
	double m=0;
	
	boolean flag=false, decimal=false;
	
	if(s.contains(".")) {length= s.indexOf("."); decimal=true;}else length=s.length();
 	System.out.println("length is "+length);
	if(s.charAt(0)==-1) flag=true;	
	for(int i=0;i<s.length();i++){

		if(s.charAt(i)=='.') break;
 
		n +=(((int) s.charAt(i) - 48) * Math.pow(10, length - i - 1));

		
 	}
	if(decimal)
	{
		length=s.substring(s.indexOf('.')).length()-1;
		for(int i=0;i<length;i++){
			m +=(((int) s.charAt(s.indexOf('.')+1+i) - 48) * (int)Math.pow(10, ((length - i - 1))));
		}
	}
			System.out.println("value of m "+m);
			double laks = (m/(int)Math.pow(10, ((length))));
			laks =n+laks;
			System.out.println("value of floating "+(laks));	
			
			 
			
		}
}