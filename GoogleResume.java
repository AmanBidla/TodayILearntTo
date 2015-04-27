import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class GoogleResume{
	
	private static char o='0';
	private static char i='1';	
	private static char e='3';
	private static char a='4';
	private static char s='5';
	private static char g='6';	
	private static char t='7';

	public static void main(String[] args) {
		
		 

			
		try{
			BufferedReader buf = new BufferedReader(new FileReader("resume.txt"));	
			StringBuilder st = new StringBuilder();
			String line=null;
			while((line= buf.readLine())!=null){

				char [] array = line.toCharArray();
				for(int i=0;i<array.length;i++){
					if(array[i]=='o'){
						array[i]='0';
					}else if(array[i]=='i'){
						array[i]='1';
					}else if(array[i]=='e'){
						array[i]='3';
					}else if(array[i]=='a'){
						array[i]='4';
					}else if(array[i]=='s'){
						array[i]='5';
					}else if(array[i]=='g'){
						array[i]='6';
					}else if(array[i]=='t'){
						array[i]='7';
					}
				}

				st.append( new String(array)).append("\n");

			}
			 
			
			System.out.println("--------");
			System.out.println( st.toString());

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}

		 

		
		



	}



}