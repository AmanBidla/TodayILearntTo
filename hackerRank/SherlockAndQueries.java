import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class SherlockAndQueries{

	private long [] A1;
	private	long  []B1;
	private long  []C1;

	private int N=0;
	private int M=0;

	public static void main(String[] args) {
		
		SherlockAndQueries sh = new SherlockAndQueries();
		sh.readFile(args[0]);
		//System.out.println("A is "+Arrays.toString(sh.A1));
		//System.out.println("B is "+Arrays.toString(sh.B1));
		//System.out.println("C is "+Arrays.toString(sh.C1));
		sh.solve();

	}

	public void solve(){

		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				//System.out.println(j+"%"+ B1[i]+" == 0 "+ (j%B1[i]==0));
				if((j+1)%B1[i]==0){
					A1[j]=A1[j] * C1[i];
					//System.out.println("A["+j+"] = "+A1[j]);
				}
			}
		}
		long mod = 1000000007;
		 for(int i=0;i<N;i++){
		 	//System.out.print("A["+i+"] : "+A1[i]+" and " +A1[i]%mod+" ");
		 	System.out.print(A1[i]%mod+" ");
		 }
		 System.out.println("");
		  
	}

	public  void readFile(String file){

		try{

			Scanner sc = new Scanner(new File(file));
			int count=0;

			while(sc.hasNext()){

				String st = sc.nextLine();
				if(count==0){
					N = Integer.parseInt(st.split(" ")[0]);
					M = Integer.parseInt(st.split(" ")[1]);
				}

				else if(count==1){
					A1 = new long[N];
					for(int i=0;i<N;i++){
						A1[i]= Long.parseLong(st.split(" ")[i]);
					}
				}

				else if(count==2){
					B1 = new long[M];
					for(int i=0;i<M;i++){
						B1[i]= Long.parseLong(st.split(" ")[i]);
					}
				}
				else if(count==3){
					C1 = new long[M];
					for(int i=0;i<M;i++){
						C1[i]= Long.parseLong(st.split(" ")[i]);
					}
				}

				count++;
			}


		}catch(Exception e){
			System.out.println(e.toString());
		}
		


	}



}