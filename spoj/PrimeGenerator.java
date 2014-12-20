import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class PrimeGenerator implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new PrimeGenerator(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter("output.txt");
                        Locale.setDefault(Locale.US);
                        solve();
                        in.close();
                        out.close();
                        long t2 = System.currentTimeMillis();
                        System.err.println("Time = " + (t2 - t1));
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

                int testCases = readInt();
                long [] answer = new long [ testCases*2];
                for(int t=0;t<testCases*2;t++){
                        answer[t]= readLong(); 
                }
                for(int t=0;t<answer.length;){
                        long m = answer[t];
                        t++;
                        long n = answer[t];
                        t++;
                        for(long i=m;i<=n;i++){
                            if(isPrime(i)){
                                System.out.println(i);
                            }
                        }
                        System.out.println();
                }                
        }

        public boolean isPrime(long x){

                if (x <= 1) return false;
                if (x <= 3) return true;
                if (x % 2 == 0) return false;
                if (x % 3 == 0) return false;
                long s = (long) (Math.sqrt( (double)x ) ) ;
                for (long i = 5; i <= s; i += 6){
                        if (x % i == 0) return false;
                        if (x % (i+2) == 0) return false;
                }
                return true;
  }
 
}