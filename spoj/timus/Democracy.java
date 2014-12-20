import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Democracy{

private static String FORTYTWO = "42";

	public static void main(String[] args) {
		try{
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in ));
			String line =buf.readLine();
            int K = Integer.parseInt(line);
            line =buf.readLine();
            int [] array = new int[K];
            int sum=0;
            for(int i=0;i<K;i++){
            	array[i]=Integer.parseInt(line.split(" ")[i]);
            	sum+=array[i];
            }
            int half = sum/2+1;
            //System.out.println(Arrays.toString(array)+" "+"sum "+sum);
			sum=0;
            Arrays.sort(array);
            for(int i=0;i<=K/2;i++){
            	sum+=array[i]/2+1;
            }
            System.out.println(sum);             			 
		}catch(IOException e){
			System.out.println(e.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}