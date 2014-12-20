import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Main implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new Main(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
                        Locale.setDefault(Locale.US);
                        solve();
                        in.close();
                        out.close();
                        long t2 = System.currentTimeMillis();
                        //System.err.println("Time = " + (t2 - t1));
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
                
                 String [] cand ={"Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
                 int r=1;
                 int N = readInt();
                 while(r*5 < N){
                    N=N-(r*5);
                    r= r*2;
                 }
                 System.out.println( cand[ (N-1)/r]);

        }
 
}