import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays; 
 
public class PrimeGenerator {
 
    public static void main (String[] args) throws java.lang.Exception
    {
        
       int limit =  32000;
       int [] array = new int[4000];
       int numprime=0;
       array[numprime++]=2;
       for(int i=3;i<=limit;i+=2){
            double cap = Math.sqrt(i)+1.0;
            boolean isPrime = true;
            for(int j=0;j<numprime;j++){
                if(j>=cap) break;
                if(i%array[j]==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                array[numprime++]=i;
            }
       }
       //System.out.println("num prime "+numprime);
     /*for(int i=0;i<20;i++){
        System.out.print(" array["+i+"] "+array[i]);
     }
     System.out.println("");
        */
       BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(buf.readLine());
       int [] input = new int[2*t];
       int index=0;
       for(int k=0;k<t;k++){
            String line = buf.readLine();
            int M = Integer.parseInt(line.split(" ")[0]);
            int N = Integer.parseInt(line.split(" ")[1]);             
            input[index]=M;
            index=index+1;
            input[index]=N;
            index=index+1;

        }
        index=0;         
       for(int k=0;k<t;k++){

            int M = input[index];
            index=index+1;
            int N = input[index];
            index=index+1;
            if(k>0){
                System.out.println("");
            }
            if(M<2) M=2;

            //System.out.println("max "+array[numprime-1]);

            boolean [] primeArray = new boolean[100001];
            for (int j = 0; j < 100001; j++) {
                primeArray[j] = true;
            }


            for(int i=0;i<numprime;i++){                
                int p = array[i];
                int start;

                if (p >= M) start = p*2;
                else start = M + ((p - M % p)%p);

                for (int j = start; j <= N; j += p) {
                    primeArray[j - M] = false;
                }
            }

             for (int i = M; i <= N; i++) {
                if (primeArray[i-M]) System.out.println(i);
            }
       } 
 
    }
  

}