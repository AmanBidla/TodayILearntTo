import java.lang.Math;

public class ATOI{
	
		
		public static void main(String abd[]){
				
				double d = getATOI("-123.5");
				System.out.println(d);
		}
		
		public static double getATOI(String s){
			
			boolean isDecimal=false;
			boolean isNegative=false;
			String decimal="";
			int N=s.length();
			double d=0.0;
			
			if(s.contains(".")){
				
				isDecimal=true;
				decimal=s.substring(s.indexOf('.')+1);
				s=s.substring(0,s.indexOf('.'));
				N=s.length();
 			}
			
			if(s.charAt(0)=='-'){
				isNegative=true;
				s=s.substring(1);
				N=s.length();
			}
 			
			for(int i=N-1,t=10,j=0;i>=0;i--,j++){
				
				double v= (double) s.charAt(i)-48;
				double p =Math.pow(t,j);
 				d=d+v*p;
				
			}
 			
			if(isDecimal){
 					
					for( int i=0,j=-1,t=10;i<decimal.length();i++,j--){
					
					double v= (double) decimal.charAt(i)-48.0;
					double p = Math.pow(t,j);
 					d=d+v*p;
 				}	
			}
			
			if(isNegative){
				d=d*-1;
			}
			
			return d;
			
			
			
		}
	
}