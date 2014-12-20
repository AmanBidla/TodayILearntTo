import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class One {

	public static void main(String[] args) {
		try{
			
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in));
			String line = null;
			while( (line = buf.readLine())!=null ){
				Double d = Double.parseDouble(line);
				System.out.printf("%7.3f\n",d);
			}

		}catch(IOException e){
			System.out.println(e.toString());
		}
		

	}
}