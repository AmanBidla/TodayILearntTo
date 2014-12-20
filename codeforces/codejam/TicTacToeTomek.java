import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Solution implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        if (System.getProperty("ONLINE_JUDGE") != null) {
                                in = new BufferedReader(new InputStreamReader(System.in));
                                out = new PrintWriter(System.out);
                        } else {
                                //in = new BufferedReader(new FileReader("A-small-practice.in"));
                                in = new BufferedReader(new FileReader("A-large-practice.in"));
                                //in = new BufferedReader(new FileReader("input.in"));
                                out = new PrintWriter("out.txt");
                        }
                        Locale.setDefault(Locale.US);
                        solve();
                        in.close();
                        out.close();
                        long t2 = System.currentTimeMillis();
//                        System.err.println("Time = " + (t2 - t1));
                } catch (Throwable t) {
                        t.printStackTrace(System.err);
                        System.exit(-1);
                }
        }
 
        String readString() throws IOException {
                while (!tok.hasMoreTokens()) {
                        tok = new StringTokenizer(in.readLine());
                }
                return tok.nextToken();
        }
 
        int readInt() throws IOException {
                return Integer.parseInt(readString());
        }
 
        long readLong() throws IOException {
                return Long.parseLong(readString());
        }
 
        double readDouble() throws IOException {
                return Double.parseDouble(readString());
        }
 
        // solution
 
        void solve() throws IOException {
                 int total = readInt();
                 int [][] matrix ;
                 int [] sol = new int[total];
                 boolean incomplete=false;
                 int count=0;
                 while(total>0){
                 		//System.out.println(count);
                 		matrix=new int[4][4];
	                 	for(int i=0;i<4;i++){
	                 		String line = readString();
	                 		//System.out.println("lien is "+line);
	                 		char [] array = line.toCharArray();
	                 		for(int j=0;j<4;j++){
	                 			if(array[j]=='.'){
	                 				matrix[i][j]=-10;
	                 				incomplete=true;
	                 			}else if(array[j]=='T'){
	                 				matrix[i][j]=5;
	                 			}else if(array[j]=='0'){
	                 				matrix[i][j]=0;
	                 			}else if(array[j]=='X'){
	                 				matrix[i][j]=1;
	                 			}
	                 		}
	                 	}
	                 	//show(matrix);
	                 	in.readLine();
	                 	int leftDiag=0,rsum=0;
	                 	for(int i=0;i<4;i++){
	                 		rsum=0;
	                 		for(int j=0;j<4;j++){
	                 			if(i==j){	
	                 				leftDiag+=matrix[i][j];
	                 			}
	                 			rsum+=matrix[i][j];	                 			
	                 		}
							//System.out.println("rsum "+rsum+" leftDiag "+leftDiag);
	                 		if(rsum==0||rsum==8||rsum==4||rsum==5){
	                 			break;
	                 		}
	                 	}
 						

	                 	int rightDiag=0,csum=0;
	                 	for(int i=0;i<4;i++){
	                 		csum=0;
	                 		for(int j=3;j>=0;j--){	                 		
	                 			if((i+j)==3){	                 				
	                 				rightDiag+=matrix[j][i];
	                 			}
	                 				csum+=matrix[j][i];	                 			
	                 		}
							//System.out.println("csum "+csum+" rightDiag "+rightDiag);
	                 		if(csum==0||csum==8||csum==5||csum==4){
	                 			break;
	                 		}
	                 	}
	                 	//System.out.println("rsum "+rsum+" leftDiag "+leftDiag);
	                 	//System.out.println("csum "+csum+" rightDiag "+ rightDiag);
	                 	//System.out.println("imcomplete "+incomplete);
	                 	if(csum==4||csum==8||leftDiag==4||leftDiag==8||rightDiag==4||rightDiag==8||rsum==4||rsum==8){
	                 		sol[count]=1;
	                 	}else if(csum==0||csum==5||leftDiag==0||leftDiag==5||rightDiag==0||rightDiag==5||rsum==5||rsum==0){
	                 		sol[count]=0;	     
	                 	}else if(incomplete){
	                 		sol[count]=3;	                 	
	                 	}else{
	                 		sol[count]=4;
	                 	}

 						total--;
 						count++;
 						incomplete=false;
                 }
                 //System.out.println(Arrays.toString(sol));                
                 for(int i=0;i<sol.length;i++){
                 	int team = sol[i];
                 	String sb="Case #"+(i+1)+": ";
                 	if(team==0){
                 		sb+="O won";
                 	}else if(team==1){
                 		sb+="X won";
                 	}else if(team==3){
                 		sb+="Game has not completed";
                 	}else if(team==4){
                 		sb+="Draw";
                 	}
                 	out.println(sb);
                 }
                                                 
        }
        public void show(int [][]matrix){
        	for(int i=0;i<4;i++){
        		for(int j=0;j<4;j++){
        			System.out.print(matrix[i][j]+" ");
        		}
        		System.out.println();
        	}
        }
 
}