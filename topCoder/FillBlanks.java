import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Set;


public class FillBlanks {



	public static void main(String[] args) {
		
		String [] rules = { "PICK ANY TWO: 10 2 F F","PICK TWO IN ORDER: 10 2 T F",
							"PICK TWO DIFFERENT: 10 2 F T","PICK TWO LIMITED: 10 2 T T"
						  };

		sortByOdds(rules);
	}



	public static void sortByOdds(String[] rules){

		//"PICK ANY TWO: 10 2 F F"

		SortedMap<String,Double> map = new TreeMap<String,Double>();
		for(String rule: rules){

			
			String name = rule.split(":")[0];
			String [] values = rule.split(":")[1].split("\\s");
			 

			Double N = Double.parseDouble(values[1]);
			Double BLANKS = Double.parseDouble(values[2]);
			boolean isSorted = values[3].equals("T");
			boolean isUnique = values[4].equals("T");

			System.out.printf(" %s, %f, %f, %b, %b \n", name, N, BLANKS, isSorted, isUnique);

			if(!isSorted && !isUnique){
				f
				double total = BLANKS*N;
				System.out.printf(" %f \n", total);
				map.put(name,total);
			}else if( !isSorted && isUnique){

				double total=1, start=N;
				for(double f=1;f<=BLANKS;f++){
					total *=start;
					start--;
				}
				System.out.printf(" %f \n", total);
				map.put(name,total);
				/*	
				n! * b!
				-- 
				(n-b)! * b!
				*/
			} else if(isSorted && isUnique){


				double total=1, start=N;
				for(double f=1;f<=BLANKS;f++){
					total *=start;
					start--;
				}
				for(double b=BLANKS;b>=1;b--){
					total/=b;
				}
				System.out.printf(" %f \n", total);
				map.put(name,total);
			} else {
				double total = sol2(BLANKS,N); 
				System.out.printf(" %f \n", total);
				map.put(name, total);
			}



		}

		Set<String> keys = map.keySet();
		for(String key:keys){
			System.out.printf(" %s > %f \n", key, map.get(key));
		}


	}

	private static double sol2(double BLANKS, double N){
		
	 
		double [][] dp = new double [(int)(N+1)][(int)(BLANKS+1)];
		 
 
		for(int i=1;i<=N;i++){
			dp[i][0] = 1;
			//System.out.printf("dp[%d][%d] = %d \n",i,0,dp[i][0]);
			//System.out.printf("dp[%d][%d] = %d\n",i,1,dp[i][1]);
			//sum+=i;
		}


	
 	

		//System.out.println("---");

		//System.out.println(dp.length +" and "+dp[0].length);
		
		for(int b=1;b<=BLANKS;b++){
			for(int i=(int)N;i>=1;i--){

				if(i+1>N){
 					dp[i][b] = dp[i][b-1];
 					//System.out.printf("dp[%d][%d] = dp[%d][%d] = %d \n",i,b,i,(b-1),dp[i][b-1]);
				}else{
					dp[i][b] =  dp[i+1][b] + dp[i][b-1];
					//System.out.printf("dp[%d][%d] = dp[%d][%d] + dp[%d][%d] = %d \n",i,b,(i+1),b,i,(b-1), (dp[i+1][b] + dp[i][b-1]));
				}
			}
		}
		//System.out.printf("dp[%d][%d]=%d\n",1,BLANKS,dp[(double)1][BLANKS]);
		return dp[1][(int)BLANKS];
	}

	 
}