import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Two{

	public static void main(String[] args) {
		try{
			
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in));	
			String line = null;
			while(  (line = buf.readLine()) !=null){
				
				int n = Integer.parseInt(line);
				double E = Math.PI;
				System.out.printf("%.*lf\n",n,E);

			}


		}catch(IOException e){
			System.out.println(e.toString());
		}
		
	}
}