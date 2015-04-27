import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ARITH{

	public static void main(String[] args) {
		
		read();
	}

	private static void read(){

		try{


			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			String line = buf.readLine();
			int test = Integer.parseInt(line);

			for(int t=0;t<test;t++){

			    line = buf.readLine();
				char [] a1;
				char [] b1;
				System.out.println("line "+line);
				for(int i=0;i<line.length();i++){

					if(line.charAt(i)=='+'){
						a1=new char[i];
						for(int j=0;j<i;j++){
							a1[j]=line.charAt(j);
						}						 
						int L = line.length()-(i);
						b1=new char[line.length()-i];
						b1[0]='+';
						for(int j=i+1;j<line.length();j++){
							b1[(j-(i+1))+1]=line.charAt(j);
						}
						add(a1,b1);
						break;
					}

				}

			}

		}catch(IOException e){

		}

	}

	private static void add(char[] a1 , char []b1){

		System.out.println(new String(a1));
		System.out.println(new String(b1));
		
		


	}
}