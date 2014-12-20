import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{

private static String FORTYTWO = "42";

	public static void main(String[] args) {
		try{
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in ));
			String line =buf.readLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            int sum=0;
            for(int i=a;i<=b;i++){
                sum+=i*i;
            }
            System.out.println(sum);			 
		}catch(IOException e){
			System.out.println(e.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}