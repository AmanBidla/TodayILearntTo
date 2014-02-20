
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class LCSCoderEval{	

	private static String x,y;

	public static void main(String []args){
    		readFile(args[0]); 
    		LCS(x,y);
	}

	public static void readFile(String fileName){
		try{
			Scanner sc = new Scanner (new File(fileName));
			while(sc.hasNext()){
				String words = sc.nextLine();
				x = words.split(";")[0];
				y = words.split(";")[1];

				
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}

	
	public static void LCS(String x, String y){
		
		int M = x.length();
		int N = y.length();
		
		int [][] dp = new int[M+1][N+1];
		
		
		 for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    dp[i][j] = dp[i+1][j+1] + 1;
                else 
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }


		int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (dp[i+1][j] >= dp[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();
	
		
	}
	
	
}