import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
	   try{
	   		
	   		BufferedReader buf = new BufferedReader( new InputStreamReader ( System.in));
	   		int t = Integer.parseInt( buf.readLine());
	   		int [] array = new int[3*t];
	   		int index=0;
	   		for(int i=0;i<t;i++){
	   			array[index]= Integer.parseInt( buf.readLine());
	   		}
	   		int c=1;
	   		for( int i=0;i<3*t;i++){
 					
 				int m = array[i];
 				i++;
 				int n = array[i];
 				i++;
 				int p = array[i];
 				int v1=0;
 				v1 = (m>n)?m:n;
 				int v2=0;
 				v2= (v1<p)?v1:p;


 				System.out.println("Case "+c+" "+v2);
 				c++;

	   		}

	   }catch(IOException e){
	   	    System.out.println(e.toString());
	   }
		

	}
}