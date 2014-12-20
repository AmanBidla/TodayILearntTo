import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{

private static String FORTYTWO = "42";

	public static void main(String[] args) {
		try{
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in ));
			String line ;
			while(  (line = buf.readLine()) != null ){
				if(!line.equals(FORTYTWO)){
					System.out.println(line);
				}else{
					break;
				}
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}